package mx.edu.utez.rsss_irvin_abarca_cc7.service.ordenservicio;

import mx.edu.utez.rsss_irvin_abarca_cc7.controller.ordenservicio.dto.ActualizarCostoOrdenDTO;
import mx.edu.utez.rsss_irvin_abarca_cc7.controller.ordenservicio.dto.CrearOrdenServicioDTO;
import mx.edu.utez.rsss_irvin_abarca_cc7.controller.ordenservicio.dto.FinalizarOrdenDTO;
import mx.edu.utez.rsss_irvin_abarca_cc7.model.ordenservicio.EstadoOrden;
import mx.edu.utez.rsss_irvin_abarca_cc7.model.ordenservicio.OrdenServicio;
import mx.edu.utez.rsss_irvin_abarca_cc7.model.vehiculo.Vehiculo;
import mx.edu.utez.rsss_irvin_abarca_cc7.repository.ordenservicio.OrdenServicioRepository;
import mx.edu.utez.rsss_irvin_abarca_cc7.repository.vehiculo.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenServicioService {
    private final OrdenServicioRepository ordenServicioRepository;
    private final VehiculoRepository vehiculoRepository;

    public OrdenServicioService(OrdenServicioRepository ordenServicioRepository, VehiculoRepository vehiculoRepository) {
        this.ordenServicioRepository = ordenServicioRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    public OrdenServicio crearOrden(CrearOrdenServicioDTO payload){
        Vehiculo vehiculo = vehiculoRepository.findById(payload.getIdVehiculo()).orElseThrow(
                ()->new RuntimeException("Vehiculo no encontrado")
        );

        if (vehiculo.getActivo()!=true){
            throw new RuntimeException("El vehiculo no esta disponible");
        }
        // me falta validacion de Comprobar que el vehículo no tenga otra orden en estado RECIBIDA o EN_REPARACION.

        OrdenServicio ordenServicio = new OrdenServicio();
        ordenServicio.setTipoOrden(payload.getTipoServicio());
        ordenServicio.setDescripcion(payload.getDescripcion());
        ordenServicio.setCosto(0.0);
        ordenServicio.setEstadoOrden(EstadoOrden.RECIBIDA);
        ordenServicio.setVehiculo(vehiculo);

        return ordenServicioRepository.save(ordenServicio);

    }
    public OrdenServicio finalizarOrden(FinalizarOrdenDTO payload){
        OrdenServicio ordenServicio = ordenServicioRepository.findById(payload.getIdOrden()).orElseThrow(
                ()->new RuntimeException("Orden no encontrara")
        );

        if (ordenServicio.getEstadoOrden()!=EstadoOrden.EN_REPARACION){
            throw new RuntimeException("No se pueden finalizar ordenes que no esten en preparacion");
        }
        if (ordenServicio.getCosto()<= 0){
            throw new RuntimeException("Error, el costo no puede ser negativo");
        }

        ordenServicio.setEstadoOrden(EstadoOrden.FINALIZADA);

        return ordenServicioRepository.save(ordenServicio);

    }

    public OrdenServicio actualizarCosto(ActualizarCostoOrdenDTO payload){
        OrdenServicio ordenServicio = ordenServicioRepository.findById(payload.getIdOrden()).orElseThrow(
                ()-> new RuntimeException("Orden no encontrada")
        );

        ordenServicio.setCosto(payload.getNuevoPrecio());
        return ordenServicioRepository.save(ordenServicio);


    }
    public List<OrdenServicio> listasOrdenesActivas(){
        return ordenServicioRepository.findAllByEstadoOrdenTrue();
    }




}
