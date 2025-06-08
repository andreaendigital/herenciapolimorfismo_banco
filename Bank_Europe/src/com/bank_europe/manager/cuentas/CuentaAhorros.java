/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank_europe.manager.cuentas;

import com.bank_europe.manager.core.CuentaBancaria;

/**
 *
 * @author Andrea
 */
public class CuentaAhorros extends CuentaBancaria {
    public CuentaAhorros (String numeroCuenta, double saldo){
        super(numeroCuenta, saldo);
    }
    
    @Override
    public double calcularInteres(){
        return 0.03 * getSaldo(); // 3% de interes
    }
}
