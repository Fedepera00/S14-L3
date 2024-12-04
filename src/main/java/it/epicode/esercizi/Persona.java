package it.epicode.esercizi;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private char sesso;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Partecipazione> listaPartecipazioni;
}