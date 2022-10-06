/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Objects;

/**
 *
 * @author yamila
 */
public class Producto {
    
    private Integer codigo;
    private String nombre;
    private Double precio;

    public Producto() {
    }

    public Producto(Integer codigo, String nombre, Double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.codigo);
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.precio);
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        final Producto other = (Producto) obj;
        if(!Objects.equals(this.nombre, other.nombre)){
            return false;
        }
        if(!Objects.equals(this.codigo, other.codigo)){
            return false;
        }
        if(!Objects.equals(this.precio, other.precio)){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + " - $" + precio;
    }
    
    
    
}
