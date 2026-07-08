package ufro.redsocial.service;

import ufro.redsocial.dto.RegistroForm;
import ufro.redsocial.model.Usuario;

public interface AuthService {
    Usuario registrar(RegistroForm form);

    Usuario login(String email, String password);
}
