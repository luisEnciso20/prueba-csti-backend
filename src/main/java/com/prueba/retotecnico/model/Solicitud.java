package com.prueba.retotecnico.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("solicitud")
public class Solicitud {
    @Id
    private Long id;
    private String codigoGenerado;
    private String marca;
    private String tipoSolicitud;
    private LocalDate fechaEnvio;
    private String numeroContacto;
    private String nombreContacto;
}