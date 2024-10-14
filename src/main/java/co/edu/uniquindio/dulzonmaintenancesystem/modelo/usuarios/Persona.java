package co.edu.uniquindio.dulzonmaintenancesystem.modelo.usuarios;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Persona {
    private String nombre;
    private String userName;
    private String password;
    private String email;
    private String telefono;
}
