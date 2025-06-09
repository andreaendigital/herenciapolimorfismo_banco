/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bank_europe.manager.cuentas.tipo;

import com.bank_europe.manager.clientes.Cliente;
import com.bank_europe.manager.cuentas.CuentaBancaria;

/**
 *
 * @author Andrea
 */
public class CuentaDigital extends CuentaBancaria {
    public CuentaDigital (Cliente cliente, String numeroCuenta){
        super(cliente, numeroCuenta);
    }
    
    @Override
    public double calcularInteres(){
        return 0.015 * getSaldo(); // 1.5% de interes
    }
    
    @Override
    public String getTipoCuenta() {
        return "Cuenta Digital";
    }
}
