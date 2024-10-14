package co.edu.uniquindio.dulzonmaintenancesystem.modelo.usuarios;

import co.edu.uniquindio.dulzonmaintenancesystem.servicios.serviciosInterfaces.ServiciosGerente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document("Gerente")
public class Gerente  extends Persona  implements ServiciosGerente
{
   @Id
   private String idGerente;

    @Override
    public void visualizarMAntenimiento(String idMantenimiento) {

    }

    @Override
    public void visulizarObservacionesMantenimienti(String idMantenimiento) {

    }

    @Override
    public void visualizarProgramacionMantenimiento(String idMantenimiento) {

    }
}
