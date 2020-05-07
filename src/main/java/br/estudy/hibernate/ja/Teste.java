package br.estudy.hibernate.ja;

import br.estudy.hibernate.connection.ConnectionFactory;
import br.estudy.hibernate.model.Categoria;
import javax.persistence.EntityManager;

public class Teste {
    public static void main(String[] args) {
        System.out.println("Olaaa");
        
        Categoria c = new Categoria();
        c.setDescricao("teste");
        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("seuPU");
        EntityManager  em = ConnectionFactory.getConnection();
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        
        System.out.println(c.getId());
        System.out.println(c.getDescricao());
        
        em.close();
        ConnectionFactory.getConnection().close();
        
    }
    
}
