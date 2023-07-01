package com.pragma.trazabilidad.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Traceability {
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
