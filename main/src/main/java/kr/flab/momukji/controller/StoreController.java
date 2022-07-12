package kr.flab.momukji.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.flab.momukji.dto.request.AcceptOrderDto;
import kr.flab.momukji.dto.request.RequestRiderDto;
import kr.flab.momukji.dto.response.common.CommonResponse;
import kr.flab.momukji.service.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StoreController {
    
    private final OrderService orderService;

    @PutMapping("/acceptOrder")
    public CommonResponse acceptOrder(@Valid @RequestBody AcceptOrderDto acceptDto, @RequestHeader("Token") String token) {
        return orderService.acceptOrder(acceptDto.getOrderId(), acceptDto.getEstimatedMinutes(), token);
    }

    @PutMapping("/requestRider")
    public CommonResponse requestRider(@Valid @RequestBody RequestRiderDto requestDto, @RequestHeader("Token") String token) {
        return orderService.requestRider(requestDto.getOrderId(), token);
    }

}
