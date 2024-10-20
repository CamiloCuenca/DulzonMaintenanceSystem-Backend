package co.edu.uniquindio.dulzonmaintenancesystem.dto;

import co.edu.uniquindio.dulzonmaintenancesystem.Enums.EstadoMantenimiento;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento.Observacion;

import java.time.LocalDateTime;
import java.util.List;

public record ListaMantenimientoDTO(

        String idMaquina,
        String idSupervisor,
        String nombre,
        LocalDateTime fechaInicio,
        LocalDateTime fechaFin,
        LocalDateTime fechaInicioReal, // puede ser null
        LocalDateTime fechaFinReal,
        EstadoMantenimiento estadoMantenimiento,
        String idCartaGantt


) {
}
