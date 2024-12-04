package it.epicode.esercizi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Relationships_Project");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();


        Location location = new Location();
        location.setNome("Conferenza su Among Us");
        location.setCitta("Discord");
        em.persist(location);


        Persona persona = new Persona();
        persona.setNome("Federico");
        persona.setCognome("Peralta");
        persona.setEmail("fede.pera@icloud.com");
        persona.setDataDiNascita(LocalDate.of(1990, 8, 16));
        persona.setSesso('M');
        em.persist(persona);


        Evento evento = new Evento();
        evento.setTitolo("Conferenza su Among Us");
        evento.setDataEvento(LocalDate.now());
        evento.setLocation(location);
        em.persist(evento);


        Partecipazione partecipazione = new Partecipazione();
        partecipazione.setPersona(persona);
        partecipazione.setEvento(evento);
        partecipazione.setStato(Stato.CONFERMATA);
        em.persist(partecipazione);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}