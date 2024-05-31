package Immunization.Schedule.demo.microservicio.servicios;

import Immunization.Schedule.demo.microservicio.Repository.UsuarioRepository;
import Immunization.Schedule.demo.microservicio.modelos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<User> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }
}