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
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserService userService;
    private final StoreService storeService;
    private final ProductService productService;
    
    private final OrderRepository orderRepository;

    public CommonResponse order(@Valid @RequestBody OrderDto orderDto) {
        Optional<Store> optStore = storeService.getStoreById(orderDto.getStoreId());
        if (optStore.isEmpty()) {
            return new CommonResponse(ResultCode.INVALID_STORE_ID);
        }
        Store store = optStore.get();

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
            .user(userService.getMyUserWithAuthorities())
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

    public CommonResponse pickUp(Long orderId) {
        Order order = getOrderById(orderId).get();
        order.setStatus(OrderStatus.PICKUPED.getStatusCode());
        order.setPickupedTimestamp(LocalDateTime.now());
        orderRepository.save(order);

        return new CommonResponse();
    }

    public CommonResponse completeOrder(Long orderId) {
        Order order = getOrderById(orderId).get();
        order.setStatus(OrderStatus.COMPLETED.getStatusCode());
        order.setCompletedTimestamp(LocalDateTime.now());
        orderRepository.save(order);

        return new CommonResponse();
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
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
