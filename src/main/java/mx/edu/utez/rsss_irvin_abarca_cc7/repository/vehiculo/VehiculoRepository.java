package mx.edu.utez.rsss_irvin_abarca_cc7.repository.vehiculo;

import mx.edu.utez.rsss_irvin_abarca_cc7.model.vehiculo.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo,Long> {
//    List<Vehiculo> findAllByActivoTrue();
}
