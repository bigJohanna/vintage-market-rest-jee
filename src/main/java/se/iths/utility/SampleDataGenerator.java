package se.iths.utility;

import se.iths.entity.Item;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup //klassen körs när den startas
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct // så fort bönan är skapad körs metoden.
    public void generateData(){

        entityManager.persist(new Item());

    }

}
