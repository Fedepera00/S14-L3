package it.epicode.esercizi;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titolo;
    private LocalDate dataEvento;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Partecipazione> listaPartecipazioni;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;
}