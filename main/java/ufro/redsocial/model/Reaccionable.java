package cl.ufro.redsocial.model;

import cl.ufro.redsocial.model.enums.TipoReaccion;

import java.util.List;

public interface Reaccionable {

    void alternarReaccion(String usuarioId, TipoReaccion tipo);

    long contarLikes();

    long contarDislikes();

    TipoReaccion reaccionDe(String usuarioId);

    List<Reaccion> getReacciones();
}
