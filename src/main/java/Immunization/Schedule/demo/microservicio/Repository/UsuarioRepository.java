package Immunization.Schedule.demo.microservicio.Repository;

import Immunization.Schedule.demo.microservicio.modelos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
