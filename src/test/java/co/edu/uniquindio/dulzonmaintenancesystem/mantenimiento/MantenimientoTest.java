package co.edu.uniquindio.dulzonmaintenancesystem.mantenimiento;

import co.edu.uniquindio.dulzonmaintenancesystem.Enums.EstadoMantenimiento;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.ActividadDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.MatenimientoDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.repositorio.RepositoriosMantenimiento.RepositorioMantenimiento;
import co.edu.uniquindio.dulzonmaintenancesystem.repositorio.RepositoriosMaquina.RepositorioMaquina;
import co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces.ServiciosOperador;
import co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces.ServiciosSupervisor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootTest
public class MantenimientoTest {

    @Autowired
    private RepositorioMantenimiento repositorioMantenimiento;

    @Autowired
    private RepositorioMaquina repositorioMaquina;

    @Autowired
    private ServiciosOperador servicioOperador;

    @Autowired
    private ServiciosSupervisor serviciosSupervisor;

    //

    @Test
    public void programarMantenimientoTest() throws Exception {

        // Crear un MatenimientoDTO con datos válidos
        MatenimientoDTO mantenimientoDTO = new MatenimientoDTO(
                "671355d9fe902b4282101983",
                "671352e74d164315888b0a51",
                "Mantenimiento prueba1",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(2),
                null,
                null,
                new ArrayList<>(),
                EstadoMantenimiento.EN_PAUSA,
                new ArrayList<>()
        );

        // Programar el mantenimiento
        servicioOperador.programarMantenimiento(mantenimientoDTO);
    }

    @Test
    public void registrarActividadMantenimientoTest() {

        String idMantenimienento= "67146a83c181de7c14270d76";
        // Crear un DTO de actividad
        ActividadDTO actividadDTO = new ActividadDTO(

                "Cambio de Radiador",
                "67135b727c166e1ec58a5de6",
                "Realizar cambio de Radiador en la máquina.",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                null,
                null
        );

        // Registrar la actividad en el mantenimiento
        servicioOperador.registarActividadmantenimiento(idMantenimienento,actividadDTO);

}

    @Test
    public void iniciarMantenimientoTest(){
        String idMantenimiento= "67146f8d703ae618a1d12b18";
        serviciosSupervisor.iniciarMantenimiento(idMantenimiento);
    }

    @Test
    public void finalizarMantenimientoTest(){
        String idMantenimiento= "67146f8d703ae618a1d12b18";
        serviciosSupervisor.finalizarMantenimiento(idMantenimiento);
    }


    @Test
    public void iniciarActividadTest(){
        String idMantenimiento="67146a83c181de7c14270d76";
        String idActividad="b2a1a68a-d630-4558-a5cf-c0091b26b0fb";

        serviciosSupervisor.iniciarActividad(idMantenimiento,idActividad);
    }

    @Test
    public void finalizarActividadTest(){
        String idMantenimiento="67146a83c181de7c14270d76";
        String idActividad="b2a1a68a-d630-4558-a5cf-c0091b26b0fb";

        serviciosSupervisor.finalizarActividad(idMantenimiento,idActividad);
    }




}

