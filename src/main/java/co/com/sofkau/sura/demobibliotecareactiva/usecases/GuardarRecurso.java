package co.com.sofkau.sura.demobibliotecareactiva.usecases;

import co.com.sofkau.sura.demobibliotecareactiva.dto.RecursoDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface GuardarRecurso {
    public Mono<String> apply(RecursoDTO recursoDTO);
}
