package com.facens.petcare.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String diagnostico;
    private String tratamento;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;
}