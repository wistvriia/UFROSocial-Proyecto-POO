package ufro.redsocial.repository;

import ufro.redsocial.model.Publicacion;
import ufro.redsocial.model.enums.Carrera;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PublicacionRepository extends MongoRepository<Publicacion, String> {


    List<Publicacion> findAllByOrderByFechaCreacionDesc();


    List<Publicacion> findByCarreraTagOrderByFechaCreacionDesc(Carrera carreraTag);


    List<Publicacion> findByAutorIdOrderByFechaCreacionDesc(String autorId);
}
