package co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosImp;

import co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento.Observacion;
import co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces.ServiciosSupervisor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioSupervisorImp  implements ServiciosSupervisor {
    @Override
    public void registrarMantenimiento(String idMantenimiento) {

    }

    @Override
    public List<Observacion> registrarObservacion() {
        return List.of();
    }
}
