package Immunization.Schedule.demo.microservicio.modelos;

import Immunization.Schedule.demo.microservicio.modelos.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "vacune_dto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacunaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacuna")
    private Long id;

    @Column(name = "nombre_vacuna")
    private String nombreVacuna;

    @Column(name = "numero_dosis")
    private int numeroDosis;

    @Column(name = "cant_meses")
    private int cantMeses;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User usuario;

}
