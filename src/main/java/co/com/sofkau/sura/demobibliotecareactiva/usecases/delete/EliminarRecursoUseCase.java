package co.com.sofkau.sura.demobibliotecareactiva.usecases.delete;

import co.com.sofkau.sura.demobibliotecareactiva.mappers.RecursoMapper;
import co.com.sofkau.sura.demobibliotecareactiva.repositories.IRecursoRepository;
import co.com.sofkau.sura.demobibliotecareactiva.usecases.interfaces.EliminarRecursoPorID;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class EliminarRecursoUseCase implements EliminarRecursoPorID<Mono<Void>> {

    private final IRecursoRepository repository;
    private final RecursoMapper recursoMapper;

    public EliminarRecursoUseCase(IRecursoRepository repository, RecursoMapper recursoMapper) {
        this.repository = repository;
        this.recursoMapper = recursoMapper;
    }


    @Override
    public Mono<Void> deleteRecursoPorId(String id) {
        Objects.requireNonNull(id, "La ID es requerida");
        return repository.deleteById(id);
    }
}
