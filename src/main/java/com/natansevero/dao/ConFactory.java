

package com.natansevero.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConFactory {
    public static Connection getConnection(String url, String usuario, String senha) throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver"); //ClassNotFoundException
        Connection con = DriverManager.getConnection(url, usuario, senha); //SqlException
        return con;
    }
}
