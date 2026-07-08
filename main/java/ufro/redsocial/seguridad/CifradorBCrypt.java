package ufro.redsocial.seguridad;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CifradorBCrypt implements CifradorContrasena {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String cifrar(String textoPlano) {
        return encoder.encode(textoPlano);
    }

    @Override
    public boolean coincide(String textoPlano, String hash) {
        if (textoPlano == null || hash == null) {
            return false;
        }
        return encoder.matches(textoPlano, hash);
    }
}
