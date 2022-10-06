/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Entidades.Pelicula;
import java.util.Comparator;

/**
 *
 * @author yamila
 */
public class Comparadores {
    
    //Comparator con su declaración estandar
    //Compara las peliculas por titulo, alfabéticamente
    public static Comparator<Pelicula> porTitulo = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula o1, Pelicula o2) {
            return o2.getTitulo().compareTo(o1.getTitulo());
        }
    };
    
    //Comparadores declarados con expresión Lambda
    //Compara las peliculas de acuerdo a su duración de mayor a menor
    public static Comparator<Pelicula> porDuracionMayor = (Pelicula o1, Pelicula o2) -> o2.getDuracion().compareTo(o1.getDuracion());
    //Compara las peliculas de acuerdo a su duración de menor a mayor
    public static Comparator<Pelicula> porDuracionMenor = (Pelicula o1, Pelicula o2) -> o1.getDuracion().compareTo(o2.getDuracion());
    //Compara Peliculas por el Director, alfabeticamente
    public static Comparator<Pelicula> porDirector = (Pelicula o1, Pelicula o2) -> o1.getDirector().compareTo(o2.getDirector());
    
}
