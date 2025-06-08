/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank_europe.manager.core;

/**
 *
 * @author Andrea
 */
public abstract class CuentaBancaria {

    private String numeroCuenta;
    private double saldo;

    //constructor con un parametro
    public CuentaBancaria(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0.0;
    }
    
    //constructor con dos parametros
    public CuentaBancaria(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public abstract double calcularInteres();

    public void depositar(double monto) {
        if (monto > 0) saldo += monto;
    }

    public void girar(double monto) {
        if (monto > 0 && monto <= saldo) saldo -= monto;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }
    


}

