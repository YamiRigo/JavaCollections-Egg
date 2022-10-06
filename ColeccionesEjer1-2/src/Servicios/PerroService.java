/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Perro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


/**
 *
 * @author yamila
 */
public class PerroService {
    
    private Scanner leer;
    //Acá creo mi Colección de Objetos Perros
    private ArrayList<Perro> perrosList;

    public PerroService() {
        this.leer = new Scanner(System.in);
        //Acá la instancio
        this.perrosList = new ArrayList();
    }
    
    //Creo y añado a mi arraylist un objeto Perro
    //@return un objeto de la clase perro
    private Perro creaPerro(){
        System.out.println("Ingrese la Raza del Perro");
        String laRaza = leer.next().toUpperCase();
        Perro p = new Perro(laRaza);
        perrosList.add(p);
        return p;
    }
    
    //En vez de for se puede usar una función operacional
    //perrosList.forEach((aux) -> {
    //System.out.println(aux.toString());
    //});
    
    private void mostrarPerros(){
        System.out.println("Las razas cargadas son: ");
        
        for (Perro aux : perrosList) {
            System.out.println(aux.toString());
        }
        System.out.println("Cantidad de razas de perro: " + perrosList.size());
    }
    
    public void criaderoDeChiquitos(){
        char op;
        
        do{
            creaPerro();
            System.out.println("Desea agregar otro Perro" + " 'S' para continuar o 'N' para Salir");
            op = leer.next().toUpperCase().charAt(0);
        }while(op != 'N');
        
        mostrarPerros();
    }
    
    public void perrera(){
        //Le pido al usuario la raza a buscar
        System.out.println("Ingrese la Raza a buscar: ");
        String buscaRaza = leer.next().toUpperCase();
        //Creo una bandera logica para saber si encontre o no la raza
        boolean bandera = true;
        //Iterator fr tipo Perro llamado it con lo que tiene el arraylist perrosList
        Iterator<Perro> it = perrosList.iterator();
        
        //Mientras haya otro objeto en la lista hacer
        while (it.hasNext()) {            
            Perro aux = it.next();
            if(aux.getRaza().equals(buscaRaza)){
                it.remove();
                bandera = true;
                break;
            }else{
                bandera = false;
            }
        }
        
        if(bandera){
            System.out.println("Encontro la raza " + buscaRaza);
        }else{
            System.out.println("No está la raza buscada");
        }
        
        //Podría llamar al método mostrarPerros pero quiero ver como es
        //con forEach de una línea
        perrosList.forEach((e) -> System.out.println(e));
    }
}
