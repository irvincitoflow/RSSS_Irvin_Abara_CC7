package mx.edu.utez.rsss_irvin_abarca_cc7.controller.vehiculo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistrarVehiculoDTO {
    @NotBlank
    private String placa;
    @NotBlank
    private String marca;
    @NotBlank
    private String modelo;
    @NotBlank
    private String propietario;

}
