package co.com.sofkau.sura.demobibliotecareactiva.mappers;

import co.com.sofkau.sura.demobibliotecareactiva.dto.RecursoDTO;
import co.com.sofkau.sura.demobibliotecareactiva.models.Recurso;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RecursoMapper {
    public Function<RecursoDTO, Recurso> mapperToRecurso(String id) {
        return recursoDTO -> {
            var recurso = new Recurso();
            recurso.setId(id);
            recurso.setTipoRecurso(recursoDTO.getTipoRecurso());
            recurso.setAreaTematica(recursoDTO.getAreaTematica());
            recurso.setTitulo(recursoDTO.getTitulo());
            recurso.setPrestado(recursoDTO.getPrestado());
            recurso.setFechaPrestamo(recursoDTO.getFechaPrestamo());
            return recurso;
        };
    }

    public Function<Recurso, RecursoDTO> mapperRecursoToDTO(){
        return recurso -> new RecursoDTO(
                recurso.getId(),
                recurso.getTitulo(),
                recurso.getTipoRecurso(),
                recurso.getAreaTematica(),
                recurso.getPrestado(),
                recurso.getFechaPrestamo()
        );
    }
}
