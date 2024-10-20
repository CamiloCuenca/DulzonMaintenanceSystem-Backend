package co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento;

import co.edu.uniquindio.dulzonmaintenancesystem.Enums.EstadoMantenimiento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document("Mantenimiento")
public class Mantenimiento {

    @Id
    private String idMantenimiento;
    private String idMaquina;
    private String idSupervisor;
    private String nombre;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private LocalDateTime fechaInicioReal; // puede ser null
    private LocalDateTime fechaFinReal;
    private List<Observacion> observaciones;
    private EstadoMantenimiento estadoMantenimiento;
    private List<ActividadMantenimiento> actividadesPlanificadas;


}
