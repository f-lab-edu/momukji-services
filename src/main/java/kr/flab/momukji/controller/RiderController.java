package kr.flab.momukji.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.flab.momukji.dto.response.common.CommonResponse;
import kr.flab.momukji.service.RiderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/apiRider")
@RequiredArgsConstructor
public class RiderController {
    
    private final RiderService riderService;

    @PutMapping("/acceptRider")
    @PreAuthorize("hasAnyRole('RIDER')")
    public CommonResponse acceptDelivery(Long orderId, Long userId) {
        return riderService.accecptDelivery(orderId,userId);
    }
}

