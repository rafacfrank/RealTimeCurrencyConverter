package br.com.rafacfrank.realtimecurrencyconverter;

import br.com.rafacfrank.realtimecurrencyconverter.models.Conversion;
import br.com.rafacfrank.realtimecurrencyconverter.models.CurrencyRequest;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // montando o menu e lendo opções
        String menu = """
                ******************************************************
                    Conversor de Moedas em tempo real
                               \s
                  Pode converter valores de moedas, onde deve\s
                  entrar com a moeda de origem, a moeda alvo, e o
                  valor. Abaixo veja as siglas de algumas moedas
                \s
                USD - Dolar Americano     EUR - Euro
                BRL - Real Brasileiro     PEN - Sol Peruano
                GBP - Libra Esterlina     JPY - Iene Japonês
                PYG - Guarani Paraguaio   UYU - Peso Uruguaio
                CHF - Franco Suiço        CLP - Peso Chileno
                ARS - Peso Argentino      BOB - Boliviano Boliviano
                COP - Peso Colombiano     CUP - Peso Cubano    \s
                               \s
                É possível colocar o código de qualquer outra moeda conhecida
                *****************************************************
               \s""";

        try {


            System.out.println(menu);
            ArrayList<Conversion> historico = new ArrayList<>();
            int opcao = 0;
            while (opcao != 2) {
                System.out.println("Você quer fazer um cotação? Conferir seu histórico? escolha o opção: ");
                System.out.println("1 - SIM");
                System.out.println("2 - NÃO");
                System.out.println("3 - HISTÓRICO");

                opcao = scanner.nextInt();
                if (opcao == 1) {


                    System.out.println("digite o código da moeda atual: ");
                    String baseCurrency = scanner.next().toUpperCase();
                    System.out.println("digite o código da moeda alvo: ");
                    String targetCurrency = scanner.next().toUpperCase();
                    System.out.println("digite o valor desejado: ");
                    double amount = scanner.nextDouble();

                    CurrencyRequest currencyRequest = new CurrencyRequest();
                    Conversion conversion = currencyRequest.conversion(baseCurrency, targetCurrency, amount);
                    historico.add(conversion);

                    if (conversion.base_code() != null || conversion.target_code() != null) {
                        System.out.println("\nA conversão de " + conversion.base_code() + " " + String.format("%.2f", amount));
                        System.out.println("Resulta em " + conversion.target_code() + " " + String.format("%.2f", conversion.conversion_result()));
                        System.out.println("A taxa de conversão verificada foi de " + conversion.conversion_rate() + "\n");


                    } else {
                        System.out.println("Digitou algum codigo de moeda errado, favor corrigir");
                    }
                }
                //imprimir historico
                if (opcao == 3) {
                    for (Conversion elemento : historico) {
                        System.out.println("\nMoeda base: " + elemento.base_code() + " " + String.format("%.2f", elemento.conversion_result() / elemento.conversion_rate()));
                        System.out.println("Moeda alvo: " + elemento.target_code() + " " + String.format("%.2f", elemento.conversion_result()));
                        System.out.println("A uma taxa de: " + elemento.conversion_rate() + "\n");
                    }
                }
            }
            System.out.println("Obrigado por utilizar nossos serviços");

        } catch (InputMismatchException e) {
            System.out.println("Erro de digitação, comece denovo");
        }


    }

}
