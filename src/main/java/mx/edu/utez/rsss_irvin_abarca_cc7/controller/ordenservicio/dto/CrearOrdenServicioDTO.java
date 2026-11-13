package mx.edu.utez.rsss_irvin_abarca_cc7.controller.ordenservicio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mx.edu.utez.rsss_irvin_abarca_cc7.model.ordenservicio.TipoOrden;

@Data
public class CrearOrdenServicioDTO {

    @NotNull
    private Long idVehiculo;
    @NotBlank
    private String descripcion;
    @NotBlank
    private TipoOrden tipoServicio;

}
