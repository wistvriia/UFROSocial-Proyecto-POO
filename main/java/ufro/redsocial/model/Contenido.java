package ufro.redsocial.model;

import ufro.redsocial.model.enums.TipoReaccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Clase abstracta para comentarios y publicaciones
public abstract class Contenido extends EntidadBase implements Reaccionable {

    private String autorId;
    private String autorUsername;
    private String texto;
    private List<Reaccion> reacciones = new ArrayList<>();

    protected Contenido() {
    }

    public abstract String tipo();

    @Override
    public void alternarReaccion(String usuarioId, TipoReaccion tipo) {
        Optional<Reaccion> existente = reacciones.stream()
                .filter(r -> r.getUsuarioId().equals(usuarioId))
                .findFirst();

        if (existente.isPresent()) {
            Reaccion reaccion = existente.get();
            if (reaccion.getTipo() == tipo) {
                reacciones.remove(reaccion);//la quita si es la que ya está puesta
            } else {
                reaccion.setTipo(tipo);  //la cambia o reemplaza si es que es distinta a la ya puesta
            }
        } else {
            reacciones.add(new Reaccion(usuarioId, tipo)); //la agrega si es que no había una previa
        }
    }

    @Override
    public long contarLikes() {
        return reacciones.stream()
                .filter(r -> r.getTipo() == TipoReaccion.LIKE)
                .count();
    }

    @Override
    public long contarDislikes() {
        return reacciones.stream()
                .filter(r -> r.getTipo() == TipoReaccion.DISLIKE)
                .count();
    }

    @Override
    public TipoReaccion reaccionDe(String usuarioId) {
        return reacciones.stream()
                .filter(r -> r.getUsuarioId().equals(usuarioId))
                .map(Reaccion::getTipo)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String resumen() {
        String recorte = (texto == null) ? ""
                : (texto.length() > 40 ? texto.substring(0, 40) + "..." : texto);
        return tipo() + " de @" + autorUsername + ": " + recorte;
    }

    public String getAutorId() {
        return autorId;
    }

    public void setAutorId(String autorId) {
        this.autorId = autorId;
    }

    public String getAutorUsername() {
        return autorUsername;
    }

    public void setAutorUsername(String autorUsername) {
        this.autorUsername = autorUsername;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public List<Reaccion> getReacciones() {
        return reacciones;
    }

    public void setReacciones(List<Reaccion> reacciones) {
        this.reacciones = reacciones;
    }
}
