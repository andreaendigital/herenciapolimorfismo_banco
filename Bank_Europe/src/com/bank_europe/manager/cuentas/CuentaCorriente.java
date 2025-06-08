package com.bank_europe.manager.cuentas;

import com.bank_europe.manager.clientes.Cliente;
import com.bank_europe.manager.core.CuentaBancaria;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Andrea
 */
public class CuentaCorriente extends CuentaBancaria {
    public CuentaCorriente (Cliente clientes,String numeroCuenta){
        super(clientes, numeroCuenta);
    }
    
    @Override
    public double calcularInteres(){
        return 0.01 * getSaldo(); // 1% de interes
    }
    
    @Override
    public String getTipoCuenta() {
        return "Cuenta Corriente";
    }
    
}
