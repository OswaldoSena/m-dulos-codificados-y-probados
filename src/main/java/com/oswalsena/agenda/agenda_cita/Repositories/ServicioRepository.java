package com.oswalsena.agenda.agenda_cita.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oswalsena.agenda.agenda_cita.Entities.Servicio;
// interface del tipo de entidad y tipo de identificador
public interface ServicioRepository extends JpaRepository<Servicio, Long> {

}
