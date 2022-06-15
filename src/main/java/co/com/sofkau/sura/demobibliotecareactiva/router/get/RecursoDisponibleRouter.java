package co.com.sofkau.sura.demobibliotecareactiva.router.get;

import co.com.sofkau.sura.demobibliotecareactiva.dto.RecursoDTO;
import co.com.sofkau.sura.demobibliotecareactiva.usecases.get.RecursoDisponibleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RecursoDisponibleRouter {
    @Bean
    public RouterFunction<ServerResponse> disponibilidadRecurso(RecursoDisponibleUseCase useCase){
        return route(GET("/disponibilidad/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.TEXT_PLAIN)
                        .body(BodyInserters
                                .fromPublisher(useCase.getRecursoPorID(
                                        request.pathVariable("id")), String.class
                                )
                        )
        );
    }
}
