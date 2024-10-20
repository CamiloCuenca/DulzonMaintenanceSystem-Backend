package co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces;

import co.edu.uniquindio.dulzonmaintenancesystem.dto.MaquinaDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento.Observacion;

import java.util.List;

public interface ServiciosSupervisor {

    List<Observacion> registrarObservacion();

    void crearMaquina(MaquinaDTO maquinaDTO);

    void iniciarActividad(String idMantenimiento, String idActividad);

    void finalizarActividad(String idMantenimiento, String idActividad);

    void iniciarMantenimiento(String idMantenimiento);

    void finalizarMantenimiento(String idMantenimiento);

}

