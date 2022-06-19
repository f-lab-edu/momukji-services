package kr.flab.momukji.controller;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.flab.momukji.dto.request.AcceptOrderDto;
import kr.flab.momukji.dto.response.common.CommonResponse;
import kr.flab.momukji.service.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StoreController {
    private final OrderService orderService;

    @PutMapping("/acceptOrder")
    @PreAuthorize("hasAnyRole('USER')")
    public CommonResponse acceptOrder(@Valid @RequestBody AcceptOrderDto acceptDto) {
        return orderService.acceptOrder(acceptDto.getOrderId(), acceptDto.getEstimatedMinutes());
    }
}
