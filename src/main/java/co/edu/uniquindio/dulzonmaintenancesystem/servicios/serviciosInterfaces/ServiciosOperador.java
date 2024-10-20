package co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces;

import co.edu.uniquindio.dulzonmaintenancesystem.dto.*;

import java.util.List;

public interface ServiciosOperador {

    String crearCartaGantt(DtoCrearCartaGantt cartaGantt);

    void programarMantenimiento(MatenimientoDTO mantenimientoDto) throws Exception;

    void registarActividadmantenimiento(String idMantenimiento,ActividadDTO actividadDTO);



}
