package co.com.sofkau.sura.demobibliotecareactiva.usecases.get;

import co.com.sofkau.sura.demobibliotecareactiva.dto.RecursoDTO;
import co.com.sofkau.sura.demobibliotecareactiva.mappers.RecursoMapper;
import co.com.sofkau.sura.demobibliotecareactiva.repositories.IRecursoRepository;
import co.com.sofkau.sura.demobibliotecareactiva.usecases.interfaces.ListarRecursosPorTipoYAreaTematica;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
@Validated
public class ListarPorTipoRecursoYAreaTematicaUseCase implements ListarRecursosPorTipoYAreaTematica<Flux<RecursoDTO>> {
    private final IRecursoRepository repository;
    private final RecursoMapper recursoMapper;

    public ListarPorTipoRecursoYAreaTematicaUseCase(IRecursoRepository repository, RecursoMapper recursoMapper) {
        this.repository = repository;
        this.recursoMapper = recursoMapper;
    }

    @Override
    public Flux<RecursoDTO> listarPorTipoYAreaTematica(String tipoRecurso, String areaTematica) {
        return repository.findByTipoRecursoAndAreaTematica(tipoRecurso,areaTematica)
                .map(recursoMapper.mapperRecursoToDTO());
    }
}
