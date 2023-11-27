package es.uah.peliculasApp.service;

import es.uah.peliculasApp.dao.IActoresDAO;
import es.uah.peliculasApp.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActoresServiceImpl implements IActoresService{

    @Autowired
    IActoresDAO actoresDAO;

    @Override
    public List<Actor> buscarTodos() {
        return actoresDAO.buscarTodos();
    }

    @Override
    public Actor buscarActorPorId(Integer idActor) {
        return actoresDAO.buscarActorPorId(idActor);
    }

    @Override
    public Actor buscarActorPorNombre(String nombre) {
        return actoresDAO.buscarActorPorNombre(nombre);
    }

    @Override
    public void guardarActor(Actor actor) {
        actoresDAO.guardarActor(actor);
    }

    @Override
    public void eliminarActor(Integer idActor) {
        actoresDAO.eliminarActor(idActor);
    }

    @Override
    public void actualizarActor(Actor actor) {
        actoresDAO.actualizarActor(actor);
    }

    @Override
    public void anyadirActorAPelicula(Integer idActor, Integer idPelicula) {
        actoresDAO.anyadirActorAPelicula(idActor, idPelicula);
    }
}
