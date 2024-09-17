package Contas.Caixa.Banco;

import Contas.Conta;
import Contas.Tipos.ContaCorrente;
import Contas.Tipos.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Banco {

    private static int SEQUENCIAL = 1;
    public static List<Conta> listaContaCorrente  = new ArrayList<>();
    public static List<Conta> listaContaPoupanca = new ArrayList<>();
    public static List<Conta> listaContas = new ArrayList<>();
    public static Conta contaCliente = null;
    public static Conta contaTeste;

    static Random rand = new Random();


    public static void criarContaCorrente(int quant) {

        for(int i=0; i<quant; i++)
        listaContaCorrente.add(new ContaCorrente(SEQUENCIAL++));
    }

    public static void criarContaPoupanca(int quant) {

        for(int i=0; i<quant; i++)
        listaContaPoupanca.add(new ContaPoupanca(SEQUENCIAL++));
    }

    public static void criarContaTeste() {

        contaTeste = new ContaPoupanca(1291);
        listaContaPoupanca.add(contaTeste);
    }

    public static double consultarSaldo(int numeroConta) {

        double saldo = 0;

        for(Conta c : listaContas) {
            if (c.getNumeroConta() == numeroConta) {

                saldo = c.getSaldo();
            }

        }

        return saldo;
    }

}
