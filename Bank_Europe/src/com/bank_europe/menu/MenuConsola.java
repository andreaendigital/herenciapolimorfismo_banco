/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank_europe.menu;

import com.bank_europe.manager.GestorCuentas;
import java.util.Scanner;

/**
 *
 * @author Andrea
 */
public class MenuConsola {
    private final GestorCuentas gestor;
    private final Scanner scanner;
    
    public MenuConsola(){
        gestor = new GestorCuentas();
        scanner = new Scanner (System.in);
    }
    
    public void mostrarMenu(){
        int opcion;
        
        do{
            System.out.println("======== MENU PRINCIPAL ========");
            System.out.println("1. Registrar cliente y cuenta");
            System.out.println("2. Ver informacion de cliente");
            System.out.println("3. Listar clientes");
            System.out.println("4. Depositar dinero");
            System.out.println("5. Girar dinero");
            System.out.println("6. Consultar saldo");
            System.out.println("7. Salir");
            System.out.println("Seleccione una opcion:");
            
            try{
                opcion = Integer.parseInt(scanner.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Entrada invalida. Intente nuevamente");
                opcion = -1;
                continue;
            }
            
            switch (opcion){
                case 1:
                    gestor.registrarClienteCuenta();
                    break;
                case 2:
                    gestor.verInformacionCliente();
                    break;
                case 3:
                    gestor.listarClientes();
                    break;
                case 4:
                    gestor.depositarDinero();
                    break;
                case 5:
                    gestor.girarDinero();
                    break;
                case 6:
                    gestor.consultarSaldo();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente");
            }
            
            
        } while(opcion != 7);
    }
    
    
    
}
