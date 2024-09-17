package Contas.Tipos;

import Contas.Conta;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numeroConta) {
        super(numeroConta);
        this.tipo = "poupanca";
    }

    public ContaPoupanca(int numeroConta, String nomeTitular) {
        super(numeroConta);
        this.tipo = "poupanca";
    }

    public String getTipo() {
        return tipo;
    }
}


