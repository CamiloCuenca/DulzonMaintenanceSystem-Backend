package co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces;


<<<<<<< Updated upstream
public interface ServiciosGerente {
    void visualizarMAntenimiento(String idMantenimiento);
=======
import co.edu.uniquindio.dulzonmaintenancesystem.dto.DtoEditarCuentaAdmi;

public interface ServiciosGerente {
    void visualizarMantenimiento(String idMantenimiento);

>>>>>>> Stashed changes
    void visulizarObservacionesMantenimienti(String idMantenimiento);

    void visualizarProgramacionMantenimiento(String idMantenimiento);
<<<<<<< Updated upstream
=======

    String editarCuentaAdmin(DtoEditarCuentaAdmi dtoEditarCuentaAdmi, String idCuenta) throws Exception;

    String eliminarCuentaAdmi(String idCuenta) throws Exception;
>>>>>>> Stashed changes
}
