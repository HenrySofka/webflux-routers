package co.com.sofkau.sura.demobibliotecareactiva.router.delete;

import co.com.sofkau.sura.demobibliotecareactiva.usecases.delete.EliminarRecursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EliminarRecursoRouter {
    @Bean
    public RouterFunction<ServerResponse> eliminarRecurso(EliminarRecursoUseCase useCase){
        return route(DELETE("eliminar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(useCase.deleteRecursoPorId(
                                        request.pathVariable("id")), Void.class)
                        )
        );
    }
}
