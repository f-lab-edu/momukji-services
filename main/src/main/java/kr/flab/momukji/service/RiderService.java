package kr.flab.momukji.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import kr.flab.momukji.dto.request.RiderDto;
import kr.flab.momukji.dto.response.common.CommonResponse;
import kr.flab.momukji.dto.response.common.ResultCode;
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
        
        if (token.isEmpty()) {
            return new CommonResponse(ResultCode.LOGIN_REQUIRED);
        }
        
        String email = new SecurityUtil().getEmailByToken(token);
        Optional<Rider> optRider = getRiderByUserEmail(email);
        if (optRider.isEmpty()) {
            return new CommonResponse(ResultCode.INVALID_ACCOUNT);
        }

        Rider rider = optRider.get();
        return orderService.changeOrderInfoForRider(riderDto.getOrderId(), rider);
    }

    public Optional<Rider> getRiderByUserEmail(String userEmail) {
        return riderRepository.findByUserEmail(userEmail);
    }
}

