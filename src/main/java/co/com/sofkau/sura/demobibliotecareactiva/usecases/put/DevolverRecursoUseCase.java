package co.com.sofkau.sura.demobibliotecareactiva.usecases.put;

import co.com.sofkau.sura.demobibliotecareactiva.dto.RecursoDTO;
import co.com.sofkau.sura.demobibliotecareactiva.mappers.RecursoMapper;
import co.com.sofkau.sura.demobibliotecareactiva.repositories.IRecursoRepository;
import co.com.sofkau.sura.demobibliotecareactiva.usecases.get.ListarPorIdUseCase;
import co.com.sofkau.sura.demobibliotecareactiva.usecases.interfaces.GuardarRecurso;
import co.com.sofkau.sura.demobibliotecareactiva.usecases.interfaces.ListarRecursoPorID;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
@Validated
public class DevolverRecursoUseCase implements GuardarRecurso, ListarRecursoPorID<Mono<String>> {
    private final IRecursoRepository repository;
    private final RecursoMapper recursoMapper;
    private final ListarPorIdUseCase listarPorIdUseCase;

    public DevolverRecursoUseCase(IRecursoRepository repository, RecursoMapper recursoMapper, ListarPorIdUseCase listarPorIdUseCase) {
        this.repository = repository;
        this.recursoMapper = recursoMapper;
        this.listarPorIdUseCase = listarPorIdUseCase;
    }

    @Override
    public Mono<String> apply(RecursoDTO recursoDTO) {
        if (!recursoDTO.getPrestado()) {
            return Mono.just("Recurso Disponible para Prestar");
        }

        recursoDTO.setFechaPrestamo(null);
        recursoDTO.setPrestado(false);
        return repository.save(recursoMapper
                .mapperToRecurso(recursoDTO.getId()).apply(recursoDTO)
        ).flatMap(recurso -> Mono.just("Recurso devuelto correctamente  --> Fecha de devolucion [" +
                LocalDate.now() + "]"));
    }

    @Override
    public Mono<String> getRecursoPorID(String id) {
        return listarPorIdUseCase.getRecursoPorID(id)
                .flatMap(recursoDTO -> apply(recursoDTO));
    }
}
