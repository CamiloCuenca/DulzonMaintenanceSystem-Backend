package co.edu.uniquindio.dulzonmaintenancesystem.cuenta;

import co.edu.uniquindio.dulzonmaintenancesystem.Enums.Rol;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.DtoCrearCuenta;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.DtoCrearPersona;
import co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosImp.ServiciosCuentaImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CuentaTest {

    @Autowired
    private ServiciosCuentaImp serviciosCuentaImp;




    @Test
    public void crearCuenta() {
        DtoCrearCuenta nuevaCuentaDTO = new DtoCrearCuenta(
                "brandonlo@gmail.com",
                "123456",
                Rol.GERENTE
        );
        DtoCrearPersona nuevaPersonaDTO = new DtoCrearPersona(
                "1001277430",
                "brandon",
                "acevedo",
                "3153032",
                "mariacristina",
                LocalDateTime.of(2000, 8, 17, 18, 0)
        );
        assertDoesNotThrow(() -> {
            String id = serviciosCuentaImp.crearCuenta(nuevaCuentaDTO,nuevaPersonaDTO);
            // Verifica que el id de la cuenta creada no sea nulo
            assertNotNull(id);
        });
    }
}
