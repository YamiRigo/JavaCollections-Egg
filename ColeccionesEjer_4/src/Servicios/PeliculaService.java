/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Pelicula;
import Utilidades.Comparadores;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author yamila
 */
public class PeliculaService {
    
    private static Scanner leer;
    //Acá creo mi Colección de Objetos Pelicula
    private static ArrayList<Pelicula> misPelis;
    
    //Construtor vacio pero con instanciación del Scanner y la lista

    public PeliculaService() {
         this.leer = new Scanner(System.in);
         this.misPelis = new ArrayList<>();
    }
    
    //String titulo, String director, Integer duracion
    private Pelicula creaPeli(){
        System.out.println("Cuál es el título de la Pelicula?");
        String title = leer.next();
        System.out.println("Quién es el Director?");
        String direct = leer.next();
        System.out.println("Cuánto dura la Pelicula en minutos?");
        Integer hs = leer.nextInt();
        
        //Agrego la pelicula creada a la colección de peliculas
        return new Pelicula(title, direct, hs);
    }
    
    //Método que agrega Peliculas al ArrayList de Peliculas, mediante la
    //invocación del método privado creaPeli
    public void misPelis(){
        char op;
        
        do{
            misPelis.add(creaPeli());
            System.out.println("Desea agregar otra pelicual? S/N");
            op = leer.next().toUpperCase().charAt(0);
        }while(op != 'N');
    }
    
    //Mostrar en pantalla todas las peliculas a través de un for each, utilizando
    //en cada ciclo el método toString sobreescrito de la clase Pelicula
    public void mostrarPeliculas(){
        System.out.println("** Mostrar en pantalla todas la peliculas **");
        misPelis.forEach(aux -> { System.out.println(aux);
        });
        System.out.println("");
    }
    
    //Mostrar en pantalla todas las peliculas con una duración mayor a 1 hora
    public void mostrarPeliculas1Hs(){
        System.out.println("** Mostrar en pantalla todas las peliculas con una duración mayor a 1 hora **");
        misPelis.stream().filter(peli -> (peli.getDuracion() > 60)).forEachOrdered(peli -> {
            System.out.println(peli);
        });
        System.out.println("");
    }
    
    //Ordenar las peliculas de acuerdo a su duración (de mayor a menor) y 
    //mostrarlo en pantalla
    public void ordenarPeliPorDuracionMayor(){
        System.out.println("** Mostrar peliculas de acuerdo a su duración de mayor a menor **");
        Collections.sort(misPelis, Comparadores.porDuracionMayor); //Ordena la Colección misPelis con el Comparador porDuracionMayor
        
        misPelis.forEach(peli -> {
            System.out.println(peli);
        }); //Muestra lo ordenado
        System.out.println("");
    }
    
    //Ordenar las peliculas de acuerdo a su duración (de menor a meyor) y 
    //mostrarlo en pantalla. Utilizando los comparadores de la clase Utilidades
    public void ordenarPeliPorDuracionMenor(){
        System.out.println("** Mostrar peliculas de acuerdo a su duración de menor a mayor **");
        Collections.sort(misPelis, Comparadores.porDuracionMenor); //Ordena con el Comparator porDuracionMenor
        
        misPelis.forEach(peli -> {
            System.out.println(peli);
        }); //Muestra lo ordenado
        System.out.println("");
    }
    
    //Ordenar las peliculas por titulo, alfabeticamente y mostrarlo en pantalla
    //Utilizando los comparadores de la clase Utilidades
    public void ordenarPeliPorTitulo(){
        System.out.println("** Mostrar las peliculas ordenadas por el Titulo alfabeticamente **");
        Collections.sort(misPelis, Comparadores.porTitulo); //Ordena con el Comparator porTitulo
        
        misPelis.forEach(peli -> {
            System.out.println(peli);
        }); //Muestra lo ordenado
        System.out.println("");
    }
    
    //Ordenar las peliculas por director, alfabeticamente y mostrarlo en pantalla
    //Utilizando los comparadores de la clase utilidad
    public void ordenarPeliPorDirector(){
        System.out.println("** Mostrar las peliculas ordanadas por el Director alfabeticamente");
        Collections.sort(misPelis, Comparadores.porDirector); //Ordena con el Comparator porDirector
        
        misPelis.forEach(peli -> {
            System.out.println(peli);
        }); //Muestra lo ordenado
        System.out.println("");
    }
}
