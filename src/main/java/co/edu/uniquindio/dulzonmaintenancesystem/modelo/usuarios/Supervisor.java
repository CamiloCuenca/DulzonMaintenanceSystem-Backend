package co.edu.uniquindio.dulzonmaintenancesystem.modelo.usuarios;

import co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento.Observacion;
import co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces.ServiciosSupervisor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
@NoArgsConstructor
@Document("Supervisor")
public class Supervisor extends Persona implements ServiciosSupervisor {

    @Id
    private String idSupervisor;
    private String turno;

    @Override
    public void registrarMantenimiento(String idMantenimiento) {

    }

    @Override
    public List<Observacion> registrarObservacion() {
        return List.of();
    }
}
