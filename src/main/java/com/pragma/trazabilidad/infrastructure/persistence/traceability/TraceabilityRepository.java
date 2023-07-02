package com.pragma.trazabilidad.infrastructure.persistence.traceability;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TraceabilityRepository extends ReactiveMongoRepository<TraceabilityData, String> {
    Mono<TraceabilityData> findByOrderId(Integer orderId);
    Flux<TraceabilityData> findAllByNewStatusIsLike(String status);
}
