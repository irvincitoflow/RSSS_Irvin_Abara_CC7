package mx.edu.utez.rsss_irvin_abarca_cc7.controller.vehiculo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DesactivarVehiculoDTO {
    @NotNull
    private Long idVehiculo;

}
