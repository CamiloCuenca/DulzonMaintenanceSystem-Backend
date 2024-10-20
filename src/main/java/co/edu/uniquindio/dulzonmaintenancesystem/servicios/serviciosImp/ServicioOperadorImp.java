package co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosImp;

import co.edu.uniquindio.dulzonmaintenancesystem.dto.*;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.EmpresaExterna.Cuadrilla;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.EmpresaExterna.Trabajador;

import co.edu.uniquindio.dulzonmaintenancesystem.Exception.Mantenimiento.MaquinaNoEspecificadaExepcion;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.ActividadDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.MaquinaDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.MatenimientoDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento.ActividadMantenimiento;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento.CartaGantt;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento.Mantenimiento;
import co.edu.uniquindio.dulzonmaintenancesystem.repositorio.RepositoriosMantenimiento.RepositorioCartaGantt;
import co.edu.uniquindio.dulzonmaintenancesystem.repositorio.RepositoriosMantenimiento.RepositorioMantenimiento;
import co.edu.uniquindio.dulzonmaintenancesystem.repositorio.RepositoriosMaquina.RepositorioMaquina;
import co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces.ServiciosOperador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ServicioOperadorImp implements ServiciosOperador {

    private final RepositorioMantenimiento repositorioMantenimiento;
    private final RepositorioMaquina repositorioMaquina;
    private final RepositorioCartaGantt repositorioCartaGantt;

    @Override
    public String crearCartaGantt(DtoCrearCartaGantt cartaGantt) {
        // Crear la nueva carta Gantt
        CartaGantt nuevaCartaGantt = new CartaGantt();
        nuevaCartaGantt.setNombreCartaGantt(cartaGantt.nombreCartaGantt());
        nuevaCartaGantt.setFechaCreacion(LocalDateTime.now());

        // Crear y asignar cuadrillas
        List<Cuadrilla> cuadrillas = new ArrayList<>();
        for (Cuadrilla cuadrillaDTO : cartaGantt.cuadrillas()) {
            Cuadrilla cuadrilla = new Cuadrilla();
            cuadrilla.setNombre(cuadrillaDTO.getNombre());

            // Asignar trabajadores a la cuadrilla directamente desde el DTO
            List<Trabajador> trabajadores = new ArrayList<>(cuadrillaDTO.getTrabajadores());
            cuadrilla.setTrabajadores(trabajadores);

            cuadrillas.add(cuadrilla);
        }

        nuevaCartaGantt.setCuadrillas(cuadrillas);

        // Agregar actividades de mantenimiento
        List<ActividadMantenimiento> actividades = new ArrayList<>(cartaGantt.actividadesPlanificadas());
        nuevaCartaGantt.setActividadesPlanificadas(actividades);

        CartaGantt crearCuentaGannt = repositorioCartaGantt.save(nuevaCartaGantt);
        return crearCuentaGannt.getIdCartaGantt();

    }


    /**
     * Servicio para programar el mantenimiento de una maquina
     *
     * @param mantenimientoDto
     */
    @Override
    public void programarMantenimiento(MatenimientoDTO mantenimientoDto) throws MaquinaNoEspecificadaExepcion {
        // Validar si la máquina existe
        if (!repositorioMaquina.existsById(mantenimientoDto.idMaquina())) {
            throw new MaquinaNoEspecificadaExepcion("La máquina especificada no existe.");
        }

        // Verificar que la fecha de inicio sea anterior a la fecha de fin
        if (mantenimientoDto.fechaInicio().isAfter(mantenimientoDto.fechaFin())) {
            throw new IllegalArgumentException("La fecha de inicio debe ser anterior a la fecha de fin.");
        }

        // Convertir el DTO a una entidad Mantenimiento
        Mantenimiento mantenimiento = new Mantenimiento();
        mantenimiento.setIdMaquina(mantenimientoDto.idMaquina());
        mantenimiento.setIdSupervisor(mantenimientoDto.idSupervisor());
        mantenimiento.setFechaInicio(mantenimientoDto.fechaInicio());
        mantenimiento.setFechaFin(mantenimientoDto.fechaFin());
        mantenimiento.setObservaciones(mantenimientoDto.observaciones());
        mantenimiento.setEstadoMantenimiento(mantenimientoDto.estadoMantenimiento());
        mantenimiento.setNombre(mantenimientoDto.nombre());

        // Guardar el mantenimiento en la base de datos
        repositorioMantenimiento.save(mantenimiento);
    }

    /**
     * Servicio para asignar una actividad de mantenimiento a un mantenimiento.
     *
     * @param idMantenimiento
     * @param actividadDTO
     */

    @Override
    public void registarActividadmantenimiento(String idMantenimiento, ActividadDTO actividadDTO) {
        // Verificar si el mantenimiento existe
        Optional<Mantenimiento> mantenimientoOpt = repositorioMantenimiento.findById(idMantenimiento);
        if (mantenimientoOpt.isEmpty()) {
            throw new IllegalArgumentException("El mantenimiento especificado no existe.");
        }

        // Obtener el mantenimiento encontrado
        Mantenimiento mantenimiento = mantenimientoOpt.get();

        // Crear una nueva actividad a partir del DTO
        ActividadMantenimiento nuevaActividad = new ActividadMantenimiento();
        nuevaActividad.setIdActividadMantenimiento(UUID.randomUUID().toString()); // Generar id automáticamente
        nuevaActividad.setNombre(actividadDTO.nombre());
        nuevaActividad.setIdOperador(actividadDTO.IdOperador());
        nuevaActividad.setDescripcion(actividadDTO.descripcion());
        nuevaActividad.setFechaInicioPlanificada(actividadDTO.fechaInicioPlanificada());
        nuevaActividad.setFechaFinPlanificada(actividadDTO.fechaFinPlanificada());


        // Guardar el mantenimiento actualizado en la base de datos
        //repositorioCartaGantt.save(mantenimiento);
    }



}
