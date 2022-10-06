/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Producto;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author yamila
 */
public class ProductoService {
    
    private Scanner leer; //Creo el Scanner para utilizarlo en toda mi clase
    HashMap<Integer, Producto> mapaProductos; //Y el mapa
    
    public ProductoService(){
        this.mapaProductos = new HashMap<>(); //Creo el espacio en memoria del MAPA lo instancio
        this.leer = new Scanner(System.in); //Cuando se invoca la clase, habilita el flujo de los datos
    }
    
    //Método para agregar Producto's al mapa, mediante Math.random obtengo un 
    //codigo de tipo integer que se utiliza junto con el constructor con 
    //parametros de producto para mediante .put poner elementos al HashMap
    public void cargarProducto(){
        char op;
        
        do{
            Integer cod = (int)(Math.random() * 355 - 20 + 20); //El codigo para No pedirlo lo obtengo con el random
            System.out.println("Ingrese el nombre del producto");
            String nombre = leer.next().toUpperCase();
            System.out.println("Ingrese el precio del producto"); 
            Double precio = leer.nextDouble();
            //De este modo agrego elementos a un mapa. El primer termino se corresponde a la KEY
            //que es mi codigo random
            mapaProductos.put(cod, new Producto(cod, nombre, precio));
            System.out.println("Desea agregar otro producto? S/N");
            op = leer.next().toUpperCase().charAt(0);
        }while(op == 'S');
    }
    
    //Método para mostrar el contido del HashMap, mediante for each con 
    //entry.getKey trae la llave y entry.getValue trae los valores del mapa, es
    //decir el toString de los Obj que componen el mapa
    public void mostrar(){
//         for(Map.Entry<Integer,Producto> entry : mapaProductos.entrySet()){
//            System.out.println("Codigo: " + entry.getKey() + " - " + entry.getValue());
//        }
        mapaProductos.entrySet().forEach((entry) -> {
            System.out.println("Codigo: " + entry.getKey() + " - " + entry.getValue());
        });
    }
    
    //Método que a traves de la llave del mapa "Key", para este caso el codigo
    //del producto lo remueve del Mapa, utilizando los métodos containsKey y
    //remove en un condicional if
    public void buscarEliminar(){
        System.out.println("Ingrese el Codigo del Producto");
        Integer buscado = leer.nextInt();
        
        if(mapaProductos.containsKey(buscado)){
            mapaProductos.remove(buscado);
        }else{
            System.out.println("No se encontro el producto");
        }
    }
    
    //Método para Modificar los valores de un elemento del mapa, mediante la
    //busqueda de su Key se crea un obj auxiliar para setear los nuevos
    //valores Y luego colocarlo nuevamente en el mapa con la misma key
    public void modifica(){
        System.out.println("Ingrese el codigo del producto");
        Integer buscado = leer.nextInt();
        
        if(mapaProductos.containsKey(buscado)){
            Producto aux = mapaProductos.get(buscado);
            System.out.println("Ingrese el nuevo precio");
            aux.setPrecio(leer.nextDouble());
            mapaProductos.put(buscado, aux);
        }else{
            System.out.println("No se encuentro el producto");
        }
    }
}
