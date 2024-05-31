package Immunization.Schedule.demo.microservicio.modelos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "calendario_vacunacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalendarioVacunacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calendario")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_vacuna", referencedColumnName = "id_vacuna")
    private VacunaDTO vacuna;
}
