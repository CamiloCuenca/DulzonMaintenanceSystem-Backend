package co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces;

import co.edu.uniquindio.dulzonmaintenancesystem.dto.ActividadDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.MaquinaDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.MatenimientoDTO;

public interface ServiciosOperador {

    void registrarcartaGantt(String idCartaGantt);

    void programarMantenimiento(MatenimientoDTO mantenimientoDto) throws Exception;

    void registarActividadmantenimiento(String idMantenimiento,ActividadDTO actividadDTO);



}
