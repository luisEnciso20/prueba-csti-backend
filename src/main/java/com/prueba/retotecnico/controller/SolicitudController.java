package com.prueba.retotecnico.controller;

import com.prueba.retotecnico.model.Contacto;
import com.prueba.retotecnico.model.Solicitud;
import com.prueba.retotecnico.service.SolicitudService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudService solicitudService;

    @PostMapping
    public Mono<Solicitud> crearSolicitud(@RequestBody SolicitudRequest request) {
        return solicitudService.crearSolicitud(request.getSolicitud(), request.getContactos());
    }

    @GetMapping
    public Flux<Solicitud> listarSolicitudes() {
        return solicitudService.listarSolicitudes();
    }

    @GetMapping("/{id}")
    public Mono<Solicitud> obtenerSolicitud(@PathVariable Long id) {
        return solicitudService.obtenerSolicitud(id);
    }

    @GetMapping("/{id}/contactos")
    public Flux<Contacto> obtenerContactos(@PathVariable Long id) {
        return solicitudService.obtenerContactosPorSolicitud(id);
    }

    @Data
    static class SolicitudRequest {
        private Solicitud solicitud;
        private List<Contacto> contactos;
    }
}
