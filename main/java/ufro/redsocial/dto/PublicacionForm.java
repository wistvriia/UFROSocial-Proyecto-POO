package ufro.redsocial.dto;

import ufro.redsocial.model.enums.Carrera;

public class PublicacionForm {

    private String texto;
    private Carrera carreraTag;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Carrera getCarreraTag() {
        return carreraTag;
    }

    public void setCarreraTag(Carrera carreraTag) {
        this.carreraTag = carreraTag;
    }
}
