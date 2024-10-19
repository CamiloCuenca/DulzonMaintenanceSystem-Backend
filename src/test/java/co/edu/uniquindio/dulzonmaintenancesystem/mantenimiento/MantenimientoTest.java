package co.edu.uniquindio.dulzonmaintenancesystem.mantenimiento;

import co.edu.uniquindio.dulzonmaintenancesystem.Enums.EstadoMantenimiento;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.ActividadDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.MatenimientoDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento.Mantenimiento;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.maquina.Maquina;
import co.edu.uniquindio.dulzonmaintenancesystem.repositorio.RepositoriosMantenimiento.RepositorioMantenimiento;
import co.edu.uniquindio.dulzonmaintenancesystem.repositorio.RepositoriosMaquina.RepositorioMaquina;
import co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosImp.ServicioOperadorImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class MantenimientoTest {

    @Autowired
    private RepositorioMantenimiento repositorioMantenimiento;

    @Autowired
    private RepositorioMaquina repositorioMaquina;

    @Autowired
    private ServicioOperadorImp servicioOperadorImp;

    @Test
    public void programarMantenimientoTest() {
        // Crear una máquina en la base de datos para que exista
        Maquina maquina = new Maquina();
        maquina.setIdMaquina("maquina_existente");
        repositorioMaquina.save(maquina);

        // Crear un MatenimientoDTO con datos válidos
        MatenimientoDTO mantenimientoDTO = new MatenimientoDTO(
                "671355d9fe902b4282101983",
                "671352e74d164315888b0a51",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(2),
                null,
                EstadoMantenimiento.EN_PAUSA,
                List.of()
        );

        // Programar el mantenimiento
        servicioOperadorImp.programarMantenimiento(mantenimientoDTO);
    }
    @Test
    public void registrarActividadMantenimientoTest() {


        // Crear un DTO de actividad
        ActividadDTO actividadDTO = new ActividadDTO(
                "actividad2",
                "Cambio de Radiador",
                "67135b727c166e1ec58a5de6",
                "Realizar cambio de Radiador en la máquina.",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1)
        );

        // Registrar la actividad en el mantenimiento
        servicioOperadorImp.registarActividadmantenimiento("67135da6abdd501d0610291e", actividadDTO);

}



}

