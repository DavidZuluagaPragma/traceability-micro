package com.pragma.trazabilidad.infrastructure.persistence.traceability;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document()
@Builder(toBuilder = true)
public class TraceabilityData {

    @Id
    private String id;
    private Integer orderId;
    private Integer clientId;
    private String clientEmail;
    private Date date;
    private String oldStatus;
    private String newStatus;
    private Integer employedId;
    private String employedEmail;
}
