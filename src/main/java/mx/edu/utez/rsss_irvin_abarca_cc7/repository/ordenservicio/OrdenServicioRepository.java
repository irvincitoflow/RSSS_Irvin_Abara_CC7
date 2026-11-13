package mx.edu.utez.rsss_irvin_abarca_cc7.repository.ordenservicio;

import mx.edu.utez.rsss_irvin_abarca_cc7.model.ordenservicio.OrdenServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrdenServicioRepository extends JpaRepository<OrdenServicio,Long> {
    List<OrdenServicio> findAllByEstadoOrdenTrue();
}
