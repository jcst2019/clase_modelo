/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idat.clasemodelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Solaris
 */
public class AlumnoCRUD {
    
    public static List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        String procedimiento = "{CALL sp_ObtenerAlumnos()}";

        try (
             Connection conexion = ConexionBD.obtenerConexion();
             CallableStatement callableStatement = conexion.prepareCall(procedimiento);
             ResultSet resultado = callableStatement.executeQuery()
             ) {

            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setId(resultado.getInt("id"));
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setEdad(resultado.getInt("edad"));
                alumno.setDireccion(resultado.getString("direccion"));
                alumno.setTelefono(resultado.getString("telefono"));
                alumnos.add(alumno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return alumnos;
    }
    
}
