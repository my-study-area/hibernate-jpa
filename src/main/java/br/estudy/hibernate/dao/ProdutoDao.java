package br.estudy.hibernate.dao;

import br.estudy.hibernate.connection.ConnectionFactory;
import br.estudy.hibernate.model.Produto;
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
}
