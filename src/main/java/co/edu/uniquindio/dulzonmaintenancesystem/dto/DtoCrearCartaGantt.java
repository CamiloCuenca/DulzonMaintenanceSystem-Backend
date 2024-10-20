package co.edu.uniquindio.dulzonmaintenancesystem.dto;

import co.edu.uniquindio.dulzonmaintenancesystem.modelo.EmpresaExterna.Cuadrilla;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento.ActividadMantenimiento;

import java.time.LocalDateTime;
import java.util.List;

public record DtoCrearCartaGantt(
        List<ActividadMantenimiento> actividadesPlanificadas,
        List<Cuadrilla> cuadrillas,
        LocalDateTime fechaCreacion,
        String nombreCartaGantt
) {
}