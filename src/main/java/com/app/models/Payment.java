package com.app.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Payment {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private EPayment payment;
}
