package co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document("CartaGantt")
public class CartaGantt {

    @Id
    private String idCartaGantt;
    private String idOperador;
    private List<ActividadMantenimiento> actividadesPlanificadas;
    private String nombreMantenimiento;

}
