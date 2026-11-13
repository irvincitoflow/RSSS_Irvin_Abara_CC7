package mx.edu.utez.rsss_irvin_abarca_cc7.controller.ordenservicio.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class ActualizarCostoOrdenDTO {
    @NotNull
    private Long idOrden;
    @NotNull
    @PositiveOrZero(message = "El nuevo costo debe ser mayor o iugal a cero")
    private Double nuevoPrecio;
}
