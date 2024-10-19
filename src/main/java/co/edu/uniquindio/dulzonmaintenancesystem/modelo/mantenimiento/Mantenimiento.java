package co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento;

import co.edu.uniquindio.dulzonmaintenancesystem.Enums.EstadoMantenimiento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document("Mantenimiento")
public class Mantenimiento {

    private String idMantenimiento;
    private String idMaquina;
    private String idSupervisor;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private List<Observacion> observaciones;
    private EstadoMantenimiento estadoMantenimiento;
    private List<ActividadMantenimiento> actividadesPlanificadas;

}
