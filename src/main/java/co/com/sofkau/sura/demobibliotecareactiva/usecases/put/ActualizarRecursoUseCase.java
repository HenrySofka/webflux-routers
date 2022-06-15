package co.com.sofkau.sura.demobibliotecareactiva.usecases.put;

import co.com.sofkau.sura.demobibliotecareactiva.dto.RecursoDTO;
import co.com.sofkau.sura.demobibliotecareactiva.mappers.RecursoMapper;
import co.com.sofkau.sura.demobibliotecareactiva.models.Recurso;
import co.com.sofkau.sura.demobibliotecareactiva.repositories.IRecursoRepository;
import co.com.sofkau.sura.demobibliotecareactiva.usecases.interfaces.GuardarRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class ActualizarRecursoUseCase implements GuardarRecurso {
    private final IRecursoRepository repository;
    private final RecursoMapper recursoMapper;

    @Autowired
    public ActualizarRecursoUseCase(IRecursoRepository repository, RecursoMapper recursoMapper) {
        this.repository = repository;
        this.recursoMapper = recursoMapper;
    }
    @Override
    public Mono<String> apply(RecursoDTO recursoDTO) {
        return repository.save(recursoMapper
                .mapperToRecurso(recursoDTO.getId()).apply(recursoDTO)
        ).map(Recurso::getId);
    }
}
