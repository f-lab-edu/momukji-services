package kr.flab.momukji.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.flab.momukji.dto.request.RiderDto;

import kr.flab.momukji.dto.response.common.CommonResponse;
import kr.flab.momukji.service.RiderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/apiRider")
@RequiredArgsConstructor
public class RiderController {
    
    private final RiderService riderService;

    @PutMapping("/acceptRider")
    @PreAuthorize("hasAnyRole('USER')")
    public CommonResponse acceptDelivery(@RequestBody RiderDto riderDto) {
        return riderService.accecptDelivery(riderDto);
    }

    @PutMapping("/pickUpRider")
    @PreAuthorize("hasAnyRole('USER')")
    public CommonResponse pickUp(@RequestBody RiderDto riderDto) {
        System.out.println(riderDto);
        return riderService.pickUp(riderDto);
    }
}

