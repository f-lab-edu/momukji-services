package kr.flab.momukji.controller;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.flab.momukji.dto.request.AcceptOrderDto;
import kr.flab.momukji.dto.request.RequestRiderDto;
import kr.flab.momukji.dto.response.common.CommonResponse;
import kr.flab.momukji.dto.response.common.ResultCode;
import kr.flab.momukji.service.OrderService;
import kr.flab.momukji.service.StoreService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;
    private final OrderService orderService;

    @PutMapping("/acceptOrder")
    @PreAuthorize("hasAnyRole('USER')")
    public CommonResponse acceptOrder(@Valid @RequestBody AcceptOrderDto acceptDto) {
        return orderService.acceptOrder(acceptDto.getOrderId(), acceptDto.getEstimatedMinutes());
    }

    @PutMapping("/requestRider")
    @PreAuthorize("hasAnyRole('USER')")
    public CommonResponse requestRider(@Valid @RequestBody RequestRiderDto requestDto) {
        final boolean INVALID_ORDER_ID = false;

        Long orderId = requestDto.getOrderId();
        if (storeService.requestRider(orderId) == INVALID_ORDER_ID) {
            return new CommonResponse(ResultCode.INVALID_ORDER_ID);
        }

        return new CommonResponse();
    }

}
