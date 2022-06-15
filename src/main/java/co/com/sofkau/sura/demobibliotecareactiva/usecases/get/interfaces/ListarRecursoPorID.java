package co.com.sofkau.sura.demobibliotecareactiva.usecases.get.interfaces;

import co.com.sofkau.sura.demobibliotecareactiva.dto.RecursoDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ListarRecursoPorID<T> {
    public T getRecursoPorID(String id);
}
