package co.edu.uniquindio.dulzonmaintenancesystem.controller;

import co.edu.uniquindio.dulzonmaintenancesystem.dto.*;
import co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces.ServiciosOperador;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/operador")
public class OperadorController {

    private final ServiciosOperador serviciosOperador;


    @PostMapping("/programar-mantenimiento")
    public ResponseEntity<MessageDTO<String>> programarMantenimiento(@Valid @RequestBody MatenimientoDTO mantenimientoDto) throws Exception{
        serviciosOperador.programarMantenimiento(mantenimientoDto);
        return ResponseEntity.ok(new MessageDTO<>(false, "El mantenimiento se creo exitosamente"));
    }

    @PostMapping("/registrar-actividad/{idCartaGantt}")
    public ResponseEntity<MessageDTO<String>> registrarActividad(@PathVariable String idCartaGantt,@Valid @RequestBody ActividadDTO actividadDTO){
        serviciosOperador.registarActividadmantenimiento(idCartaGantt,actividadDTO);
        return ResponseEntity.ok(new MessageDTO<>(false, "La Actividad se asigno (registro) exitosamente"));

    }

    @PostMapping("/crear-carta-Gantt")
    public String  crearCartaGantt(@Valid @RequestBody DtoCrearCartaGantt cartaGantt){
        String cartaGanttId = serviciosOperador.crearCartaGantt(cartaGantt);
        return cartaGanttId;
    }

    @GetMapping("/obtener-carta-gantt/{idCartGannt}")
    public DtoCrearCartaGantt obtenerCartasGanttEspecifica(@PathVariable String idCartGannt){
        DtoCrearCartaGantt dtoCrearCartaGantt = serviciosOperador.obtenerCartasGanttEspecifica(idCartGannt);
        return dtoCrearCartaGantt;
    }

    @PutMapping("/editar-gantt/{idCartaGantt}")
    public String editarGantt (@PathVariable String idCartaGantt,@Valid @RequestBody DtoCrearCartaGantt cartaGanttActualizada) throws Exception {
        String cartaGanttId = serviciosOperador.editarCartaGantt(idCartaGantt,cartaGanttActualizada);
        return cartaGanttId;
    }





}
