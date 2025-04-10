package com.prueba.retotecnico.repository;

import com.prueba.retotecnico.model.Solicitud;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudRepository extends ReactiveCrudRepository<Solicitud, Long> {
}
