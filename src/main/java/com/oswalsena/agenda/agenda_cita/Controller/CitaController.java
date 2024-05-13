package com.oswalsena.agenda.agenda_cita.Controller;
//importaciones de librerias
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.oswalsena.agenda.agenda_cita.Entities.Cita;
import com.oswalsena.agenda.agenda_cita.Repositories.CitaRepository;


//protocolo de HTTP 

@RestController
@RequestMapping("/Cita")

public class CitaController {

    @Autowired
    private CitaRepository citaRepository;
// mapeo de tablas hibernate
    @GetMapping
    public List<Cita> getAllCita() {
        return citaRepository.findAll();
    }
    @GetMapping("/{id}")
    public Cita getCitaById(@PathVariable Long id) {
        return citaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontró la cita con ID: " + id));
    }

    @PostMapping
    public Cita createCita(@RequestBody Cita cita) {
        return citaRepository.save(cita);
    }
    
    @PutMapping("/{id}")
    public Cita updateServivio(@PathVariable Long id, @RequestBody Cita detalleCita) {
        Cita cita = citaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontró la cita con ID: " + id));
    
        cita.setNombreEquipo(detalleCita.getNombreEquipo());
        cita.setMarca(detalleCita.getMarca());
        cita.setModelo(detalleCita.getModelo());
        cita.setFecheCita(detalleCita.getFechaCita());

        return citaRepository.save(cita);
    }

    @DeleteMapping("/{id}")
    public String deleteCita(@PathVariable Long id) {
        Cita cita = citaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontró la cita con ID: " + id));
        
        citaRepository.delete(cita);
        return "Su cita con ID; " + id + " fue eliminado correctamente";
    }

}
