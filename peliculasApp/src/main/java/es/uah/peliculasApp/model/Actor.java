package es.uah.peliculasApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "Actores", schema = "peliculasappdb")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idActor", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "fcNacimiento", nullable = false)
    private LocalDate fcNacimiento;

    @Column(name = "pais", nullable = false, length = 2)
    private String pais;

    @ManyToMany
    @JoinTable(name = "Peliculas_has_Actores",
            joinColumns = {@JoinColumn(name = "Actores_idActor", referencedColumnName = "idActor")},
            inverseJoinColumns = {@JoinColumn(name = "Peliculas_idPelicula", referencedColumnName = "idPelicula")})
    @JsonIgnoreProperties("actores")
    private List<Pelicula> peliculas = new ArrayList<>();

    public void addPelicula(Pelicula pelicula) {
        if (pelicula != null) {
            getPeliculas().add(pelicula);
            pelicula.addActor(this);
        }
    }

    public void removeCurso(Pelicula pelicula) {
        if (pelicula != null) {
            pelicula.removeActor(this);
            getPeliculas().remove(pelicula);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor alumno = (Actor) o;
        return Objects.equals(id, alumno.id) && Objects.equals(nombre, alumno.nombre) && Objects.equals(fcNacimiento, alumno.fcNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}