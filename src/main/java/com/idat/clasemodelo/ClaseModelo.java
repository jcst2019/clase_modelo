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
       
        // Listar todos los alumnos
        System.out.println("Lista INICIAL de Alumnos desde Procedimientos Almacenados:");
        AlumnoCRUD.listarAlumnos().forEach(System.out::println);
        
        // Agregar un nuevo alumno
        System.out.println("\nAgregando un nuevo alumno...");
        AlumnoCRUD.agregarAlumno("Ana Torres", 21, "Av. Primavera 123", "987654324");
        
        // Listar todos los alumnos
        System.out.println("Lista de estudiantes después de Agregar Alumno:");
        AlumnoCRUD.listarAlumnos().forEach(System.out::println);

        // Actualizar un alumno existente
        System.out.println("\nActualizando alumno con ID 1...");
        AlumnoCRUD.actualizarAlumno(1, "Juan Solar Actualizado", 39, "Piura", "987654328");

        // Listar todos los alumnos
        System.out.println("Lista de alumnos después de Actualizar Alumno:");
        AlumnoCRUD.listarAlumnos().forEach(System.out::println);
        
        // Eliminar un alumno
        System.out.println("\nEliminando alumno con ID 2...");
        AlumnoCRUD.eliminarAlumno(2);
        
        // Listar todos los alumnos
        System.out.println("Lista de alumnos después de Eliminar Alumno:");
        AlumnoCRUD.listarAlumnos().forEach(System.out::println);

        // Mostrar la lista actualizada
        System.out.println("\nLista FINAL de Alumnos desde Procedimientos Almacenados:");
        AlumnoCRUD.listarAlumnos().forEach(System.out::println);
        
    }
}
