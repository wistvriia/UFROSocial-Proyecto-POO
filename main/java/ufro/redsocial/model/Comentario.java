package ufro.redsocial.model;

import java.util.ArrayList;
import java.util.List;

public class Comentario extends Contenido {

    private List<Respuesta> respuestas = new ArrayList<>();

    public Comentario() {
    }

    @Override
    public String tipo() {
        return "Comentario";
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
}
