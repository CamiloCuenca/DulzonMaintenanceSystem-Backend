package co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces;

import co.edu.uniquindio.dulzonmaintenancesystem.Exception.Mantenimiento.MaquinaNoEspecificadaExepcion;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.ActividadDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.MaquinaDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.MatenimientoDTO;

public interface ServiciosOperador {

    void registrarcartaGantt(String idCartaGantt);

    void programarMantenimiento(MatenimientoDTO mantenimientoDto) throws MaquinaNoEspecificadaExepcion;

    void registarActividadmantenimiento(String idMantenimiento,ActividadDTO actividadDTO);




}
