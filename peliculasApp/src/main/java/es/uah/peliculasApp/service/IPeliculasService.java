package es.uah.peliculasApp.service;

import es.uah.peliculasApp.model.Pelicula;

import java.util.List;

public interface IPeliculasService {

    List<Pelicula> buscarTodos();
    Pelicula buscarPeliculaPorId(Integer idPelicula);
    List<Pelicula> buscarPeliculasPorTitulo(String titulo);
    List<Pelicula> buscarPeliculasPorGenero(String genero);
    List<Pelicula> buscarPeliculasPorDireccion(String direccion);
    void guardarPelicula(Pelicula pelicula);
    void eliminarPelicula(Integer idPelicula);
    void actualizarPelicula(Pelicula pelicula);
}
