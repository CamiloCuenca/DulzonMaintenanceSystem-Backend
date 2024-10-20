package co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosImp;

import co.edu.uniquindio.dulzonmaintenancesystem.dto.ActividadDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.MaquinaDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.MatenimientoDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento.ActividadMantenimiento;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento.Mantenimiento;
import co.edu.uniquindio.dulzonmaintenancesystem.repositorio.RepositoriosMantenimiento.RepositorioMantenimiento;
import co.edu.uniquindio.dulzonmaintenancesystem.repositorio.RepositoriosMaquina.RepositorioMaquina;
import co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces.ServiciosOperador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ServicioOperadorImp implements ServiciosOperador {

    private final RepositorioMantenimiento repositorioMantenimiento;
    private final RepositorioMaquina repositorioMaquina;

    @Override
    public void registrarcartaGantt(String idCartaGantt) {

    }

    /**
     * Servicio para programar el mantenimiento de una maquina
     *
     * @param mantenimientoDto
     */
    @Override
    public void programarMantenimiento(MatenimientoDTO mantenimientoDto) throws Exception {
        // Validar si la máquina existe
        if (!repositorioMaquina.existsById(mantenimientoDto.idMaquina())) {
            throw new IllegalArgumentException("La máquina especificada no existe.");
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

        // Agregar la nueva actividad a la lista de actividades planificadas
        if (mantenimiento.getActividadesPlanificadas() == null) {
            // Si la lista no está inicializada, crear una nueva lista
            mantenimiento.setActividadesPlanificadas(new ArrayList<>());
        }

        // Añadir la nueva actividad
        mantenimiento.getActividadesPlanificadas().add(nuevaActividad);

        // Guardar el mantenimiento actualizado en la base de datos
        repositorioMantenimiento.save(mantenimiento);
    }



}
