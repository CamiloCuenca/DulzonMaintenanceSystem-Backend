package co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces;


import co.edu.uniquindio.dulzonmaintenancesystem.dto.*;

import java.util.List;

import co.edu.uniquindio.dulzonmaintenancesystem.Exception.Mantenimiento.MaquinaNoEspecificadaExepcion;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.ActividadDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.MaquinaDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.MatenimientoDTO;


public interface ServiciosOperador {

    String crearCartaGantt(DtoCrearCartaGantt cartaGantt);

    void programarMantenimiento(MatenimientoDTO mantenimientoDto) throws MaquinaNoEspecificadaExepcion;

    void registarActividadmantenimiento(String idMantenimiento,ActividadDTO actividadDTO);




}
