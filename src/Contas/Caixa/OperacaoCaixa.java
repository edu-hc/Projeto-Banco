package Contas.Caixa;

import Contas.Caixa.Banco.Banco;
import Contas.Conta;
import Contas.Tipos.ContaCorrente;
import Contas.Tipos.ContaPoupanca;

import java.util.Scanner;

import static Contas.Caixa.Banco.Banco.listaContaCorrente;

public class OperacaoCaixa {

    public static void main (String[] args) {

        String nome;
        double quantidadeTransf;
        int contaTransf;
        int numeroConta;
        String tipoConta;

        Scanner sc = new Scanner(System.in);




        Banco.criarContaCorrente(5);
        Banco.criarContaPoupanca(5);
        Banco.criarContaTeste();

        Banco.listaContas.addAll(listaContaCorrente);
        Banco.listaContas.addAll(Banco.listaContaPoupanca);

        System.out.println("Qual o nome do titular da conta? ");
        nome = sc.next();

        System.out.println("Qual o numero da conta? ");
        numeroConta = sc.nextInt();

        System.out.println("Qual o tipo da conta? ");
        tipoConta = sc.next();

        if (tipoConta.equalsIgnoreCase("corrente")) {
            Banco.contaCliente = new ContaCorrente(numeroConta, nome);

        } else if (tipoConta.equalsIgnoreCase("poupanca")) {
            Banco.contaCliente = new ContaPoupanca(numeroConta, nome);

        }

        while(true) {

            if (!(Banco.listaContas.contains(Banco.contaCliente))) {
                System.out.println("Conta inexistente");

                System.out.println("Deseja criar uma conta com esses dados?");
                String resposta = sc.next();

                if(resposta.equalsIgnoreCase("sim")) {
                    Banco.listaContas.add(Banco.contaCliente);
                    if(Banco.contaCliente instanceof ContaCorrente) {
                        listaContaCorrente.add(Banco.contaCliente);
                    } else if (Banco.contaCliente instanceof ContaPoupanca) {
                        Banco.listaContaPoupanca.add(Banco.contaCliente);
                    }
                    System.out.println("Conta criada com sucesso!");
                } else if (resposta.equalsIgnoreCase("nao")) {
                    System.out.println("Finalizando sistema...");
                    break;
                }

                if(Banco.listaContas.contains(Banco.contaCliente)) {

                    boolean finalizar = false;
                    while(!finalizar) {
                        System.out.println("O que deseja fazer? \n" +
                                "1- Depositar na conta \n" +
                                "2- Sacar da conta \n" +
                                "3- Transferir dinheiro para outra conta\n" +
                                "\n Para sair, digite um número diferente.");

                        switch(sc.nextInt()) {
                            case 1:
                                System.out.println("O seu saldo atual é de: R$" + Banco.consultarSaldo(Banco.contaCliente.getNumeroConta()) + ". Quanto deseja depositar?");
                                quantidadeTransf = sc.nextDouble();

                                Conta.depositarConta(quantidadeTransf);
                                break;


                            case 2:
                                System.out.println("O seu saldo atual é de: R$" + Banco.consultarSaldo(Banco.contaCliente.getNumeroConta()) + ". Quanto deseja sacar?");
                                quantidadeTransf = sc.nextDouble();

                                Conta.sacarConta(quantidadeTransf);
                                break;

                            case 3:
                                System.out.println("O seu saldo atual é de: R$" + Banco.consultarSaldo(Banco.contaCliente.getNumeroConta()) + ". Quanto deseja transferir?");
                                quantidadeTransf = sc.nextDouble();

                                System.out.println("Qual é o número da conta de destino para a transferência? ");
                                contaTransf = sc.nextInt();

                                Conta.transferirDinheiro(quantidadeTransf, contaTransf);
                                break;



                            default:
                                finalizar = true;
                                System.out.println("Finalizando sistema...");
                                break;

                        }
                        }

                    }
                }



            }

        sc.close();
        }



    }

