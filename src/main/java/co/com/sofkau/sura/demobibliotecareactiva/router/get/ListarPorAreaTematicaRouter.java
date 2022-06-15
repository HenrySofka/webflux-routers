package co.com.sofkau.sura.demobibliotecareactiva.router.get;

import co.com.sofkau.sura.demobibliotecareactiva.dto.RecursoDTO;
import co.com.sofkau.sura.demobibliotecareactiva.usecases.get.ListarPorAreaTematicaUseCase;
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
public class ListarPorAreaTematicaRouter {
    @Bean
    public RouterFunction<ServerResponse> listarPorAreaTematica(ListarPorAreaTematicaUseCase useCase){
        return route(GET("/tematica/{areaTematica}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(useCase.apply(
                                        request.pathVariable("areaTematica")), RecursoDTO.class
                                )
                        )
        );
    }

}
