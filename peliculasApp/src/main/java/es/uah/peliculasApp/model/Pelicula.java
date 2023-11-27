package es.uah.peliculasApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "Peliculas", schema = "peliculasappdb")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPelicula", nullable = false)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 65)
    private String titulo;

    @Column(name = "anyo", nullable = false)
    private Integer anyo;

    @Column(name = "duracion", nullable = false)
    private Integer duracion;

    @Column(name = "pais", nullable = false, length = 2)
    private String pais;

    @Column(name = "direccion", nullable = false, length = 45)
    private String direccion;

    @Column(name = "genero", nullable = false, length = 45)
    private String genero;

    @Column(name = "sinopsis", nullable = false, length = 1000)
    private String sinopsis;

    @Column(name = "imagen", length = 350)
    private String imagen;

    @ManyToMany(mappedBy = "peliculas")
    @JsonIgnoreProperties("peliculas")
    private List<Actor> actores = new ArrayList<>();

    public void addActor(Actor actor) {
        if (actor != null) {
            getActores().add(actor);
        }
    }

    public void removeActor(Actor actor) {
        if (actor != null) {
            getActores().remove(actor);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(id, pelicula.id) && Objects.equals(titulo, pelicula.titulo)
                && Objects.equals(duracion, pelicula.duracion) && Objects.equals(direccion, pelicula.direccion)
                && Objects.equals(anyo, pelicula.anyo) && Objects.equals(genero, pelicula.genero) && Objects.equals(pais, pelicula.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}