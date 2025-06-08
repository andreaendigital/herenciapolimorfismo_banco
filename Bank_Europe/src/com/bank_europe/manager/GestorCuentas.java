/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank_europe.manager;

import com.bank_europe.manager.clientes.Cliente;
import com.bank_europe.manager.core.CuentaBancaria;
import com.bank_europe.manager.cuentas.CuentaAhorros;
import com.bank_europe.manager.cuentas.CuentaCorriente;
import com.bank_europe.manager.cuentas.CuentaDigital;
import java.util.HashMap;
import java.util.*;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Andrea
 */
public class GestorCuentas {
   
    private Map<String, CuentaBancaria> cuentasPorRut = new HashMap<>();
    private Map<String, Cliente> clientesPorRut = new HashMap<>();
    
    private Scanner scanner = new Scanner(System.in);
    
    public void registrarClienteCuenta(){
        System.out.println("Ingrese nombre de cliente: ");
        String nombre = scanner.nextLine().toLowerCase();
        
        String rut;
        while(true){
            System.out.println("Ingrese Rut del Cliente (formato XX.XXX.XXX-X): ");
            rut = scanner.nextLine();
            if(validarRut(rut)){
                break;
            }else{
                System.out.println("Formato de RUT  invalido. Intente nuevamente.");
            }
        }
        
        if (clientesPorRut.containsKey(rut)){
            System.out.println("Ya existe un cliente con ese rut.");
            return;
        }
        
        System.out.println("Seleccione el numero del tipo de cuenta que desea crear:");
        System.out.println("1. Cuenta Ahorro (minimo $ 5.000)");
        System.out.println("2. Cuenta Corriente");
        System.out.println("3. Cuenta Digital");
        
        int opcion = Integer.parseInt(scanner.nextLine());

        CuentaBancaria cuenta = null;
        Cliente cliente = new Cliente(nombre, rut);
        
        String numeroCuenta = generarNumeroCuenta();
        
        switch(opcion){
            case 1:
                System.out.println("Ingrese monto inicial (minimo $ 5.000): ");
                double abono = Double.parseDouble(scanner.nextLine());
                if(abono<5000){
                    System.out.println("Mono insuficiente para abrir cuenta de ahorro.");
                    return;
                }
                cuenta = new CuentaAhorro (cliente,abono);
                cuenta.setNumeroCuenta(numeroCuenta);
                break;
            case 2:
                cuenta = new CuentaCorriente (cliente);
                cuenta.setNumeroCuenta(numeroCuenta);
                break;
            case 3:
                cuenta = new Cuentadigital (cliente);
                cuenta.setNumeroCuenta(numeroCuenta);
                break;
            default :
                System.out.println("Opcion invalida.");
                  
        }
        
    }
}
