package ufro.redsocial.seguridad;

public interface CifradorContrasena {

    String cifrar(String textoPlano);

    boolean coincide(String textoPlano, String hash);
}
