package ufro.redsocial.model.enums;

public enum TipoReaccion {
    LIKE("Me gusta", "👍"),
    DISLIKE("No me gusta", "👎");

    private final String etiqueta;
    private final String emoji;

    TipoReaccion(String etiqueta, String emoji) {
        this.etiqueta = etiqueta;
        this.emoji = emoji;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public String getEmoji() {
        return emoji;
    }
}
