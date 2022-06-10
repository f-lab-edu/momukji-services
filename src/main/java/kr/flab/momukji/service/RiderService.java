package kr.flab.momukji.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import kr.flab.momukji.dto.request.AcceptRiderDto;
import kr.flab.momukji.dto.response.common.CommonResponse;
import kr.flab.momukji.entity.Rider;
import kr.flab.momukji.repository.RiderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RiderService {

    private final UserService userService;
    private final OrderService orderService;
    
    private final RiderRepository riderRepository;

    public CommonResponse accecptDelivery(@Valid @RequestBody AcceptRiderDto acceptRiderDto) {
      
        Rider rider = getRiderById(userService.getMyUserWithAuthorities().getId()).get();
        return orderService.changeOrderInfoForRider(acceptRiderDto.getOrderId(), rider);
    }

    public Optional<Rider> getRiderById(Long riderId) {
        return riderRepository.findById(riderId);
    }
}

