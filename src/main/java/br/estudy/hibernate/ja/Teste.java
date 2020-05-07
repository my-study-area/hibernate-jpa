package br.estudy.hibernate.ja;

import br.estudy.hibernate.model.Categoria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
    public static void main(String[] args) {
        System.out.println("Olaaa");
        
        Categoria c = new Categoria();
        c.setDescricao("alimento");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("seuPU");
        EntityManager  em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        
        System.out.println(c.getId());
        System.out.println(c.getDescricao());
        
        em.close();
        emf.close();
    }
    
}
