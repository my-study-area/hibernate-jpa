package br.estudy.hibernate.ja;

import br.estudy.hibernate.dao.CategoriaDao;
import br.estudy.hibernate.model.Categoria;

public class Teste {
    public static void main(String[] args) {
        System.out.println("Olaaa");
        
        Categoria c = new Categoria();
        c.setDescricao("categoria dao");
        
        CategoriaDao dao = new CategoriaDao();
        dao.save(c);
    }
    
}
