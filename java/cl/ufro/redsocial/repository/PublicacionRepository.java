package cl.ufro.redsocial.repository;

import cl.ufro.redsocial.model.Publicacion;
import cl.ufro.redsocial.model.enums.Carrera;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PublicacionRepository extends MongoRepository<Publicacion, String> {


    List<Publicacion> findAllByOrderByFechaCreacionDesc();


    List<Publicacion> findByCarreraTagOrderByFechaCreacionDesc(Carrera carreraTag);


    List<Publicacion> findByAutorIdOrderByFechaCreacionDesc(String autorId);
}
