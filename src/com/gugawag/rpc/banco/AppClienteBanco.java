package com.gugawag.rpc.banco;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AppClienteBanco {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        // procura o serviço no RMI Registry local. Perceba que o cliente não connhece a implementação do servidor,
        // apenas a interface
        Registry registry = LocateRegistry.getRegistry();
        BancoServiceIF banco = (BancoServiceIF) registry.lookup("BancoService");

        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();

        while(opcao != 9) {
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o número da conta:");
                    String numeroConta = entrada.next();
                    System.out.println("Digite o saldo:");
                    double saldo = entrada.nextDouble();
                    //chamada ao método remoto, como se fosse executar localmente
                    banco.adicionarConta(numeroConta, saldo);
                    System.out.println("Conta adicionada com sucesso!");
                    break;
                }
                case 2: {
                    System.out.println("Digite o número da conta:");
                    String numeroConta = entrada.next();
                    double valor = banco.saldo(numeroConta);
                    if (valor != -1)
                        System.out.println(valor);
                    else
                        System.out.println("Conta não encontrada!");
                    break;
                }
                case 3: {
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println("Quantidade de contas: " + banco.quantidadeContas());
                    break;
                }
            }
            menu();
            opcao = entrada.nextInt();
        }
    }

    public static void menu() {
        System.out.println("\n=== BANCO RMI (ou FMI?!) ===");
        System.out.println("1 - Cadastrar conta");
        System.out.println("2 - Verificar saldo");
        System.out.println("3 - Quantidade de contas");
        System.out.println("9 - Sair");
    }

}
