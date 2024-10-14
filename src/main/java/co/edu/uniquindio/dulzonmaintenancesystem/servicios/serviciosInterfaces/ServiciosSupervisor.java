package co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces;

import co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento.Observacion;

import java.util.List;

public interface ServiciosSupervisor {
    void registrarMantenimiento( String idMantenimiento);
    List<Observacion> registrarObservacion();
}
