package kr.flab.momukji.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.flab.momukji.dto.request.OrderDto;
import kr.flab.momukji.dto.response.common.CommonResponse;
import kr.flab.momukji.service.OrderService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerController {
    
    private final OrderService orderService;

    @PostMapping("/order")
    public CommonResponse order(@RequestBody OrderDto orderDto, @RequestHeader("Token") String token) {
        return orderService.order(orderDto, token);
    }

}
