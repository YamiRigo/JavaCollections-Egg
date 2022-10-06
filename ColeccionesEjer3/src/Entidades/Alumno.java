/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.HashSet;

/**
 *
 * @author yamila
 */
public class Alumno {
    
    private String nombreAlumno;
    private HashSet<Integer> notas;

    public Alumno() {
        this.notas = new HashSet();
    }

    public Alumno(String nombreAlumno, HashSet<Integer> notas) {
        this.nombreAlumno = nombreAlumno;
        this.notas = notas;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public HashSet<Integer> getNotas() {
        return notas;
    }

    public void setNotas(HashSet<Integer> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Alumno{ " + "Nombre Alumno: " + nombreAlumno + ", Notas: " + notas + " }";
    }
    
    
    
    
}
