package mx.edu.utez.rsss_irvin_abarca_cc7.model.ordenservicio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.rsss_irvin_abarca_cc7.model.vehiculo.Vehiculo;

@Entity
@Table(name = "ordenesDeServicios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdenServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private Double costo;
    @Enumerated(EnumType.STRING)
    private TipoOrden tipoOrden;
    @Enumerated(EnumType.STRING)
    private EstadoOrden estadoOrden;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;



}
