package co.edu.uniquindio.dulzonmaintenancesystem.controller;

import co.edu.uniquindio.dulzonmaintenancesystem.dto.ActividadDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.MatenimientoDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.MessageDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces.ServiciosOperador;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/registrar-actividad/{idMantenimiento}")
    public ResponseEntity<MessageDTO<String>> registrarActividad(@PathVariable String idMantenimiento,@Valid @RequestBody ActividadDTO actividadDTO){
        serviciosOperador.registarActividadmantenimiento(idMantenimiento,actividadDTO);
        return ResponseEntity.ok(new MessageDTO<>(false, "La Actividad se asigno (registro) exitosamente"));

    }
}
