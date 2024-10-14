package co.edu.uniquindio.dulzonmaintenancesystem.modelo.usuarios;

import co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces.ServiciosOperador;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document("Operador")
public class Operador extends Persona implements ServiciosOperador {
    @Id
    private String idOperador;

    @Override
    public void registrarcartaGantt(String idCartaGantt) {

    }

    @Override
    public void programarMantenimiento() {

    }

    @Override
    public void registarActividadmantenimiento(String idActividadmantenimiento) {

    }
}
