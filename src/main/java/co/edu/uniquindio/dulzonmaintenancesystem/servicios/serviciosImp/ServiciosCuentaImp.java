package co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosImp;
import co.edu.uniquindio.dulzonmaintenancesystem.Exception.Cuenta.CedulaAlreadyExistsException;
import co.edu.uniquindio.dulzonmaintenancesystem.Exception.Cuenta.EmailAlreadyExistsException;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.DtoCrearCuenta;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.DtoCrearPersona;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.usuarios.Cuenta;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.usuarios.Persona;
import co.edu.uniquindio.dulzonmaintenancesystem.repositorio.RepositoriosUsuarios.RepositorioCuenta;
import co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces.ServiciosCuenta;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class ServiciosCuentaImp implements ServiciosCuenta {

    private final RepositorioCuenta repositorioCuenta;
    private final PasswordEncoder passwordEncoder;

    private boolean existsEmail(String email) {
        return repositorioCuenta.findByEmail(email).isPresent();
    }

    private boolean existsCedula(String cedula) {
        return repositorioCuenta.findByCedula(cedula).isPresent();
    }

    @Override
    public String crearCuenta(DtoCrearCuenta cuenta, DtoCrearPersona persona)  {
        if (existsEmail(cuenta.email())){
           throw new EmailAlreadyExistsException("El email ya existe");
        }

        if (existsCedula((persona.cedula()))){
            throw new CedulaAlreadyExistsException("La cedula ya existe");
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = bCryptPasswordEncoder.encode(cuenta.password());

        Cuenta nuevaCuenta = new Cuenta();
        nuevaCuenta.setEmail(cuenta.email());
        nuevaCuenta.setPassword(hashedPassword);
        nuevaCuenta.setRol(cuenta.rol());
        nuevaCuenta.setRegistrationDate(LocalDateTime.now());

        nuevaCuenta.setPersona(new Persona(
                persona.cedula(),
                persona.nombre(),
                persona.Apellido(),
                persona.telefono(),
                persona.direccion(),
                persona.fechaNacimiento()
        ));

        Cuenta crearCuenta = repositorioCuenta.save(nuevaCuenta);
        return crearCuenta.getEmail();
    }
}
