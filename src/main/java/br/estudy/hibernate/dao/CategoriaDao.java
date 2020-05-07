package br.estudy.hibernate.dao;

import br.estudy.hibernate.connection.ConnectionFactory;
import br.estudy.hibernate.model.Categoria;
import java.util.List;
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

    public Categoria findById(Integer id) {
        EntityManager em = ConnectionFactory.getConnection();
        Categoria categoria = null;
        try {
            categoria = em.find(Categoria.class, id);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return categoria;
    }
    

    public List<Categoria> findAll() {
        EntityManager em = ConnectionFactory.getConnection();
        List<Categoria> categorias = null;
        try {
            categorias = em.createQuery("from Categoria c").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return categorias;
    }
}

