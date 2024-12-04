package it.epicode.esercizi;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String citta;
}