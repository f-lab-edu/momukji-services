package kr.flab.momukji.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import kr.flab.momukji.dto.request.RiderDto;
import kr.flab.momukji.dto.response.common.CommonResponse;
import kr.flab.momukji.entity.Rider;
import kr.flab.momukji.repository.RiderRepository;
import kr.flab.momukji.util.SecurityUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RiderService {

    private final OrderService orderService;
    
    private final RiderRepository riderRepository;

    public CommonResponse accecptDelivery(@Valid @RequestBody RiderDto riderDto, String token) {
        Rider rider = getRiderByUserId(new SecurityUtil().getEmailByToken(token)).get();
        return orderService.changeOrderInfoForRider(riderDto.getOrderId(), rider);
    }

    public Optional<Rider> getRiderByUserId(String userId) {
        return riderRepository.findByUserId(userId);
    }
}

