package br.estudy.hibernate.dao;

import br.estudy.hibernate.connection.ConnectionFactory;
import br.estudy.hibernate.model.Produto;
import java.util.List;
import javax.persistence.EntityManager;

public class ProdutoDao {

    public Produto save(Produto produto) {
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.getTransaction().begin();
            if (produto.getId() == null) {
                em.persist(produto);
            } else {
                em.merge(produto);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return produto;
    }
    
    public Produto findById(Integer id) {
        EntityManager em = ConnectionFactory.getConnection();
        Produto produto = null;
        
        try {
            produto = em.find(Produto.class, id);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return produto;
    }
    
    public List<Produto> findAll() {
        EntityManager em = ConnectionFactory.getConnection();
        List<Produto> produtos = null;
        
        try {
            produtos = em.createQuery("from Produto p").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return produtos;
    }
    
    public Produto remove(Integer id) {
        EntityManager em = ConnectionFactory.getConnection();
        Produto produto = null;

        try {
            em.getTransaction().begin();
            produto = em.find(Produto.class, id);
            em.remove(produto);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            em.close();
        }
        return produto;
    }
}
