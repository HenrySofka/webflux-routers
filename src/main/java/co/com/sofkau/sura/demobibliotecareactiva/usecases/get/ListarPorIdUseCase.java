package co.com.sofkau.sura.demobibliotecareactiva.usecases.get;

import co.com.sofkau.sura.demobibliotecareactiva.dto.RecursoDTO;
import co.com.sofkau.sura.demobibliotecareactiva.mappers.RecursoMapper;
import co.com.sofkau.sura.demobibliotecareactiva.repositories.IRecursoRepository;
import co.com.sofkau.sura.demobibliotecareactiva.usecases.interfaces.ListarRecursoPorID;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class ListarPorIdUseCase implements ListarRecursoPorID<Mono<RecursoDTO>> {
    private final IRecursoRepository repository;
    private final RecursoMapper recursoMapper;

    public ListarPorIdUseCase(IRecursoRepository repository, RecursoMapper recursoMapper) {
        this.repository = repository;
        this.recursoMapper = recursoMapper;
    }

    @Override
    public Mono<RecursoDTO> getRecursoPorID(String id) {
        return repository
                .findById(id)
                .map(recursoMapper.mapperRecursoToDTO());
    }
}
