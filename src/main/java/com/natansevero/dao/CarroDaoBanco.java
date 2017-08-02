

package com.natansevero.dao;

import com.natansevero.dao.ConFactory;
import com.natansevero.entidade.Carro;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CarroDaoBanco implements Dao<Carro> {
    
    private String url;
    private String usuario;
    private String senha;
    private Connection con;
    
    public CarroDaoBanco() throws IOException, ClassNotFoundException, SQLException{
        url = "jdbc:postgresql://localhost:5432/Locadora";
        usuario = "postgres";
        senha = "12345";
        con = ConFactory.getConnection(url, usuario, senha);
    }
    
    @Override
    public boolean create(Carro c) throws SQLException{
        PreparedStatement stmt = con.prepareStatement("insert into carro values(?,?,?,?,?,?)");
        stmt.setString(1, c.getPlaca());
        stmt.setString(2, c.getFabricante());
        stmt.setString(3, c.getModelo());
        stmt.setInt(4, c.getAno());
        stmt.setString(5, c.getCor());
        stmt.setFloat(6, c.getPotencia());
        
        return stmt.executeUpdate() > 0;         
    }
    
    @Override
    public List<Carro> listAll() throws SQLException{
        PreparedStatement stmt = con.prepareStatement("select * from carro");
        ResultSet rs = stmt.executeQuery();
        
        List<Carro> carros = new ArrayList<>();
        while(rs.next()) {
            Carro carro = new Carro();
            carro.setPlaca(rs.getString(1));
            carro.setFabricante(rs.getString(2));
            carro.setModelo(rs.getString(3));
            carro.setAno(rs.getInt(4));
            carro.setCor(rs.getString(5));
            carro.setPotencia(rs.getFloat(6));
            
            carros.add(carro);
        }
        
        return carros;
    }
    
    @Override
    public Carro read(String placa) throws SQLException{
        PreparedStatement stmt = con.prepareStatement("select * from carro where placa = ?");
        stmt.setString(1, placa);
        ResultSet rs = stmt.executeQuery();
        
        Carro carro = null;
        
        if(rs.next()){
            carro = new Carro();
            carro.setPlaca(rs.getString(1));
            carro.setFabricante(rs.getString(2));
            carro.setModelo(rs.getString(3));
            carro.setAno(rs.getInt(4));
            carro.setCor(rs.getString(5));
            carro.setPotencia(rs.getFloat(6));
        }    
        
        return carro;
       
    }
    
    @Override
    public boolean update(Carro c) throws SQLException{
        PreparedStatement stmt = con.prepareStatement("update carro set fabricante=?, modelo=?, "
                + "ano=?, cor=?, potencia=? "
                + "where placa=?");
        stmt.setString(1, c.getFabricante());
        stmt.setString(2, c.getModelo());
        stmt.setInt(3, c.getAno());
        stmt.setString(4, c.getCor());
        stmt.setFloat(5, c.getPotencia());
        stmt.setString(6, c.getPlaca());
        
        return stmt.executeUpdate() > 0;
    }
    
    @Override
    public boolean delete(Carro c) throws SQLException{
        PreparedStatement stmt = con.prepareStatement("delete from carro where placa = ?");
        stmt.setString(1, c.getPlaca());
        
        return stmt.executeUpdate() > 0;
    }
}
