package com.example.aulajpa;

import domain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        remove(em, 2);
        em.clear();
        emf.close();
    }

    private static void FindById(EntityManager em, Integer id) {
        Person person = em.find(Person.class, id);
        System.out.println("Find! " + person);
    }

    private static void insert(EntityManager em, Person person) {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        System.out.println("Done! " + person);
    }

    private static void remove(EntityManager em, Integer id) {
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        em.remove(person);
        em.getTransaction().commit();
        System.out.println("Removed! " + person);
    }
}
