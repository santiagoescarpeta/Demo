package Immunization.Schedule.demo.microservicio.Repository;

import Immunization.Schedule.demo.microservicio.modelos.Usuario;
import Immunization.Schedule.demo.microservicio.modelos.Usuariodos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuariodos, Long> {
    Usuariodos findByUsername(String username);
}
