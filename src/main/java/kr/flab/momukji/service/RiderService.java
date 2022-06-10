package kr.flab.momukji.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.flab.momukji.dto.response.common.CommonResponse;
import kr.flab.momukji.entity.Rider;
import kr.flab.momukji.repository.RiderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RiderService {

    private final OrderService orderService;
    
    private final RiderRepository riderRepository;

    public CommonResponse accecptDelivery(Long orderId, Long userId) {
        Rider rider = getRiderById(userId).get();
        return orderService.changeOrderInfoForRider(orderId, rider);
    }

    public Optional<Rider> getRiderById(Long riderId) {
        return riderRepository.findById(riderId);
    }
}
