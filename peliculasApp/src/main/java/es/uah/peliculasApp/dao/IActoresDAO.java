package es.uah.peliculasApp.dao;

import es.uah.peliculasApp.model.Actor;

import java.util.List;

public interface IActoresDAO {
    List<Actor> buscarTodos();
    Actor buscarActorPorId(Integer idActor);
    Actor buscarActorPorNombre(String nombre);
    void guardarActor(Actor actor);
    void eliminarActor(Integer idActor);
    void actualizarActor(Actor actor);
    void anyadirActorAPelicula(Integer idActor, Integer idPelicula);
}
