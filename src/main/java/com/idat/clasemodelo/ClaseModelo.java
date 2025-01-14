/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.idat.clasemodelo;

/**
 *
 * @author Solaris
 */
public class ClaseModelo {

    public static void main(String[] args) {
       
        // Listar todos los estudiantes
        System.out.println("Lista Inicial de Alumnos desde Procedimientos Almacenados:");
        AlumnoCRUD.listarAlumnos().forEach(System.out::println);
        
    }
}
