package Contas;

import Contas.Caixa.Banco.Banco;


public abstract class Conta {

    protected String tipo;
    private int numeroConta;
    private String nomeTitular;
    private double saldo = 0;

    public Conta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Conta(int numeroConta, String nomeTitular) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static void transferirDinheiro(Double quantidade, int numeroConta) {

        Conta contaDestino = null;
        
        boolean confirm = false;

        for(Conta c : Banco.listaContas) {
            if(c.getNumeroConta() == numeroConta) {
                c.setSaldo(c.getSaldo() + quantidade);
                contaDestino = c;

                Banco.contaCliente.setSaldo(Banco.contaCliente.getSaldo()-quantidade);

                confirm = true;
                break;
            }
        }
        if(!confirm) {
            System.out.println("Conta de destino inexistente.");
        } else {
            System.out.println("R$" + quantidade + " transferidos! Seu saldo atual é de R$" + Banco.contaCliente.getSaldo());
            System.out.println("O saldo da conta que recebeu o dinheiro é de R$" + contaDestino.getSaldo());
        }
    }


    public static void depositarConta(Double quantidade) {

        Banco.contaCliente.setSaldo((Banco.contaCliente.getSaldo())+quantidade);
        System.out.println("R$" + quantidade + " depositados! Seu saldo atual é de R$" + Banco.contaCliente.getSaldo());
    }

    public static void sacarConta(Double quantidade) {
        Banco.contaCliente.setSaldo((Banco.contaCliente.getSaldo())-quantidade);
        System.out.println("R$" + quantidade + " sacados! Seu saldo atual é de R$" + Banco.contaCliente.getSaldo());
    }


}
