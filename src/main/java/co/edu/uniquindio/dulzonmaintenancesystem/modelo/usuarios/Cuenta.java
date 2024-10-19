package co.edu.uniquindio.dulzonmaintenancesystem.modelo.usuarios;

import co.edu.uniquindio.dulzonmaintenancesystem.Enums.Rol;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document("Cuenta")
public class Cuenta {
    @Id
    private String idCuenta;
    private String email;
    private String password;
    private Rol rol;
    private LocalDateTime registrationDate;
    private Persona persona;
}
