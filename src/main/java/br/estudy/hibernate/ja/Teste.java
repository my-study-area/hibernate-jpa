package br.estudy.hibernate.ja;

import br.estudy.hibernate.connection.ConnectionFactory;
import br.estudy.hibernate.dao.CategoriaDao;
import br.estudy.hibernate.model.Categoria;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        System.out.println("Olaaa");
        
//        Categoria c = new Categoria();
//        c.setId(9);
//        c.setDescricao("bebidax");
//        
//        CategoriaDao dao = new CategoriaDao();
//        dao.save(c);
//        System.out.println(c);
//        ConnectionFactory.emf.close();

//        CategoriaDao dao = new CategoriaDao();
//        Categoria categoria = dao.findById(9);
//        ConnectionFactory.emf.close();
//        System.out.println(categoria);

//        CategoriaDao dao = new CategoriaDao();
//        List<Categoria> categorias = dao.findAll();
//        System.out.println(categorias);
//        for (Categoria categoria : categorias) {
//            System.out.println("id: " + categoria.getId());
//            System.out.println("descrição: " + categoria.getDescricao());
//            System.out.println("======================");
//        }
//        ConnectionFactory.emf.close();

        CategoriaDao dao = new CategoriaDao();
        dao.remove(13);
        ConnectionFactory.emf.close();
    }
    
}
