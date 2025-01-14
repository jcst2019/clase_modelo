/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.clasemodelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Solaris
 */
public class ConexionBD {
    
    private static final String URL= "jdbc:mysql://localhost:3306/bdEscuela";
    private static final String USUARIO= "root";
    private static final String CLAVE= "solaris";
    
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
    
}
