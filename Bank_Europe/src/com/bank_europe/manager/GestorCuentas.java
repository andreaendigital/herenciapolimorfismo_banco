/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank_europe.manager;

import com.bank_europe.manager.clientes.Cliente;
import com.bank_europe.manager.cuentas.CuentaBancaria;
import com.bank_europe.manager.cuentas.tipo.CuentaAhorros;
import com.bank_europe.manager.cuentas.tipo.CuentaCorriente;
import com.bank_europe.manager.cuentas.tipo.CuentaDigital;
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
    private static int contadorNumeroCuenta = 100000000; // Numeor inicial de 9 digitos para los numeros de cuenta
    private Scanner scanner = new Scanner(System.in);
    
    public void registrarClienteCuenta(){
        String nombre;
        
        while (true){
            System.out.println("Ingrese nombre de cliente: ");
            nombre = scanner.nextLine().toLowerCase();
            
            if(validarRut(nombre)){
                System.out.println("Eso parece un RUT, no un nombre. Por favor, ingresa nuevamente tu nombre");
                
            }else if(nombre.isBlank()){
                System.out.println("El nombre no puede estar vacio. Intente nuevamente.");
            }else if(nombre.matches("\\d+")){
                System.out.println("El nombre no puede ser numeros. Intente nuevamente.");
            }else{
                break;
            }
        }
        
        
        
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
        
        int opcion = validarInt(scanner);

        CuentaBancaria cuenta = null;
        Cliente cliente = new Cliente(nombre, rut);
        
        String numeroCuenta = generarNumeroCuenta();
        
        switch(opcion){
            case 1:
                System.out.println("Ingrese monto inicial (minimo $ 5.000): ");
                double abono = (validarInt(scanner));
                if(abono<5000){
                    System.out.println("Mono insuficiente para abrir cuenta de ahorro.");
                    return;
                }
                cuenta = new CuentaAhorros(cliente, abono, numeroCuenta);
                break;
            case 2:
                cuenta = new CuentaCorriente (cliente, numeroCuenta);                
                break;
            case 3:
                cuenta = new CuentaDigital (cliente, numeroCuenta);
                break;
            default :
                System.out.println("Opcion invalida.");
                return;  
        }
        
        clientesPorRut.put(rut, cliente);
        cuentasPorRut.put(rut, cuenta);
        System.out.println("Cliente y cuenta registrados exitosamente");
        System.out.println("Numero de cuenta asignado: " + numeroCuenta);
        
    }
    
    private boolean validarRut(String rut) {
        return Pattern.matches("^\\d{1,2}\\.\\d{3}\\.\\d{3}-[\\dKk]$", rut);
    }

    
    private String generarNumeroCuenta(){
        return String.valueOf(contadorNumeroCuenta++);
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
    
        public static int validarInt(Scanner scanner){
        int opcion =-1;
        while(true){
            if(scanner.hasNextInt()){
                opcion = scanner.nextInt();
                break;
            }else{
                System.out.println("Opcion no valida. Ingrese un numero, por favor.");
                scanner.next(); //Evita bucle y limpia la entrada
            }
        }
        return opcion;
    }    //Cierre validarInt    
    
}
