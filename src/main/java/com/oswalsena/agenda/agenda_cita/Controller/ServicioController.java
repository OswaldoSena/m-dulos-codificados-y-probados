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
import com.oswalsena.agenda.agenda_cita.Entities.Servicio;
import com.oswalsena.agenda.agenda_cita.Repositories.ServicioRepository;


//protocolo de HTTP 

@RestController
@RequestMapping("/Servicio")

public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;
// mapeo de tablas hibernate
    @GetMapping
    public List<Servicio> getAllServicio() {
        return servicioRepository.findAll();
    }
    @GetMapping("/{id}")
    public Servicio getServicioById(@PathVariable Long id) {
        return servicioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontró el servicio con ID: " + id));
    }

    @PostMapping
    public Servicio createServicio(@RequestBody Servicio servicio) {
        return servicioRepository.save(servicio);
    }
    
    @PutMapping("/{id}")
    public Servicio updateServivio(@PathVariable Long id, @RequestBody Servicio detalleServicio) {
        Servicio servicio = servicioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontró el servicio con ID: " + id));
    
        servicio.setNombre(detalleServicio.getNombre());
        servicio.setPrecio(detalleServicio.getPrecio());
        servicio.setOrden(detalleServicio.getOrden());

        return servicioRepository.save(servicio);
    }

    @DeleteMapping("/{id}")
    public String deleteServicio(@PathVariable Long id) {
        Servicio servicio = servicioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontró el servicio con ID: " + id));
        
        servicioRepository.delete(servicio);
        return "El servicio con ID; " + id + " fue eliminado correctamente";
    }

}
