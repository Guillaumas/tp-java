package fr.epsi.b3c1;

import fr.epsi.b3c1.BO.*;
import fr.epsi.b3c1.Animals.*;
import fr.epsi.b3c1.Enums.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Address address1 = new Address.Builder()
                .withNumber("25")
                .withStreet("Rue d'allonville")
                .withZipCode("44000")
                .withCity("Nantes")
                .build();

        Address address2 = new Address.Builder()
                .withNumber("50")
                .withStreet("Rue 2Allonville")
                .withZipCode("44001")
                .withCity("Nantes1")
                .build();

        PetStore petStore1 = new PetStore.Builder()
                .withName("SPA")
                .withManagerName("Chloé")
                .withAddress(address1)
                .build();

        PetStore petStore2 = new PetStore.Builder()
                .withName("Petshop")
                .withManagerName("Nolwenn")
                .withAddress(address2)
                .build();

        Animal animal1 = new Animal.Builder()
                .withBirth(LocalDate.now())
                .withColor("Black")
                .withPetStore(petStore1)
                .build();

        Animal animal2 = new Animal.Builder()
                .withBirth(LocalDate.of(2020, 1, 1))
                .withColor("White")
                .withPetStore(petStore2)
                .build();

        Product product1 = new Product.Builder()
                .withCode("SHP1")
                .withLabel("Shampooing pour chat")
                .withType(ProdType.CLEANING)
                .withPrice(10.0)
                .build();

        Product product2 = new Product.Builder()
                .withCode("PAT")
                .withLabel("Paté pour chat")
                .withType(ProdType.FOOD)
                .withPrice(2.0)
                .build();

        Cat cat1 = new Cat.Builder()
                .withChipId("C1")
                .build();
        cat1.setBirth(LocalDate.now());
        cat1.setColor("Brown");
        cat1.setPetStore(petStore1);

        Cat cat2 = new Cat.Builder()
                .withChipId("C2")
                .build();
        cat2.setBirth(LocalDate.of(1900, 1, 1));
        cat2.setColor("Gray");
        cat2.setPetStore(petStore2);

        Fish fish1 = new Fish.Builder()
                .withLivingEnv(FishLiveEnv.FRESHWATER)
                .build();
        fish1.setBirth(LocalDate.of(2021, 1, 1));
        fish1.setColor("Blue");
        fish1.setPetStore(petStore1);

        Fish fish2 = new Fish.Builder()
                .withLivingEnv(FishLiveEnv.SALTWATER)
                .build();
        fish2.setBirth(LocalDate.of(2003, 7, 4));
        fish2.setColor("Green");
        fish2.setPetStore(petStore2);

        em.persist(address1);
        em.persist(address2);
        em.persist(petStore1);
        em.persist(petStore2);
        em.persist(animal1);
        em.persist(animal2);
        em.persist(product1);
        em.persist(product2);
        em.persist(cat1);
        em.persist(cat2);
        em.persist(fish1);
        em.persist(fish2);

        em.getTransaction().commit();

        String petStoreName = "Petshop";
        Query query = em.createQuery("SELECT a FROM Animal a WHERE a.petStore.name = :name");
        query.setParameter("name", petStoreName);
        List<Animal> animals = query.getResultList();

        for (Animal animal : animals) {
            System.out.println(animal);
        }

        em.close();
        emf.close();




    }
}