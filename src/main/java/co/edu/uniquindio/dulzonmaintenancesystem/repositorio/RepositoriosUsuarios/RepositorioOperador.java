package co.edu.uniquindio.dulzonmaintenancesystem.repositorio.RepositoriosUsuarios;

import co.edu.uniquindio.dulzonmaintenancesystem.modelo.usuarios.Operador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioOperador extends MongoRepository<Operador, String> {
}
