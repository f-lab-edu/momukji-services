package kr.flab.momukji.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import kr.flab.momukji.dto.request.OrderDto;
import kr.flab.momukji.dto.response.common.CommonResponse;
import kr.flab.momukji.dto.response.common.ResultCode;
import kr.flab.momukji.entity.Order;
import kr.flab.momukji.entity.Product;
import kr.flab.momukji.entity.Rider;
import kr.flab.momukji.entity.Store;
import kr.flab.momukji.repository.OrderRepository;
import kr.flab.momukji.util.SecurityUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final StoreService storeService;
    private final ProductService productService;
    
    private final OrderRepository orderRepository;

    public CommonResponse order(@Valid @RequestBody OrderDto orderDto, String token) {
        if (token.isEmpty()) {
            return new CommonResponse(ResultCode.LOGIN_REQUIRED);
        }

        Optional<Store> optStore = storeService.getStoreById(orderDto.getStoreId());
        if (optStore.isEmpty()) {
            return new CommonResponse(ResultCode.INVALID_STORE_ID);
        }

        String email = new SecurityUtil().getEmailByToken(token);
        Store store = optStore.get();
        if (!store.getUserEmail().equals(email)) {
            return new CommonResponse(ResultCode.INVALID_ACCOUNT);
        }

        Set<Product> products = new HashSet<>();
        for (Long productId : orderDto.getProductIds()) {
            Optional<Product> optProduct = productService.getProductById(productId);
            if (optProduct.isEmpty()) {
                return new CommonResponse(ResultCode.INVALID_PRODUCT_ID);
            }
            products.add(optProduct.get());
        }

        Order order = Order.builder()
            .store(store)
            .userEmail(new SecurityUtil().getEmailByToken(token))
            .status(OrderStatus.PENDING.getStatusCode())
            .isDelivery(orderDto.isDelivery())
            .message(orderDto.getMessage())
            .products(products)
            .build();

        orderRepository.save(order);
        
        return new CommonResponse();
    }
    
    public CommonResponse changeOrderInfoForRider(Long orderId, Rider rider) {
        Order order = getOrderById(orderId).get();
        order.setRider(rider);
        order.setStatus(OrderStatus.RIDER_ACCEPTED.getStatusCode());
        orderRepository.save(order);

        return new CommonResponse();
    }

    public CommonResponse pickUp(Long orderId, String token) {
        if (token.isEmpty()) {
            return new CommonResponse(ResultCode.LOGIN_REQUIRED);
        }
        
        String email = new SecurityUtil().getEmailByToken(token);
        Order order = getOrderById(orderId).get();
        if (!order.getUserEmail().equals(email)) {
            return new CommonResponse(ResultCode.INVALID_ACCOUNT);
        }

        order.setStatus(OrderStatus.PICKUPED.getStatusCode());
        order.setPickupedTimestamp(LocalDateTime.now());
        orderRepository.save(order);

        return new CommonResponse();
    }

    public CommonResponse completeOrder(Long orderId, String token) {
        if (token.isEmpty()) {
            return new CommonResponse(ResultCode.LOGIN_REQUIRED);
        }

        String email = new SecurityUtil().getEmailByToken(token);
        Order order = getOrderById(orderId).get();
        if (!order.getUserEmail().equals(email)) {
            return new CommonResponse(ResultCode.INVALID_ACCOUNT);
        }

        order.setStatus(OrderStatus.COMPLETED.getStatusCode());
        order.setCompletedTimestamp(LocalDateTime.now());
        orderRepository.save(order);

        return new CommonResponse();
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public CommonResponse acceptOrder(Long orderId, Long estimatedMinutes, String token) {
        if (token.isEmpty()) {
            return new CommonResponse(ResultCode.LOGIN_REQUIRED);
        }

        Optional<Order> optOrder = getOrderById(orderId);
        if (optOrder.isEmpty()) {
            return new CommonResponse(ResultCode.INVALID_ORDER_ID);
        }
        
        String email = new SecurityUtil().getEmailByToken(token);
        Order order = optOrder.get();
        if (!order.getUserEmail().equals(email)) {
            return new CommonResponse(ResultCode.INVALID_ACCOUNT);
        }

        order.setStatus(OrderStatus.ACCEPTED.getStatusCode());
        order.setEstimatedMinutes(estimatedMinutes);
        order.setAcceptedTimestamp(LocalDateTime.now());
        orderRepository.save(order);
        
        return new CommonResponse();
    }
    

    public CommonResponse requestRider(Long orderId, String token) {
        if (token.isEmpty()) {
            return new CommonResponse(ResultCode.LOGIN_REQUIRED);
        }

        Optional<Order> optOrder = getOrderById(orderId);
        if (optOrder.isEmpty()) {
            return new CommonResponse(ResultCode.INVALID_ORDER_ID);
        }
        
        String email = new SecurityUtil().getEmailByToken(token);
        Order order = optOrder.get();
        if (!order.getUserEmail().equals(email)) {
            return new CommonResponse(ResultCode.INVALID_ACCOUNT);
        }

        order.setStatus(OrderStatus.RIDER_ACCEPTED.getStatusCode());
        orderRepository.save(order);
        
        return new CommonResponse();
    }

    enum OrderStatus {
        PENDING(0L), ACCEPTED(1L), RIDER_REQUESTED(2L), COOKED(3L), RIDER_ACCEPTED(4L), PICKUPED(5L), COMPLETED(4L), CANCELED(-1L);

        private Long statusCode;

        private OrderStatus(Long statusCode) {
            this.statusCode = statusCode;
        }

        public Long getStatusCode() {
            return statusCode;
        }
    }
}
