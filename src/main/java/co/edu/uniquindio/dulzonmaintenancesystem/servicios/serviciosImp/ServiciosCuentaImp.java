package co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosImp;

import co.edu.uniquindio.dulzonmaintenancesystem.Enums.EstadoCuenta;
import co.edu.uniquindio.dulzonmaintenancesystem.Exception.Cuenta.CedulaAlreadyExistsException;
import co.edu.uniquindio.dulzonmaintenancesystem.Exception.Cuenta.EmailAlreadyExistsException;
import co.edu.uniquindio.dulzonmaintenancesystem.Exception.Cuenta.InvalidPasswordException;
import co.edu.uniquindio.dulzonmaintenancesystem.dto.*;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.usuarios.Cuenta;
import co.edu.uniquindio.dulzonmaintenancesystem.modelo.usuarios.Persona;
import co.edu.uniquindio.dulzonmaintenancesystem.repositorio.RepositoriosUsuarios.RepositorioCuenta;
import co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces.ServiciosCuenta;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.AccountNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;

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
    public String crearCuenta(DtoCrearCuenta cuenta, DtoCrearPersona persona) {
        if (existsEmail(cuenta.email())) {
            throw new EmailAlreadyExistsException("El email ya existe");
        }

        if (existsCedula((persona.cedula()))) {
            throw new CedulaAlreadyExistsException("La cedula ya existe");
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = bCryptPasswordEncoder.encode(cuenta.password());

        Cuenta nuevaCuenta = new Cuenta();
        nuevaCuenta.setEmail(cuenta.email());
        nuevaCuenta.setPassword(hashedPassword);
        nuevaCuenta.setRol(cuenta.rol());
        nuevaCuenta.setEstadoCuenta(cuenta.estadoCuenta());
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

    /**
     * Metodo para editar los datos basicos de la cuenta.
     *
     * @param cuenta
     * @param idCUenta
     * @return
     * @throws AccountNotFoundException
     */
    @Override
    public String editarCuenta(DtoEditarCuenta cuenta, String idCUenta) throws AccountNotFoundException {
        Optional<Cuenta> cuentaOptional = repositorioCuenta.findById(idCUenta);
        if (cuentaOptional.isEmpty()) {
            throw new AccountNotFoundException("El usuario no fue encontrado");
        }

        Cuenta cuentaActualizada = cuentaOptional.get();


        cuentaActualizada.getPersona().setTelefono(cuenta.telefono());
        cuentaActualizada.getPersona().setDireccion(cuenta.direccion());

        String newPassword = cuenta.password();
        if (newPassword != null && !newPassword.isEmpty()) {
            cuentaActualizada.setPassword(encryptPassword(newPassword));
        }
        repositorioCuenta.save(cuentaActualizada);
        return cuentaActualizada.getIdCuenta();
    }

    private String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }




}
