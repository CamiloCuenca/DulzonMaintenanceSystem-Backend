package co.edu.uniquindio.dulzonmaintenancesystem.dto;

import co.edu.uniquindio.dulzonmaintenancesystem.Enums.EstadoMantenimiento;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento.ActividadMantenimiento;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento.Observacion;

import java.time.LocalDateTime;
import java.util.List;

public record MatenimientoDTO(

        String idMaquina,
        String idSupervisor,
        LocalDateTime fechaInicio,
        LocalDateTime fechaFin,
        List<Observacion> observaciones,
        EstadoMantenimiento estadoMantenimiento,
        List<ActividadMantenimiento> actividadesPlanificadas


) {

}
