package com.prueba.retotecnico.repository;

import com.prueba.retotecnico.model.Contacto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ContactoRepository extends ReactiveCrudRepository<Contacto, Long> {
    Flux<Contacto> findAllBySolicitudId(Long solicitudId);
}
