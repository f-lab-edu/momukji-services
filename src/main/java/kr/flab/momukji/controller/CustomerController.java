package kr.flab.momukji.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.flab.momukji.dto.request.OrderDto;
import kr.flab.momukji.dto.response.common.CommonResponse;
import kr.flab.momukji.service.OrderService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomerController {
    
    private final OrderService orderService;

    @PostMapping("/order")
    @PreAuthorize("hasAnyRole('USER')")
    public CommonResponse order(@RequestBody OrderDto orderDto) {
        return orderService.order(orderDto);
    }

}
