package Immunization.Schedule.demo.microservicio.servicios;

import Immunization.Schedule.demo.microservicio.Repository.UsuarioRepository;
import Immunization.Schedule.demo.microservicio.modelos.Usuario;
import Immunization.Schedule.demo.microservicio.modelos.Usuariodos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository; // Suponiendo que tienes un repositorio para los usuarios

    public List<Usuariodos> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }
}