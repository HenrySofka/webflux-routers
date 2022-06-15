package co.com.sofkau.sura.demobibliotecareactiva.usecases.interfaces;

public interface ListarRecursosPorTipoYAreaTematica<T>{
    public T listarPorTipoYAreaTematica(String tipoRecurso, String areaTematica);
}
