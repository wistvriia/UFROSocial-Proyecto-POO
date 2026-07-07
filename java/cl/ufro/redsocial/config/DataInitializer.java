package cl.ufro.redsocial.config;

import cl.ufro.redsocial.model.Publicacion;
import cl.ufro.redsocial.model.Usuario;
import cl.ufro.redsocial.model.enums.Carrera;
import cl.ufro.redsocial.repository.PublicacionRepository;
import cl.ufro.redsocial.repository.UsuarioRepository;
import cl.ufro.redsocial.seguridad.CifradorContrasena;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
Inicializa datos de demostracion la primera vez que arranca la aplicacion
(si la base esta vacia), para que el feed no aparezca en blanco.

Tambien deja registrado en el log el tamano del catalogo de carreras.
*/
@Component //hace que la clase directamente se ejecute al iniciar el programa, en este caso para cargar los datos de prueba lo predeterminados
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    private final UsuarioRepository usuarioRepository;
    private final PublicacionRepository publicacionRepository;
    private final CifradorContrasena cifrador;

    public DataInitializer(UsuarioRepository usuarioRepository,
                           PublicacionRepository publicacionRepository,
                           CifradorContrasena cifrador) {
        this.usuarioRepository = usuarioRepository;
        this.publicacionRepository = publicacionRepository;
        this.cifrador = cifrador;
    }

    @Override //Sobreescribe
    public void run(String... args) { //Apunte para mi: String... args quiere decir que recibe una cantidad variable de argumentos, se puede llamar como un String[] args, pero también de otrs maneras, por eso utilizamos ese y no String[] args//
        log.info("Catálogo de carreras UFRO cargado: {} carreras.", Carrera.values().length);

        if (usuarioRepository.count() > 0) {
            return;
        }

        Usuario demo = new Usuario();
        demo.setEmail("demo@ufromail.cl");
        demo.setUsername("demo");
        demo.setNombreCompleto("Estudiante Demo");
        demo.setCarrera(Carrera.INGENIERIA_INFORMATICA);
        demo.setBiografia("Cuenta de prueba de la red social UFRO.");
        demo.setPasswordHash(cifrador.cifrar("demo1234"));
        demo = usuarioRepository.save(demo);


        //La primera publicacion, para probar
        Publicacion bienvenida = new Publicacion();
        bienvenida.setAutorId(demo.getId());
        bienvenida.setAutorUsername(demo.getUsername());
        bienvenida.setTexto("¡Bienvenidos a UFROSocial! 🎓 (publicación de prueba).");
        bienvenida.setCarreraTag(Carrera.INGENIERIA_INFORMATICA);
        publicacionRepository.save(bienvenida);


        //Segunda publicacion de prueba, pero sin tag de carrera
        Publicacion sinTag = new Publicacion();
        sinTag.setAutorId(demo.getId());
        sinTag.setAutorUsername(demo.getUsername());
        sinTag.setTexto("Publicación sin tag de carrera: aparece solo en el feed general.");
        publicacionRepository.save(sinTag);

        log.info("Datos de demostración creados. Acceso: demo@ufromail.cl / demo1234");
    }
}
