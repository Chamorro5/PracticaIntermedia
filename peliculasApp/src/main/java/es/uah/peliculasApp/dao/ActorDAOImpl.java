package es.uah.peliculasApp.dao;

import es.uah.peliculasApp.model.Actor;
import es.uah.peliculasApp.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ActorDAOImpl implements IActoresDAO{

    @Autowired
    IActoresJPA actoresJPA;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    IPeliculasJPA peliculasJPA;

    @Override
    public List<Actor> buscarTodos() {
        return actoresJPA.findAll();
    }

    @Override
    public Actor buscarActorPorId(Integer idActor) {
        Optional<Actor> optional = actoresJPA.findById(idActor);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public Actor buscarActorPorNombre(String nombre) {
        Optional<Actor> optional =
                Optional.ofNullable(actoresJPA.findByNombre(nombre));
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void guardarActor(Actor actor) {
        actoresJPA.save(actor);
    }

    @Override
    public void eliminarActor(Integer idActor) {
        Optional<Actor> optional = actoresJPA.findById(idActor);
        if (optional.isPresent()) {
            Actor actor = optional.get();
            List<Pelicula> peliculas = actor.getPeliculas();
            for (Pelicula pelicula: peliculas) {
                peliculas.remove(actor);
            }
        }

        actoresJPA.deleteById(idActor);
    }

    @Override
    public void actualizarActor(Actor actor) {
        actoresJPA.save(actor);
    }

    @Override
    public void anyadirActorAPelicula(Integer idActor, Integer idPelicula) {
        Optional<Actor> optionalAlumno = actoresJPA.findById(idActor);
        if (optionalAlumno.isPresent()) {
            Actor actor = optionalAlumno.get();
            Optional<Pelicula> optionalPelicula = peliculasJPA.findById(idPelicula);
            if (optionalPelicula.isPresent()) {
                actor.addPelicula(optionalPelicula.get());
                actoresJPA.save(actor);
            }
        }
    }
}
