/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank_europe.manager.core;
import com.bank_europe.manager.clientes.Cliente;

/**
 *
 * @author Andrea
 */
public abstract class CuentaBancaria {

    private String numeroCuenta;
    private double saldo;
    private Cliente cliente;

    //constructor con dos parametro
    public CuentaBancaria(Cliente cliente, String numeroCuenta){
        this.cliente = cliente;
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }
    
    //Constructor con tres parametros
    public CuentaBancaria(Cliente cliente, double saldo, String numeroCuenta) {
        this.cliente = cliente;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
    
  
    public abstract double calcularInteres();

    public abstract String getTipoCuenta();
    
    public void depositar(double monto) {
        if (monto > 0) saldo += monto;
    }

    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }
    


}

