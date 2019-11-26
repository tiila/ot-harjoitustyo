/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studytracker.domain;

import java.sql.SQLException;
import studytracker.db.DatabaseConnection;

/**
 *
 * @author dell
 */
public class Functionality {

    private DatabaseConnection dbconnection;

    // @throws SQLException jos tietokantaa ei voida luoda
    public Functionality() throws SQLException {

        this.dbconnection = new DatabaseConnection("studytracker.db");

    }
}

//metodit
