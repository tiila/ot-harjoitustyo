/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studytracker.db;

import java.sql.*;

/**
 *
 * @author dell
 */
public interface Dao<T, K> {

    void create(T object) throws SQLException;

    T read(K key) throws SQLException;

    void delete(K key) throws SQLException;
    
}
