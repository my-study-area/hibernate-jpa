package br.estudy.hibernate.ja;

import br.estudy.hibernate.connection.ConnectionFactory;
import br.estudy.hibernate.dao.ProdutoDao;
import br.estudy.hibernate.model.Categoria;
import br.estudy.hibernate.model.Produto;

public class TesteProduto {
    public static void main(String[] args) {
        
        Categoria categoria = new Categoria();
        categoria.setId(9);

//        Produto produto = new Produto();
//        produto.setDesricao("arroz");
//        produto.setQtd(1);
//        produto.setValor(2.20);
//        produto.setCategoria(categoria);
//        
//        ProdutoDao dao = new ProdutoDao();
//        dao.save(produto);

//        Produto produto = new Produto();
//        produto.setId(2);
//        produto.setDesricao("arroz alterado");
//        produto.setQtd(1);
//        produto.setValor(2.20);
//        produto.setCategoria(categoria);
//        
//        ProdutoDao dao = new ProdutoDao();
//        dao.save(produto);
      
        ProdutoDao dao = new ProdutoDao();
        Produto produto = dao.findById(1);

        System.out.println("==============================");
        System.out.println("Produto");
        System.out.println("==============================");
        System.out.println(produto);
        ConnectionFactory.emf.close();
    }
    
}
