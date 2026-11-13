package mx.edu.utez.rsss_irvin_abarca_cc7.controller.ordenservicio;

import jakarta.validation.Valid;
import mx.edu.utez.rsss_irvin_abarca_cc7.controller.ordenservicio.dto.ActualizarCostoOrdenDTO;
import mx.edu.utez.rsss_irvin_abarca_cc7.controller.ordenservicio.dto.CrearOrdenServicioDTO;
import mx.edu.utez.rsss_irvin_abarca_cc7.controller.ordenservicio.dto.FinalizarOrdenDTO;
import mx.edu.utez.rsss_irvin_abarca_cc7.model.ordenservicio.OrdenServicio;
import mx.edu.utez.rsss_irvin_abarca_cc7.service.ordenservicio.OrdenServicioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenservicio")
@CrossOrigin("*")
public class OrdenServicioController {
    private final OrdenServicioService ordenServicioService;

    public OrdenServicioController(OrdenServicioService ordenServicioService) {
        this.ordenServicioService = ordenServicioService;
    }
    @PostMapping("/crearorden")
    public ResponseEntity<OrdenServicio> crearOrden(@RequestBody @Valid CrearOrdenServicioDTO payload) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ordenServicioService.crearOrden(payload));
    }

    @PatchMapping("/actualizarCosto")
    public ResponseEntity<OrdenServicio> actualizarCosto(@RequestBody @Valid ActualizarCostoOrdenDTO payload) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ordenServicioService.actualizarCosto(payload));
    }
    @PatchMapping("/finalizarOrden")
    public ResponseEntity<OrdenServicio> finalizarOrde(@RequestBody @Valid FinalizarOrdenDTO payload) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ordenServicioService.finalizarOrden(payload));
    }


    @GetMapping("/listas-ordenes")
    public ResponseEntity<List<OrdenServicio>> listarOrdenesAtivas() {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ordenServicioService.listasOrdenesActivas());
    }

}
