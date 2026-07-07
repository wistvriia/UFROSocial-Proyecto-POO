package ufro.redsocial.model;

import ufro.redsocial.model.enums.Carrera;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Document(collection = "publicaciones")
public class Publicacion extends Contenido {

    private String imagenUrl;
    private Carrera carreraTag;          // tag opcional de carrera
    private LocalDateTime fechaEdicion;  // null mientras no se edite
    private List<Comentario> comentarios = new ArrayList<>();

    public Publicacion() {
    }

    @Override
    public String tipo() {
        return "Publicación";
    }

    public boolean isEditada() {
        return fechaEdicion != null;
    }

    public boolean tieneTag() {
        return carreraTag != null;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Carrera getCarreraTag() {
        return carreraTag;
    }

    public void setCarreraTag(Carrera carreraTag) {
        this.carreraTag = carreraTag;
    }

    public LocalDateTime getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(LocalDateTime fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
