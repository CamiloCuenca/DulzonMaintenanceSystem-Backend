package co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento;

import co.edu.uniquindio.dulzonmaintenancesystem.Enums.TipoObservacion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
