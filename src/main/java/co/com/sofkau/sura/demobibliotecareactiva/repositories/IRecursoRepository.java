package co.com.sofkau.sura.demobibliotecareactiva.repositories;

import co.com.sofkau.sura.demobibliotecareactiva.models.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IRecursoRepository extends ReactiveMongoRepository<Recurso, String> {
    //CRUD POR DEFECTO
}
