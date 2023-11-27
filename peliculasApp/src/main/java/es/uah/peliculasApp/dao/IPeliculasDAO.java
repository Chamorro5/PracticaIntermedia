package es.uah.peliculasApp.dao;

import es.uah.peliculasApp.model.Pelicula;

import java.util.List;

public interface IPeliculasDAO {

    List<Pelicula> buscarTodos();
    Pelicula buscarPeliculaPorId(Integer idPelicula);
    List<Pelicula> buscarPeliculasPorTitulo(String titulo);
    List<Pelicula> buscarPeliculasPorGenero(String genero);
    List<Pelicula> buscarPeliculasPorDireccion(String direccion);
    void guardarPelicula(Pelicula pelicula);
    void eliminarPelicula(Integer idPelicula);
    void actualizarPelicula(Pelicula pelicula);
}
