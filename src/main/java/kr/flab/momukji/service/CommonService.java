package kr.flab.momukji.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.flab.momukji.entity.Order;
import kr.flab.momukji.entity.Product;
import kr.flab.momukji.entity.Rider;
import kr.flab.momukji.entity.Store;
import kr.flab.momukji.repository.OrderRepository;
import kr.flab.momukji.repository.ProductRepository;
import kr.flab.momukji.repository.RiderRepository;
import kr.flab.momukji.repository.StoreRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final RiderRepository riderRepository;
    private final StoreRepository storeRepository;

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Optional<Rider> getRiderById(Long id) {
        return riderRepository.findById(id);
    }

    public Optional<Store> getStoreById(Long id) {
        return storeRepository.findById(id);
    }

}
