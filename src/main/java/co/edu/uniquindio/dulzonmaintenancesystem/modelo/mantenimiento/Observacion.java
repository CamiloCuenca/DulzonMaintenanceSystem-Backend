package co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento;

<<<<<<< Updated upstream
import co.edu.uniquindio.dulzonmaintenancesystem.Enums.TipoObservacion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
=======
import lombok.*;
>>>>>>> Stashed changes

@Getter
@Setter
@NoArgsConstructor
public class Observacion {

    private String idObservacion;
    private String texto;
    private LocalDateTime fechaRegistro;
    private TipoObservacion tipoObservacion;
    private byte[] archivoAudio;
}
