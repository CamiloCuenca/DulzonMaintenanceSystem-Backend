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

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicioOperadorImp implements ServiciosOperador {

    private final RepositorioMantenimiento repositorioMantenimiento;
    private final RepositorioMaquina repositorioMaquina;

    @Override
    public void registrarcartaGantt(String idCartaGantt) {

    }

    @Override
    public void programarMantenimiento(MatenimientoDTO mantenimientoDto) {

    }

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
            nuevaActividad.setIdActividadMantenimiento(actividadDTO.idActividadMantenimiento());
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
