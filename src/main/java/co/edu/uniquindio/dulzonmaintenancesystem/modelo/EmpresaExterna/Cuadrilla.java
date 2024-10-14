package co.edu.uniquindio.dulzonmaintenancesystem.modelo.EmpresaExterna;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Cuadrilla {

    private String idCuadrilla;
    private String nombre;
    private List<Trabajador> trabajadores;

}
