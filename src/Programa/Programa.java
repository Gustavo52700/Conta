package Programa;

import java.util.Scanner;

import Classes.Cliente;
import Classes.Conta;
import Classes.TipoOperacao;

public class Programa {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Conta conta = new Conta();
        Cliente cliente = new Cliente("Breno", conta);
        int opcao = -1;

        while (opcao != 0) {
            exibeMenu();
            opcao = ler.nextInt();

            switch(opcao){
                case 1:
                  Sacar(ler, cliente); 
                  break;
                case 2:
                  Depositar(ler, conta);
                  break;
                case 3:
                  exibirSaldo(conta);
                  break;
                case 0:
                  System.out.println("Encerrando a aplicação");
                  return;  
                default:
                  System.out.println("Operação inválida. Verifique");                     
            }
        }
        ler.close();       
    }

    private static void exibirSaldo(Conta conta) {
        conta.realizaOperacao(TipoOperacao.SALDO, 0);
    }

    private static void Depositar(Scanner ler, Conta conta) {
        double valor;
        System.out.println("Digite o valor a depositar: ");
          valor = ler.nextDouble();
          conta.realizaOperacao(TipoOperacao.DEPOSITO, valor);
    }

    private static void Sacar(Scanner ler, Cliente cliente) {
        double valor;
        System.out.println("Digite o valor a sacar: "); 
          valor = ler.nextDouble();
          cliente.realizaOperacao(TipoOperacao.SAQUE, valor);
    }

    private static void exibeMenu() {
        System.out.println("\n*******************");
        System.out.println("1 - Saque");
        System.out.println("2 - Depósito");
        System.out.println("3 - Saldo");
        System.out.println("0 - Sair");
        System.out.println("\nDigite a opção desejada");
    }   
}