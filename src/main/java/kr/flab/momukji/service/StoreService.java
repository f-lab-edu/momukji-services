package kr.flab.momukji.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.flab.momukji.entity.Store;
import kr.flab.momukji.repository.StoreRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final OrderService orderService;
    
    private final StoreRepository storeRepository;

    public Optional<Store> getStoreById(Long storeId) {
        return storeRepository.findById(storeId);
    }

    public boolean acceptOrder(Long orderId, Long estimatedMinutes) {
        return orderService.updateOrderAccepted(orderId, estimatedMinutes);
    }

}
