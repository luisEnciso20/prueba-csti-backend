package com.prueba.retotecnico.service;

import com.prueba.retotecnico.model.Contacto;
import com.prueba.retotecnico.model.Solicitud;
import com.prueba.retotecnico.repository.ContactoRepository;
import com.prueba.retotecnico.repository.SolicitudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SolicitudService {

    private final SolicitudRepository solicitudRepo;
    private final ContactoRepository contactoRepo;

    public Mono<Solicitud> crearSolicitud(Solicitud solicitud, List<Contacto> contactos) {
        solicitud.setCodigoGenerado(UUID.randomUUID().toString().substring(0, 8));
        return solicitudRepo.save(solicitud)
                .flatMap(saved -> Flux.fromIterable(contactos)
                        .doOnNext(c -> c.setSolicitudId(saved.getId()))
                        .flatMap(contactoRepo::save)
                        .then(Mono.just(saved)));
    }

    public Flux<Solicitud> listarSolicitudes() {
        return solicitudRepo.findAll();
    }

    public Mono<Solicitud> obtenerSolicitud(Long id) {
        return solicitudRepo.findById(id);
    }

    public Flux<Contacto> obtenerContactosPorSolicitud(Long solicitudId) {
        return contactoRepo.findAllBySolicitudId(solicitudId);
    }
}
