package it.epicode.esercizi;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private Stato stato;
}

enum Stato {
    CONFERMATA,
    DA_CONFERMARE
}