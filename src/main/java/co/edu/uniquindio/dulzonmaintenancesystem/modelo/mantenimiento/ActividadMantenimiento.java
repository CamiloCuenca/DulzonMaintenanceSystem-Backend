package co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ActividadMantenimiento {

    private String idActividadMantenimiento;
    private String nombre;
    private String IdOperador;
    private String descripcion;
    private LocalDateTime fechaInicioPlanificada;
    private LocalDateTime fechaFinPlanificada;
}
