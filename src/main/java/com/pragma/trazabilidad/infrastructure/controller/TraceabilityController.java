package com.pragma.trazabilidad.infrastructure.controller;

import com.pragma.trazabilidad.aplication.dto.TraceabilityRequestDto;
import com.pragma.trazabilidad.domain.model.Traceability;
import com.pragma.trazabilidad.domain.usecase.TraceabilityUseCase;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/traceability")
public class TraceabilityController {

    @Autowired
    TraceabilityUseCase traceabilityUseCase;

    @PostMapping()
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public Mono<Traceability> createTraceabilityForOrder(@RequestBody TraceabilityRequestDto traceabilityRequestDto){
        return traceabilityUseCase.createTraceabilityForOrder(traceabilityRequestDto);
    }

    @GetMapping("/{orderId}")
    @PreAuthorize("hasAuthority('CLIENT')")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public Mono<Traceability> getTraceabilityForOrderId(@PathVariable Integer orderId){
        return traceabilityUseCase.getTraceabilityForOrderId(orderId);
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('OWNER')")
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public Flux<Traceability> getAllCompletedTraceability(){
        return traceabilityUseCase.getAllCompletedTraceability();
    }

}
