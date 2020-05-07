package br.estudy.hibernate.dao;

import br.estudy.hibernate.connection.ConnectionFactory;
import br.estudy.hibernate.model.Categoria;
import javax.persistence.EntityManager;

public class CategoriaDao {

    public Categoria save(Categoria categoria) {
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.getTransaction().begin();
            if(categoria.getId() == null) {
                em.persist(categoria);
            } else {
                em.merge(categoria);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return categoria;
    }
    
}
