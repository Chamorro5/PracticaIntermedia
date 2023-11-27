package es.uah.peliculasApp.dao;

import es.uah.peliculasApp.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPeliculasJPA extends JpaRepository<Pelicula, Integer> {
    List<Pelicula> findByTituloContainingIgnoreCase(String titulo);
    List<Pelicula> findByGeneroContainingIgnoreCase(String genero);
    List<Pelicula> findByDireccion(String direccion);
}