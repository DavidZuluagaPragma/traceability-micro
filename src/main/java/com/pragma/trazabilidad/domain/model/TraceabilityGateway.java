package com.pragma.trazabilidad.domain.model;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface TraceabilityGateway {
    Mono<Traceability> createTraceability(Traceability traceability);
    Mono<Traceability> findTraceabilityByOrderId(Integer orderId);
}
