

package com.natansevero.app;

import com.natansevero.dao.CarroDaoArquivo;
import com.natansevero.dao.CarroDaoBanco;
import com.natansevero.dao.ConFactory;
import com.natansevero.dao.ConFactory;
import com.natansevero.dao.Dao;
import com.natansevero.entidade.Carro;


public class App {
    public static void main(String[] args) {
        try {
//            Dao dao = new CarroDaoBanco();
            Dao dao = new CarroDaoArquivo();
        } catch(Exception e) {
            e.printStackTrace();
        }
      
        
    }
}
