package co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosImp;

import co.edu.uniquindio.dulzonmaintenancesystem.dto.MaquinaDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento.Observacion;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.maquina.Maquina;
import co.edu.uniquindio.dulzonmaintenancesystem.repositorio.RepositoriosMantenimiento.RepositorioMantenimiento;
import co.edu.uniquindio.dulzonmaintenancesystem.repositorio.RepositoriosMaquina.RepositorioMaquina;
import co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces.ServiciosSupervisor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioSupervisorImp  implements ServiciosSupervisor {
    private final RepositorioMantenimiento repositorioMantenimiento;
    private final RepositorioMaquina repositorioMaquina;

    @Override
    public void registrarMantenimiento(String idMantenimiento) {

    }

    @Override
    public List<Observacion> registrarObservacion() {
        return List.of();
    }

    @Override
    public void crearMaquina(MaquinaDTO maquinaDTO) {
        // Convertir el MaquinaDTO a una entidad Maquina
        Maquina maquina = new Maquina();
        maquina.setFechaAdquisicion(maquinaDTO.fechaAdquisicion());
        maquina.setDescripcion(maquinaDTO.descripcion());
        maquina.setUltimoMantenimiento(maquinaDTO.ultimoMantenimiento());
        maquina.setUbicacion(maquinaDTO.ubicacion());
        maquina.setTipoMaquina(maquinaDTO.tipoMaquina());
        maquina.setEstadoMaquina(maquinaDTO.estadoMaquina());

        // Guardar la máquina en la base de datos
        repositorioMaquina.save(maquina);
    }

}
