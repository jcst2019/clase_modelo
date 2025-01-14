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
    
    public static void agregarAlumno(String nombre, int edad, String direccion, String telefono) {
        String procedimiento = "{CALL sp_AgregarAlumno(?, ?, ?, ?)}";

        try (Connection conexion = ConexionBD.obtenerConexion();
             CallableStatement callableStatement = conexion.prepareCall(procedimiento)) {

            callableStatement.setString(1, nombre);
            callableStatement.setInt(2, edad);
            callableStatement.setString(3, direccion);
            callableStatement.setString(4, telefono);
            callableStatement.executeUpdate();
            System.out.println("Alumno agregado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void actualizarAlumno(int id, String nombre, int edad, String direccion, String telefono) {
        String procedimiento = "{CALL sp_ActualizarAlumno(?, ?, ?, ?, ?)}";

        try (Connection conexion = ConexionBD.obtenerConexion();
             CallableStatement callableStatement = conexion.prepareCall(procedimiento)) {

            callableStatement.setInt(1, id);
            callableStatement.setString(2, nombre);
            callableStatement.setInt(3, edad);
            callableStatement.setString(4, direccion);
            callableStatement.setString(5, telefono);
            callableStatement.executeUpdate();
            System.out.println("Alumno actualizado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void eliminarAlumno(int id) {
        String procedimiento = "{CALL sp_EliminarAlumno(?)}";

        try (Connection conexion = ConexionBD.obtenerConexion();
             CallableStatement callableStatement = conexion.prepareCall(procedimiento)) {

            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
            System.out.println("Alumno eliminado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
}
