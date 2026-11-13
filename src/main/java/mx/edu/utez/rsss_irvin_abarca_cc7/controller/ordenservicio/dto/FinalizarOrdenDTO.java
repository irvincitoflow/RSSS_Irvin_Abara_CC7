package mx.edu.utez.rsss_irvin_abarca_cc7.controller.ordenservicio.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FinalizarOrdenDTO {
    @NotNull
    private Long idOrden;
}
