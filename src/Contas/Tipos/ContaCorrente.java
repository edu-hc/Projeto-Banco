package Contas.Tipos;

import Contas.Conta;

public class ContaCorrente extends Conta {

    public ContaCorrente(int numeroConta) {
        super(numeroConta);
        this.tipo = "corrente";
    }

    public ContaCorrente(int numeroConta, String nomeTitular) {
        super(numeroConta);
        this.tipo = "corrente";
    }

    public String getTipo() {
        return tipo;
    }
}


