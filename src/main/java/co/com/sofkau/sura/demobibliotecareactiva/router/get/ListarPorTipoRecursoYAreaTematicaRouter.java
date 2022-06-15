package co.com.sofkau.sura.demobibliotecareactiva.router.get;

import co.com.sofkau.sura.demobibliotecareactiva.dto.RecursoDTO;
import co.com.sofkau.sura.demobibliotecareactiva.usecases.get.ListarPorAreaTematicaUseCase;
import co.com.sofkau.sura.demobibliotecareactiva.usecases.get.ListarPorTipoRecursoYAreaTematicaUseCase;
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
public class ListarPorTipoRecursoYAreaTematicaRouter {
    @Bean
    public RouterFunction<ServerResponse> listarPorTipoRecursoYAreaTematica(ListarPorTipoRecursoYAreaTematicaUseCase useCase){
        return route(GET("/tipo_tematica/{tipoRecurso}/{areaTematica}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(useCase.listarPorTipoYAreaTematica(
                                        request.pathVariable("tipoRecurso"),
                                        request.pathVariable("areaTematica")
                                        ), RecursoDTO.class
                                )
                        )
        );
    }

}
