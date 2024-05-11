package br.com.rafacfrank.realtimecurrencyconverter;

import br.com.rafacfrank.realtimecurrencyconverter.models.Conversion;
import br.com.rafacfrank.realtimecurrencyconverter.models.CurrencyRequest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // montando o menu e lendo opções
        String menu = """
                ******************************************************
                    Conversor de Moedas em tempo real
                
                  Voê pode converter valores de moedas, onde deve 
                  entrar com a moeda de origem, a moeda alvo, e o
                  valor. Abaixo veja as siglas de algumas moedas
                 
                USD - Dolar Americano     EUR - Euro
                BRL - Real Brasileiro     PEN - Sol Peruano
                GBP - Libra Esterlina     JPY - Iene Japonês
                PYG - Guarani Paraguaio   UYU - Peso Uruguaio
                CHF - Franco Suiço        CLP - Peso Chileno
                ARS - Peso Argentino      BOB - Boliviano Boliviano
                COP - Peso Colombiano     CUP - Peso Cubano     
                
                É possível colocar o código de qualquer outra moeda conhecida
                
                ******************************************************
                """;

        try {

        System.out.println(menu);
        System.out.println("digite o código da moeda atual: ");
        var baseCurrency = scanner.nextLine().toUpperCase();
        System.out.println("digite o código da moeda alvo: ");
        var targetCurrency = scanner.nextLine().toUpperCase();
        System.out.println("digite o valor desejado: ");
        var amount = scanner.nextDouble();

        CurrencyRequest currencyRequest = new CurrencyRequest();




            Conversion conversion = currencyRequest.conversion(baseCurrency, targetCurrency, amount);


            if (conversion.base_code() != null || conversion.target_code() != null) {
                System.out.println("A conversão de " + conversion.base_code() + " " + String.format("%.2f", amount));
                System.out.println("Resulta em " + conversion.target_code() + " " + String.format("%.2f", conversion.conversion_result()));
                System.out.println("A taxa de conversão verificada foi de " + conversion.conversion_rate());

                System.out.println("Obrigado por utilizar nossos serviços");

            } else {
                System.out.println("Digitou algum codigo de moeda errado, favor corrigir");
            }
        }catch (InputMismatchException e){
            System.out.println("Erro de digitação, comece denovo");
        }

    }

}
