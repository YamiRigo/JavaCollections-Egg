/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Alumno;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author yamila
 */
public class AlumnoService {
    
    private Scanner leer;
    //Acá creo mi colección de Objetos Alumno
    private ArrayList<Alumno> alumnosList;
    
    //Constructor sin parametros (o vacio) pero que instancia
    //el scanner y la lista
    public AlumnoService(){
        this.leer = new Scanner(System.in);
        this.alumnosList = new ArrayList();
    }
    
    //Método privado porque lo voy a llamar solo desde esta clase
    private Alumno creaAlumno(){
        System.out.println("Ingreso del nombre del alumno");
        String alumno = leer.next().toUpperCase();
        HashSet<Integer> notas = new HashSet(3);
        System.out.println("Ingreso de las 3 notas del alumno");
        int n1 = leer.nextInt();
        notas.add(n1);
        int n2 = leer.nextInt();
        notas.add(n2);
        int n3 = leer.nextInt();
        notas.add(n3);
        
        Alumno a = new Alumno(alumno, notas);
        alumnosList.add(a);
        return a;
    }
    
    public void crearAlumno(){
        char op;
        //Hacer
        do{
            creaAlumno(); //llamo al método privado que pide los datos al usuario
            System.out.println("Desea agregar otro Alumno"
                + " 'S' para Continuar o 'N' para Salir");
            op = leer.next().toUpperCase().charAt(0);
        }while(op != 'N'); //Mientras op sea distinto de N
    }
    
    
    public void notaFinal(){
        
        System.out.println("Ingreso del alumnno al que quiere calcular la nota");
        String buscar = leer.next().toUpperCase();
        Iterator<Alumno> it = alumnosList.iterator(); //Iterator con la lista de alumnos
        
        while(it.hasNext()){
            Integer sumaNota = 0; //Variable para acumular las notas
            //Objeto aux de la clase Alumno donde voy a ir asignando las iteraciones de it
            Alumno aux = it.next();
            
            //Comparo si el nombre del obj aux es igual al nombre "buscar"
            if(aux.getNombreAlumno().equals(buscar)){
                //Cuanto encuentra el nombre crea una colección HashSet aux para asignar...
                HashSet<Integer> notasAux = aux.getNotas();
                //... notas del alumno encontrado y así poder recorrer y sumar las notas 
                for(Integer finalNota: notasAux){
                    sumaNota += finalNota;
                }
                System.out.println("La nota final promediada es: " + (float)(sumaNota/3));
            }
            
            if(sumaNota == 0){
                System.out.println("No se encontro el Alumno");
            }
        }
        
    }
    
}
