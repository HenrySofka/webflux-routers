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
public class PrestarRecursoUseCase implements GuardarRecurso, ListarRecursoPorID<Mono<String>> {
    private final IRecursoRepository repository;
    private final RecursoMapper recursoMapper;
    private final ListarPorIdUseCase listarPorIdUseCase;

    public PrestarRecursoUseCase(IRecursoRepository repository, RecursoMapper recursoMapper, ListarPorIdUseCase listarPorIdUseCase) {
        this.repository = repository;
        this.recursoMapper = recursoMapper;
        this.listarPorIdUseCase = listarPorIdUseCase;
    }


    @Override
    public Mono<String> apply(RecursoDTO recursoDTO) {
        if (recursoDTO.getPrestado()) {
            return Mono.just("Recurso No Disponible --> Fecha de prestamo [" +
                    recursoDTO.getFechaPrestamo() + "]");
        }

        recursoDTO.setFechaPrestamo(LocalDate.now());
        recursoDTO.setPrestado(true);
        return repository.save(recursoMapper
                .mapperToRecurso(recursoDTO.getId()).apply(recursoDTO)
        ).flatMap(recurso -> Mono.just("Recurso prestado correctamente  --> Fecha de prestamo [" +
                recurso.getFechaPrestamo() + "]"));
    }

    @Override
    public Mono<String> getRecursoPorID(String id) {
        return listarPorIdUseCase.getRecursoPorID(id)
                .flatMap(recursoDTO -> apply(recursoDTO));
    }
}
