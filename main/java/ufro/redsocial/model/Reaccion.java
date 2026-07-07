package ufro.redsocial.model;

import ufro.redsocial.model.enums.TipoReaccion;


public class Reaccion {

    private String usuarioId;
    private TipoReaccion tipo;

    public Reaccion() {
    }

    public Reaccion(String usuarioId, TipoReaccion tipo) {
        this.usuarioId = usuarioId;
        this.tipo = tipo;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public TipoReaccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoReaccion tipo) {
        this.tipo = tipo;
    }
}
