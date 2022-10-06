/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Pais;
import java.util.*;

/**
 *
 * @author yamila
 */
public class PaisService {
    
    private static Scanner leer;
    //Acá creo mi Colección de Obj País
    private static Set<Pais> alMundo;
    
    public PaisService(){
        PaisService.leer = new Scanner(System.in);
        //Para que se ordene solo implemento el conjunto como TreeSet
        PaisService.alMundo = new TreeSet<>();
    }
    
    private Pais creaPais(){
        System.out.println("Ingrese el Nombre del País");
        String country = leer.next().toUpperCase();
        return new Pais(country);
    }
    
    public void creaMundo(){
        char op;
        
        do{
            alMundo.add(creaPais());
            System.out.println("Desea agregar otro País? S/N");
            op = leer.next().toUpperCase().charAt(0);
        }while(op != 'N');
        
        muestraMundo();
    }
    
    private void muestraMundo(){
        alMundo.forEach(System.out::println);
    }
    
    public void searchAndDestroy(){
        boolean bandera = true;
        Iterator<Pais> it = alMundo.iterator(); //Iterador de Pais(es) del conjunto alMundo
        System.out.println("Ingrese el país a buscar y destruir");
        String buscado = leer.next().toUpperCase();
        
        //Con it.next() obtengo el Obj de la clase Pais de las iteraciones
        //entonces con el condicional puedo preguntar si el nombre del obj
        //que me da el Iterador es igual al nombre buscado del país
        //si el condicional es verdadero con it.remove(): elimino el obj
        while (it.hasNext()) {            
            if(it.next().getNombre().equals(buscado)){
                it.remove();
                bandera = true;
                break;
            }else{
                bandera = false;
            }
        }
        
        if(bandera){
            System.out.println("Encontro el País " + buscado + " y lo elimino del Mundo");
            System.out.println("EXCELENTE!");
        }else{
            System.out.println("No existe en este mundo el país " + buscado);
        }
        
        muestraMundo();
    }
    
}
