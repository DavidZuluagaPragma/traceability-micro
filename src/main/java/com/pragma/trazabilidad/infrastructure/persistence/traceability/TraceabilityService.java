package com.pragma.trazabilidad.infrastructure.persistence.traceability;

import com.pragma.trazabilidad.aplication.mapper.Mapper;
import com.pragma.trazabilidad.domain.model.Traceability;
import com.pragma.trazabilidad.domain.model.TraceabilityGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TraceabilityService implements TraceabilityGateway {

    @Autowired
    TraceabilityRepository traceabilityRepository;

    @Override
    public Mono<Traceability> createTraceability(Traceability traceability) {
        return Mono.fromCallable(() -> Mapper.traceabilityToTraceabilityData(traceability))
                .flatMap(traceabilityData -> traceabilityRepository.save(traceabilityData))
                .map(Mapper::traceabilityDataToTraceability);
    }

    @Override
    public Mono<Traceability> findTraceabilityByOrderId(Integer orderId) {
        return traceabilityRepository.findByOrderId(orderId)
                .defaultIfEmpty(TraceabilityData.builder().build())
                .map(Mapper::traceabilityDataToTraceability);
    }

    @Override
    public Flux<Traceability> findAllByNewStatusIsLike(String status) {
        return traceabilityRepository.findAllByNewStatusIsLike(status)
                .map(Mapper::traceabilityDataToTraceability);
    }
}
