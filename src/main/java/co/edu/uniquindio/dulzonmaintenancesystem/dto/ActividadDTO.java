package co.edu.uniquindio.dulzonmaintenancesystem.dto;

import java.time.LocalDateTime;

public record ActividadDTO(

        String nombre,
        String IdOperador,
        String descripcion,
        LocalDateTime fechaInicioPlanificada,
        LocalDateTime fechaFinPlanificada,
        LocalDateTime fechaInicioReal, // puede ser null
        LocalDateTime fechaFinReal // puede ser null
) { }

