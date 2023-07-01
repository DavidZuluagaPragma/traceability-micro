package com.pragma.trazabilidad.aplication.mapper;

import com.pragma.trazabilidad.aplication.dto.TraceabilityRequestDto;
import com.pragma.trazabilidad.domain.model.Traceability;
import com.pragma.trazabilidad.infrastructure.persistence.traceability.TraceabilityData;

import java.util.Date;

public class Mapper {

    public static TraceabilityData traceabilityToTraceabilityData(Traceability traceability) {
        return TraceabilityData.builder()
                .id(traceability.getId())
                .clientEmail(traceability.getClientEmail())
                .clientId(traceability.getClientId())
                .date(traceability.getDate())
                .employedEmail(traceability.getEmployedEmail())
                .employedId(traceability.getEmployedId())
                .newStatus(traceability.getNewStatus())
                .oldStatus(traceability.getOldStatus())
                .orderId(traceability.getOrderId())
                .build();
    }

    public static Traceability traceabilityDataToTraceability(TraceabilityData traceabilityData) {
        return Traceability.builder()
                .id(traceabilityData.getId())
                .clientEmail(traceabilityData.getClientEmail())
                .clientId(traceabilityData.getClientId())
                .date(traceabilityData.getDate())
                .employedEmail(traceabilityData.getEmployedEmail())
                .employedId(traceabilityData.getEmployedId())
                .newStatus(traceabilityData.getNewStatus())
                .oldStatus(traceabilityData.getOldStatus())
                .orderId(traceabilityData.getOrderId())
                .build();
    }

    public static Traceability traceabilityDtoToTraceability(TraceabilityRequestDto traceabilityRequestDto) {
        return Traceability.builder()
                .clientEmail(traceabilityRequestDto.getClientEmail())
                .clientId(traceabilityRequestDto.getClientId())
                .employedEmail(traceabilityRequestDto.getEmployedEmail())
                .employedId(traceabilityRequestDto.getEmployedId())
                .newStatus(traceabilityRequestDto.getNewStatus())
                .orderId(traceabilityRequestDto.getOrderId())
                .date(new Date())
                .build();
    }

}
