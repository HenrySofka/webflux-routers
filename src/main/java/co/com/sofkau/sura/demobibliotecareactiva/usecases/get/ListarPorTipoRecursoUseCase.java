package co.com.sofkau.sura.demobibliotecareactiva.usecases.get;

import co.com.sofkau.sura.demobibliotecareactiva.dto.RecursoDTO;
import co.com.sofkau.sura.demobibliotecareactiva.mappers.RecursoMapper;
import co.com.sofkau.sura.demobibliotecareactiva.models.Recurso;
import co.com.sofkau.sura.demobibliotecareactiva.repositories.IRecursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
@Validated
public class ListarPorTipoRecursoUseCase implements Function<String, Flux<RecursoDTO>> {
    private final IRecursoRepository repository;
    private final RecursoMapper recursoMapper;

    public ListarPorTipoRecursoUseCase(IRecursoRepository repository, RecursoMapper recursoMapper) {
        this.repository = repository;
        this.recursoMapper = recursoMapper;
    }


    @Override
    public Flux<RecursoDTO> apply(String tipoRecurso) {
        return repository.findByTipoRecurso(tipoRecurso)
                .map(recursoMapper.mapperRecursoToDTO());
    }
}
