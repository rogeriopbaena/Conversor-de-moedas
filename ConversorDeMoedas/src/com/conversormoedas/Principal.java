package com.conversormoedas;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        conversordemoedas conversor = new conversordemoedas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha a conversão de moedas:");
            System.out.println("1 - [USD] para [BRL]");
            System.out.println("2 - [BRL] para [USD]");
            System.out.println("3 - [EUR] para [BRL]");
            System.out.println("4 - [BRL] para [EUR]");
            System.out.println("5 - [USD] para [EUR]");
            System.out.println("6 - [BRL] para [GBP]");
            System.out.println("0 - Sair");
            int escolha = scanner.nextInt();

            if (escolha == 0) {
                System.out.println("Saindo...");
                break;
            }

            System.out.println("Digite a quantidade a ser convertida:");
            double quantidade = scanner.nextDouble();

            try {
                double resultado = 0;
                switch (escolha) {
                    case 1:
                        resultado = conversor.converter("USD", "BRL", quantidade);
                        System.out.printf("%.2f USD é igual a %.2f BRL%n", quantidade, resultado);
                        break;
                    case 2:
                        resultado = conversor.converter("BRL", "USD", quantidade);
                        System.out.printf("%.2f BRL é igual a %.2f USD%n", quantidade, resultado);
                        break;
                    case 3:
                        resultado = conversor.converter("EUR", "BRL", quantidade);
                        System.out.printf("%.2f EUR é igual a %.2f BRL%n", quantidade, resultado);
                        break;
                    case 4:
                        resultado = conversor.converter("BRL", "EUR", quantidade);
                        System.out.printf("%.2f BRL é igual a %.2f EUR%n", quantidade, resultado);
                        break;
                    case 5:
                        resultado = conversor.converter("USD", "EUR", quantidade);
                        System.out.printf("%.2f USD é igual a %.2f EUR%n", quantidade, resultado);
                        break;
                    case 6:
                        resultado = conversor.converter("BRL", "GBP", quantidade);
                        System.out.printf("%.2f BRL é igual a %.2f GBP%n", quantidade, resultado);
                        break;
                    default:
                        System.out.println("Escolha inválida.");
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
