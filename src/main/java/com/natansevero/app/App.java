

package com.natansevero.app;

import com.natansevero.dao.CarroDaoArquivo;
import com.natansevero.dao.CarroDaoBanco;
import com.natansevero.dao.ConFactory;
import com.natansevero.dao.ConFactory;
import com.natansevero.dao.Dao;
import com.natansevero.entidade.Carro;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class App {
    public static void main(String[] args) {
        Dao<Carro> dao = null;
        
        try {
//            Dao dao = new CarroDaoBanco();
            dao = new CarroDaoArquivo();
        } catch(IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        Carro carro = new Carro("000-0000", "palio", "fiat", 2008, "prata", 1);
        try {
            if(dao.create(carro)){
                System.out.println("Criado com sucesso");
            } else {
                System.out.println("Falha ao criar");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        
        try {
            List<Carro> carros = null;
            carros = dao.listAll();
            
            carros.forEach(System.out::println);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
}
