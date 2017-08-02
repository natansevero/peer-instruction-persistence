

package com.natansevero.dao;

import com.natansevero.excecao.PlacaDuplicadaException;
import com.natansevero.entidade.Carro;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CarroDaoArquivo implements Dao<Carro> {
    
    private File arquivo;
    
    public CarroDaoArquivo() throws IOException, ClassNotFoundException, SQLException{
        arquivo = new File("Carros.bin");
        if(!arquivo.exists()) arquivo.createNewFile();
    }
    
    @Override
    public boolean create(Carro c) throws IOException, ClassNotFoundException, PlacaDuplicadaException{
        
        if(read(c.getPlaca()) != null)
            throw new PlacaDuplicadaException("Já existe um carro com essa placa");
        
        List<Carro> carros = listAll();
        if(carros.add(c)){
            save(carros);
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public Carro read(String placa) throws IOException, ClassNotFoundException{
        List<Carro> carros = listAll();
        
        for(Carro c : carros) 
            if(c.getPlaca().equals(placa)) return c; 
        
        return null;
    }
    
    @Override
    public List<Carro> listAll() throws IOException, ClassNotFoundException{
        List<Carro> carros = null;
        
        if(arquivo.length() > 0){
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo));
            carros = (List<Carro>) in.readObject();
            in.close();
        } else {
            carros = new ArrayList<>();
        }
        return carros;
    }
    
    @Override
    public boolean update(Carro c) throws IOException, ClassNotFoundException{
        List<Carro> carros = listAll();
        for(int i =0; i < carros.size(); i++){
            if(carros.get(i).getPlaca().equals(c.getPlaca())){
                carros.set(i, c);
                
                save(carros);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean delete(Carro c) throws IOException, ClassNotFoundException{
       List<Carro> carros = listAll();
        if(carros.remove(c)){
            save(carros);
            return true;
        }else{
            return false;
        }
    }
    
    private void save(List<Carro> carros) throws FileNotFoundException, IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
        out.writeObject(carros);
        out.close();
    }
}
