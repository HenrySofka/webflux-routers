package co.com.sofkau.sura.demobibliotecareactiva.repositories;

import co.com.sofkau.sura.demobibliotecareactiva.models.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;


public interface IRecursoRepository extends ReactiveMongoRepository<Recurso, String> {
    //CRUD POR DEFECTO

    /*
    * Recomendar un listado de recursos al usuario a partir del tipo de recurso, del área temática
    * o de los dos. Los recursos están clasificados por tipo de recurso (libros, revistas, fichas, etc)
    * pero también por área temática (ciencias, naturaleza, historia, etc).
    * */
    public Flux<Recurso> findByTipoRecurso(String tipoRecurso);
    public Flux<Recurso> findByAreaTematica(String areaTematica);
    public Flux<Recurso> findByTipoRecursoAndAreaTematica(String tipoRecurso, String areaTematica);
}
