package Immunization.Schedule.demo.microservicio.servicios;

import Immunization.Schedule.demo.microservicio.modelos.CalendarioVacunacion;
import Immunization.Schedule.demo.microservicio.modelos.User;
import Immunization.Schedule.demo.microservicio.modelos.VacunaDTO;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarioVacunacionService {

    @Autowired
    private EmailService emailSender;
    @Autowired
    private VacunacionService vacunacionService;

    public List<VacunaDTO> generarCalendarioVacunacion(User usuario) throws MessagingException {

        CalendarioVacunacion calendarioVacunacion = new CalendarioVacunacion();
        calendarioVacunacion.setUsuario(usuario);
        List<VacunaDTO> vacunasRecomendadas = vacunacionService.obtenerVacunasRecomendadas(usuario.getEdad());

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Hola ").append(usuario.getUsername()).append(", te informamos que las vacunas recomendadas con " + usuario.getEdad() + " meses son:\n");

        if(vacunasRecomendadas.isEmpty()){
            mensaje.append("Las edades despues de los 5 años");
        }else{
            for (VacunaDTO vacuna : vacunasRecomendadas) {
                mensaje.append("- ").append(vacuna.getNombreVacuna());
                mensaje.append("  ..... dosis : ").append(vacuna.getNumeroDosis());
                mensaje.append("  ..... a los " + vacuna.getCantMeses() + " meses").append("\n");
            }
            emailSender.sendEmail(usuario.getUsername(), usuario.getUsername() + " - Alerta y notificación", mensaje.toString());
        }
        return vacunasRecomendadas;
    }
}