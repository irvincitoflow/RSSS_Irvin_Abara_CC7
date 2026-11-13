package mx.edu.utez.rsss_irvin_abarca_cc7.service.vehiculo;

import mx.edu.utez.rsss_irvin_abarca_cc7.controller.vehiculo.dto.DesactivarVehiculoDTO;
import mx.edu.utez.rsss_irvin_abarca_cc7.controller.vehiculo.dto.RegistrarVehiculoDTO;
import mx.edu.utez.rsss_irvin_abarca_cc7.model.ordenservicio.OrdenServicio;
import mx.edu.utez.rsss_irvin_abarca_cc7.model.vehiculo.Vehiculo;
import mx.edu.utez.rsss_irvin_abarca_cc7.repository.ordenservicio.OrdenServicioRepository;
import mx.edu.utez.rsss_irvin_abarca_cc7.repository.vehiculo.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {
    private final VehiculoRepository vehiculoRepository;
    private final OrdenServicioRepository ordenServicioRepository;


    public VehiculoService(VehiculoRepository vehiculoRepository, OrdenServicioRepository ordenServicioRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.ordenServicioRepository = ordenServicioRepository;
    }

    public Vehiculo nuevoVehiculo(RegistrarVehiculoDTO payload){
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPlaca(payload.getPlaca());
        vehiculo.setMarca(payload.getMarca());
        vehiculo.setModelo(payload.getModelo());
        vehiculo.setPropietario(payload.getPropietario());
        vehiculo.setActivo(true);

        return vehiculoRepository.save(vehiculo);
    }
    public Vehiculo desctivarVehiculo(DesactivarVehiculoDTO payload){
        Vehiculo vehiculo = vehiculoRepository.findById(payload.getIdVehiculo()).orElseThrow(
                ()-> new RuntimeException("Vehiculo no encontrado")
        );

        //falta validacion
        //No permitir desactivar un vehículo que tenga órdenes en estado RECIBIDA o EN_REPARACION.

        vehiculo.setActivo(false);
        return vehiculoRepository.save(vehiculo);
    }
//    public List<Vehiculo> listarVehiculosActivos(){
//        return vehiculoRepository.findAllByActivoTrue();
//    }

}
