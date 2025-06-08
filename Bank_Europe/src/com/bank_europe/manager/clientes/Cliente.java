/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank_europe.manager.clientes;

import com.bank_europe.manager.interfaces.InfoCliente;

/**
 *
 * @author Andrea
 */
public class Cliente implements InfoCliente{
    private String nombre;
    private String rut;
    
    public Cliente (String nombre, String rut){
        this.nombre = nombre;
        this.rut = rut;
        
    }
    
    @Override
    public String mostrarInformacionCliente(){
        return "Cliente: " + nombre + " - RUT: " + rut;
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }
    
    
    
}
