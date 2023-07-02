package com.pragma.trazabilidad.domain.usecase;

import com.pragma.trazabilidad.aplication.mapper.Mapper;
import com.pragma.trazabilidad.aplication.dto.TraceabilityRequestDto;
import com.pragma.trazabilidad.aplication.utils.Utils;
import com.pragma.trazabilidad.domain.model.Traceability;
import com.pragma.trazabilidad.domain.model.TraceabilityGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
public class TraceabilityUseCase {

    @Autowired
    TraceabilityGateway traceabilityGateway;

    private static final String PEDIDO_ENTREGADO = "ENTREGADO";

    public Mono<Traceability> createTraceabilityForOrder(TraceabilityRequestDto traceabilityRequestDto) {
        return traceabilityGateway.findTraceabilityByOrderId(traceabilityRequestDto.getOrderId())
                .flatMap(traceability -> {
                    if (traceability.getId() != null) {
                        return traceabilityGateway.createTraceability(traceability.toBuilder()
                                .newStatus(Utils.isNull(traceability.getNewStatus(), traceabilityRequestDto.getNewStatus()))
                                .oldStatus(traceability.getNewStatus())
                                .clientEmail(Utils.isNull(traceability.getClientEmail(), traceabilityRequestDto.getClientEmail()))
                                .employedId(Utils.isNull(traceability.getEmployedId(), traceabilityRequestDto.getEmployedId()))
                                .employedEmail(Utils.isNull(traceability.getEmployedEmail(), traceabilityRequestDto.getEmployedEmail()))
                                .date(new Date())
                                .build());
                    }
                    return Mono.fromCallable(() -> Mapper.traceabilityDtoToTraceability(traceabilityRequestDto))
                            .flatMap(newtraceability -> traceabilityGateway.createTraceability(newtraceability));
                });
    }

    public Mono<Traceability> getTraceabilityForOrderId(Integer orderId) {
        return traceabilityGateway.findTraceabilityByOrderId(orderId);
    }

    public Flux<Traceability> getAllCompletedTraceability() {
        return traceabilityGateway.findAllByNewStatusIsLike(PEDIDO_ENTREGADO);
    }
}
