/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.util.Scanner;

/**
 *
 * @author yamila
 */
public class Menu {
    
    private Scanner leer; //Creo el Scanner para utilizar en toda mi clase
    static int op = 0; //Creo la variable para elegir las opciones del menu
    ProductoService ps; //Creo mi objeto de Servicios para llamar a los metodos
    
    public Menu(){ //Instancio el scanner y el objeto de la clase servicio
        this.leer = new Scanner(System.in);
        this.ps = new ProductoService();
    }
    
    public void menu(){
        do{
            System.out.println("**************************************");
            System.out.println("*************** MENU *****************");
            System.out.println("*** 1. Introducir un Producto      ***");
            System.out.println("*** 2. Modificar Precio            ***");
            System.out.println("*** 3. Borrar un Producto          ***");
            System.out.println("*** 4. Mostrar todos los Productos ***");
            System.out.println("*** 5. Salir                       ***");
            System.out.println("**************************************");
            op = leer.nextInt();
            
            switch(op){
                case 1:
                    ps.cargarProducto();
                    break;
                case 2:
                    ps.modifica();
                    break;
                case 3:
                    ps.buscarEliminar();
                    break;
                case 4:
                    ps.mostrar();
                    break;
                case 5:
                    System.out.println("ADIOS!");
                    break;
            }
        }while(op != 5);
    }
}
