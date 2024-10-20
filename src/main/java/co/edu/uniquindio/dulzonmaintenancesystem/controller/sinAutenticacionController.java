package co.edu.uniquindio.dulzonmaintenancesystem.controller;

import co.edu.uniquindio.dulzonmaintenancesystem.dto.DtoLogin;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.MatenimientoDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.MessageDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.TokenDTO;
import co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces.ServiciosCuenta;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sinAuth")
public class sinAutenticacionController {

    private final ServiciosCuenta serviciosCuenta;

    @PostMapping("/login")
    public ResponseEntity<MessageDTO<TokenDTO>> iniciarSesion(@Valid @RequestBody DtoLogin login) throws Exception{
        TokenDTO token = serviciosCuenta.iniciarSesion(login);
        return ResponseEntity.ok(new MessageDTO<>(false, token));
    }


}
