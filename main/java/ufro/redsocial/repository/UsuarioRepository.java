package ufro.redsocial.repository;

import ufro.redsocial.model.Usuario;
import ufro.redsocial.model.enums.Carrera;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    Optional<Usuario> findByEmailIgnoreCase(String email);

    Optional<Usuario> findByUsernameIgnoreCase(String username);

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByUsernameIgnoreCase(String username);

    List<Usuario> findByCarrera(Carrera carrera);
}
