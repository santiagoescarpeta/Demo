package Immunization.Schedule.demo.microservicio.servicios;

import Immunization.Schedule.demo.microservicio.modelos.User;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecordatorioVacunacionScheduler {

    @Autowired
    private EmailService emailSender;

    @Autowired
    private UsuarioService usuarioService;

    // Se ejecuta todos los días a la medianoche
    @Scheduled(cron = "0 40 19 * * ?")
    public void enviarRecordatorios() {
        // Mensaje a enviar
        String mensaje = "¡Hola! Recuerda tener tus vacunas al día y actualizar tu información para conocer tu estado de salud.";

        // Obtener todos los usuarios
        List<User> usuarios = usuarioService.obtenerTodosLosUsuarios();

        // Enviar mensaje a todos los usuarios
        for (User usuario : usuarios) {
            try {
                emailSender.sendEmail(usuario.getUsername(), "Recordatorio de vacunación", mensaje);
            } catch (MessagingException e) {
                // Manejar la excepción si ocurre algún problema al enviar el correo
                e.printStackTrace();
            }
        }
    }
}