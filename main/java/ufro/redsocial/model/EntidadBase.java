package ufro.redsocial.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


public abstract class EntidadBase {

    @Id
    private String id;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    protected EntidadBase() {
    }
    public abstract String resumen();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
