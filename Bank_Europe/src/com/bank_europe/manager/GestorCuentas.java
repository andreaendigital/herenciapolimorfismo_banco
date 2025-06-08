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
                return;  
        }
        
        clientesPorRut.put(rut, cliente);
        cuentasPorRut.put(rut, cuenta);
        System.out.println("Cliente y cuenta registrados exitosamente");
        System.out.println("Número de cuenta asignado: " + numeroCuenta);
        
    }
    
    private boolean validarRut(String rut) {
        return Pattern.matches("^\\d{1,2}\\.\\d{3}\\.\\d{3}-[\\dKk]$", rut);
    }

    
    private String generarNumeroCuenta(){
        Random random = new Random();
        int numero = 100000000 + random.nextInt(900000000); //numero de 9 digitos
        return String.valueOf(numero);
    }
    
    public void verInformacionCliente(){
        System.out.println("Ingrese Rut del cliente: ");
        String rut = scanner.nextLine();
        
        Cliente cliente = clientesPorRut.get(rut);
        CuentaBancaria cuenta = cuentasPorRut.get(rut);
        
        if(cliente == null || cuenta == null){
            System.out.println("Cliente no encontrado");
            return;
        }
        
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("RUT: " + cliente.getRut());
        System.out.println("Tipo de cuenta: " + cuenta.getTipoCuenta());
        
    }
    
    public void listarClientes(){
        if(clientesPorRut.isEmpty()){
            System.out.println("No hay clientes registrados");
            return;
        }
        for(String rut : clientesPorRut.keySet()){
            Cliente c = clientesPorRut.get(rut);
            CuentaBancaria cuenta = cuentasPorRut.get(rut);
            System.out.println("Nombre: " + c.getNombre() + ", RUT: " + c.getRut() + ", Tipo de Cuenta: " + cuenta.getTipoCuenta() );
        }
        
    }
    
    public void depositarDinero() {
        System.out.println("Ingrese RUT del Cliente:");
        String rut = scanner.nextLine();
        
        CuentaBancaria cuenta = cuentasPorRut.get(rut);
        if(cuenta == null){
            System.out.println("Cliente no encontrado");
            return;
        }
        
        System.out.println("Tipo de cuenta: " + cuenta.getTipoCuenta());
        System.out.println("Desea continuar con el deposito? (s/n): ");
        String confirmacion = scanner.nextLine();
        if(!confirmacion.equalsIgnoreCase("s")){
            System.out.println("Deposito Cancelado");
            return;
        }
        
        System.out.println("Ingrese monto a depositar: ");
        double monto = Double.parseDouble(scanner.nextLine());
        cuenta.depositar(monto);
        System.out.println("Deposito realizado. Su nuevo saldo es: $ " + cuenta.getSaldo());
        
    }
    
    public void girarDinero(){
        System.out.println("Ingrese RUT del Cliente:");
        String rut = scanner.nextLine();
        
        CuentaBancaria cuenta = cuentasPorRut.get(rut);
        if(cuenta == null){
            System.out.println("Cliente no encontrado");
            return;
        }
        
         System.out.println("Ingrese monto a retirar: ");
        double monto = Double.parseDouble(scanner.nextLine());
        
        boolean exito = cuenta.retirar(monto);
        
        if(exito){
            System.out.println("Retiro realizado. Su nuevo saldo es: $ " + cuenta.getSaldo() );
        }else{
            System.out.println("No se pudo realizar el retiro. Saldo actual: $ "+ cuenta.getSaldo() );
        }
        
        
    }
    
    public void consultarSaldo(){
        System.out.println("Ingrese RUT del Cliente:");
        String rut = scanner.nextLine();
        
        CuentaBancaria cuenta = cuentasPorRut.get(rut);
        if(cuenta == null){
            System.out.println("Cliente no encontrado");
            return;
        }
        
        System.out.println("Tipo de Cuenta: " + cuenta.getTipoCuenta() );
        System.out.println("Saldo actual: " + cuenta.getSaldo() );
        
    }
    
}
