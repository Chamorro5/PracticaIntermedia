package es.uah.peliculasApp.dao;

import es.uah.peliculasApp.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActoresJPA extends JpaRepository<Actor, Integer> {
    Actor findByNombre(String nombre);
}