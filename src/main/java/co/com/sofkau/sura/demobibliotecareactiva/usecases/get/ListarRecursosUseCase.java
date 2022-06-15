package co.com.sofkau.sura.demobibliotecareactiva.usecases.get;

import co.com.sofkau.sura.demobibliotecareactiva.dto.RecursoDTO;
import co.com.sofkau.sura.demobibliotecareactiva.mappers.RecursoMapper;
import co.com.sofkau.sura.demobibliotecareactiva.repositories.IRecursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class ListarRecursosUseCase implements Supplier<Flux<RecursoDTO>> {

    private final IRecursoRepository repository;
    private final RecursoMapper recursoMapper;

    public ListarRecursosUseCase(IRecursoRepository repository, RecursoMapper recursoMapper) {
        this.repository = repository;
        this.recursoMapper = recursoMapper;
    }

    @Override
    public Flux<RecursoDTO> get() {
        return repository.findAll().map(recursoMapper.mapperRecursoToDTO());
    }
}
