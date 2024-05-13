package com.oswalsena.agenda.agenda_cita.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oswalsena.agenda.agenda_cita.Entities.Cita;
// interface del tipo de entidad y tipo de identificador
public interface CitaRepository extends JpaRepository<Cita, Long> {

}
