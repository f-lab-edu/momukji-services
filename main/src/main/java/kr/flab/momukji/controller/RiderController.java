package kr.flab.momukji.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.flab.momukji.dto.request.RiderDto;

import kr.flab.momukji.dto.response.common.CommonResponse;
import kr.flab.momukji.service.OrderService;
import kr.flab.momukji.service.RiderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RiderController {
    
    private final RiderService riderService;
    private final OrderService orderService;

    @PutMapping("/acceptRider")
    public CommonResponse acceptDelivery(@RequestBody RiderDto riderDto, @RequestHeader("Token") String token) {
        return riderService.accecptDelivery(riderDto, token);
    }

    @PutMapping("/pickUpRider")
    public CommonResponse pickUp(@RequestBody RiderDto riderDto, @RequestHeader("Token") String token) {
        return orderService.pickUp(riderDto.getOrderId(), token);
    }

    @PutMapping("/completeOrder")
    public CommonResponse completeOrder(@RequestBody RiderDto riderDto, @RequestHeader("Token") String token) {
        return orderService.completeOrder(riderDto.getOrderId(), token);
    }
}

