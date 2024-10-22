package co.edu.uniquindio.dulzonmaintenancesystem.repositorio.RepositoriosMantenimiento;

import co.edu.uniquindio.dulzonmaintenancesystem.modelo.mantenimiento.CartaGantt;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioCartaGantt extends MongoRepository<CartaGantt, String> {
    List<CartaGantt> findAll();
}
