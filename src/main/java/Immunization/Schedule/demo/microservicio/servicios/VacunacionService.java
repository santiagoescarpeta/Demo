package Immunization.Schedule.demo.microservicio.servicios;

import Immunization.Schedule.demo.microservicio.modelos.User;
import Immunization.Schedule.demo.microservicio.modelos.VacunaDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VacunacionService {

    private final Map<Integer, List<VacunaDTO>> vacunasPorEdad;

    public VacunacionService() {
        this.vacunasPorEdad = new HashMap<>();
        configurarVacunasPorEdad();
    }

    private void configurarVacunasPorEdad() {
        List<VacunaDTO> vacunas0 = Arrays.asList(
                new VacunaDTO(null, "Tuberculosis B.C.G", 1, 0, null),
                new VacunaDTO(null, "Hepatitis B", 1, 0, null)
        );
        List<VacunaDTO> vacunas2 = Arrays.asList(
                new VacunaDTO(null, "Polio (Oral-IM)", 1, 2, null),
                new VacunaDTO(null, "Pentavalente: Hepatitis B, Haemophilus influenzae Tipo B y Difteria - Tosferina - Tétano (DPT)", 1, 2, null),
                new VacunaDTO(null, "Rotavirus", 1, 2, null),
                new VacunaDTO(null, "Neumococo", 1, 2, null)
        );
        List<VacunaDTO> vacunas4 = Arrays.asList(
                new VacunaDTO(null, "Polio (Oral-IM)", 2, 4, null),
                new VacunaDTO(null, "Pentavalente: Hepatitis B, Haemophilus influenzae Tipo B y Difteria - Tosferina - Tétano (DPT)", 2, 4, null),
                new VacunaDTO(null, "Rotavirus", 2, 4, null),
                new VacunaDTO(null, "Neumococo", 2, 4, null)
        );
        List<VacunaDTO> vacunas6 = Arrays.asList(
                new VacunaDTO(null, "Polio (Oral-IM)", 3, 6, null),
                new VacunaDTO(null, "Pentavalente: Hepatitis B, Haemophilus influenzae Tipo B y Difteria - Tosferina - Tétano (DPT)", 3, 6, null),
                new VacunaDTO(null, "Influenza", 1, 6, null)
        );
        List<VacunaDTO> vacunas7 = Collections.singletonList(
                new VacunaDTO(null, "Influenza", 2, 7, null)
        );
        List<VacunaDTO> vacunas12 = Arrays.asList(
                new VacunaDTO(null, "Sarampión Rubéola Paperas (SRP)", 1, 12, null),
                new VacunaDTO(null, "Fiebre Amarilla", 1, 12, null),
                new VacunaDTO(null, "Neumococo", 1, 12, null),
                new VacunaDTO(null, "Influenza", 1, 12, null),
                new VacunaDTO(null, "Hepatitis A", 1, 12, null)
        );
        List<VacunaDTO> vacunas18 = Arrays.asList(
                new VacunaDTO(null, "Difteria - Tosferina - Tétano (DPT)", 1, 18, null),
                new VacunaDTO(null, "Polio (Oral - IM)", 1, 18, null)
        );
        List<VacunaDTO> vacunas5anos = Arrays.asList(
                new VacunaDTO(null, "Difteria - Tosferina - Tétano (DPT)", 2, 60, null),
                new VacunaDTO(null, "Polio (Oral - IM)", 2, 60, null),
                new VacunaDTO(null, "Sarampión Rubéola Paperas (SRP)", 1, 60, null)
        );

        vacunasPorEdad.put(0, vacunas0);
        vacunasPorEdad.put(2, vacunas2);
        vacunasPorEdad.put(4, vacunas4);
        vacunasPorEdad.put(6, vacunas6);
        vacunasPorEdad.put(7, vacunas7);
        vacunasPorEdad.put(12, vacunas12);
        vacunasPorEdad.put(18, vacunas18);
        vacunasPorEdad.put(60, vacunas5anos);
    }

    public List<VacunaDTO> obtenerVacunasRecomendadas(int edad) {
        List<VacunaDTO> vacunasRecomendadas = new ArrayList<>();

        for (int i = 0; i <= edad; i++) {
            List<VacunaDTO> vacunas = vacunasPorEdad.get(i);
            if (vacunas != null) {
                vacunasRecomendadas.addAll(vacunas);
            }
        }
        return vacunasRecomendadas;
    }
}
