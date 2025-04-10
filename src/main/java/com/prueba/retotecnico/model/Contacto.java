package com.prueba.retotecnico.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("contacto")
public class Contacto {
    @Id
    private Long id;
    private Long solicitudId;
    private String nombre;
    private String numero;
}