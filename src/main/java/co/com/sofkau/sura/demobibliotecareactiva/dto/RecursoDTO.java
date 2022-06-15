package co.com.sofkau.sura.demobibliotecareactiva.dto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Objects;

public class RecursoDTO {
    private String id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String tipoRecurso;
    @NotBlank
    private String areaTematica;
    @NotBlank
    private Boolean isPrestado;
    @NotBlank
    private LocalDate fechaPrestamo;

    public RecursoDTO() {
    }

    public RecursoDTO(String titulo, String tipoRecurso, String areaTematica, Boolean isPrestado, LocalDate fechaPrestamo) {
        this.titulo = titulo;
        this.tipoRecurso = tipoRecurso;
        this.areaTematica = areaTematica;
        this.isPrestado = isPrestado;
        this.fechaPrestamo = fechaPrestamo;
    }

    public RecursoDTO(String id, String titulo, String tipoRecurso, String areaTematica, Boolean isPrestado, LocalDate fechaPrestamo) {
        this.id = id;
        this.titulo = titulo;
        this.tipoRecurso = tipoRecurso;
        this.areaTematica = areaTematica;
        this.isPrestado = isPrestado;
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public String getAreaTematica() {
        return areaTematica;
    }

    public void setAreaTematica(String areaTematica) {
        this.areaTematica = areaTematica;
    }

    public Boolean getPrestado() {
        return isPrestado;
    }

    public void setPrestado(Boolean prestado) {
        isPrestado = prestado;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecursoDTO that = (RecursoDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(titulo, that.titulo) && Objects.equals(tipoRecurso, that.tipoRecurso) && Objects.equals(areaTematica, that.areaTematica) && Objects.equals(isPrestado, that.isPrestado) && Objects.equals(fechaPrestamo, that.fechaPrestamo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, tipoRecurso, areaTematica, isPrestado, fechaPrestamo);
    }

    @Override
    public String toString() {
        return "RecursoDTO{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", tipoRecurso='" + tipoRecurso + '\'' +
                ", areaTematica='" + areaTematica + '\'' +
                ", isPrestado=" + isPrestado +
                ", fechaPrestamo=" + fechaPrestamo +
                '}';
    }
}
