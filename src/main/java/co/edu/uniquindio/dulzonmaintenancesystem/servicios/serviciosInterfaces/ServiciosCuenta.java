package co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces;

import co.edu.uniquindio.dulzonmaintenancesystem.dto.DtoCrearCuenta;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.DtoCrearPersona;


public interface ServiciosCuenta {
    String crearCuenta(DtoCrearCuenta cuenta, DtoCrearPersona persona) throws Exception;
}
