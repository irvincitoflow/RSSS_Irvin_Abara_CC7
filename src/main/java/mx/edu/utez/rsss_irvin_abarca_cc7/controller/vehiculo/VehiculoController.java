package mx.edu.utez.rsss_irvin_abarca_cc7.controller.vehiculo;

import jakarta.validation.Valid;
import mx.edu.utez.rsss_irvin_abarca_cc7.controller.vehiculo.dto.DesactivarVehiculoDTO;
import mx.edu.utez.rsss_irvin_abarca_cc7.controller.vehiculo.dto.RegistrarVehiculoDTO;
import mx.edu.utez.rsss_irvin_abarca_cc7.model.ordenservicio.OrdenServicio;
import mx.edu.utez.rsss_irvin_abarca_cc7.model.vehiculo.Vehiculo;
import mx.edu.utez.rsss_irvin_abarca_cc7.service.vehiculo.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
@CrossOrigin("*")
public class VehiculoController {

    private final VehiculoService vehiculoService;


    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @PostMapping("/registrarVehiculo")
    public ResponseEntity<Vehiculo> registrarVehiculo(@RequestBody @Valid RegistrarVehiculoDTO payload) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(vehiculoService.nuevoVehiculo(payload));
    }

    @PatchMapping("/desactivarvehiculo")
    public ResponseEntity<Vehiculo> desctivarVehiculo(@RequestBody @Valid DesactivarVehiculoDTO payload) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(vehiculoService.desctivarVehiculo(payload));
    }
//    @GetMapping("/listas-vehiculos")
//    public ResponseEntity<List<Vehiculo>> listarOrdenesAtivas() {
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(vehiculoService.listarVehiculosActivos());
//    }


}
