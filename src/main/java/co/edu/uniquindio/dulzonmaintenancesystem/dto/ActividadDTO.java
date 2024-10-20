package co.edu.uniquindio.dulzonmaintenancesystem.dto;

import java.time.LocalDateTime;

public record ActividadDTO(

        String idActividadMantenimiento,
        String nombre,
        String IdOperador,
        String descripcion,
        LocalDateTime fechaInicioPlanificada,
        LocalDateTime fechaFinPlanificada
) { }