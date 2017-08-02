

package com.natansevero.dao;

import com.natansevero.excecao.PlacaDuplicadaException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    boolean create(T obj) throws IOException, ClassNotFoundException, PlacaDuplicadaException, SQLException;
    List<T> listAll() throws IOException, ClassNotFoundException, SQLException;
    boolean update(T obj) throws IOException, ClassNotFoundException, SQLException;
    boolean delete(T obj) throws IOException, ClassNotFoundException, SQLException;
    T read(String placa) throws IOException, ClassNotFoundException, SQLException;
}
