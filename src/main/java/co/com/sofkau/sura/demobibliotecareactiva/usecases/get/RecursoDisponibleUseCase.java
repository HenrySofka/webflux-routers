package co.com.sofkau.sura.demobibliotecareactiva.usecases.get;

import co.com.sofkau.sura.demobibliotecareactiva.mappers.RecursoMapper;
import co.com.sofkau.sura.demobibliotecareactiva.repositories.IRecursoRepository;
import co.com.sofkau.sura.demobibliotecareactiva.usecases.interfaces.ListarRecursoPorID;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class RecursoDisponibleUseCase implements ListarRecursoPorID<Mono<String>> {
    private final IRecursoRepository repository;
    private final RecursoMapper recursoMapper;

    public RecursoDisponibleUseCase(IRecursoRepository repository, RecursoMapper recursoMapper) {
        this.repository = repository;
        this.recursoMapper = recursoMapper;
    }

    @Override
    public Mono<String> getRecursoPorID(String id) {
        /*
         *Consultar disponibilidad de un recurso indicando en un mensaje si esta disponible o no.
         *En caso de no estar disponible presentar la fecha del préstamo actual del ultimo ejemplar.
         * */
        var recurso = repository.findById(id).map(recursoMapper.mapperRecursoToDTO());
        return recurso
                .flatMap(recursoDTO -> {
                    if (recursoDTO.getPrestado()) {
                        return Mono.just(
                                "Recurso NO disponible --> Fecha de prestamo [" +
                                        recursoDTO.getFechaPrestamo() + "]"
                        );
                    }
                    return Mono.just("Recurso disponible --> Aun no se ha prestado");
                });
    }
}
