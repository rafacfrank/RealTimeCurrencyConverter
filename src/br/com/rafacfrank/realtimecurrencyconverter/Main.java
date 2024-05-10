package br.com.rafacfrank.realtimecurrencyconverter;

import br.com.rafacfrank.realtimecurrencyconverter.models.Conversion;
import br.com.rafacfrank.realtimecurrencyconverter.models.CurrencyRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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
                
                É possível colocar o código de qualquer outra moeda conhecida
                
                ******************************************************
                """;

        System.out.println(menu);
        System.out.println("digite o código da moeda atual: ");
        var baseCurrency = scanner.nextLine().toUpperCase();
        System.out.println("digite o código da moeda alvo: ");
        var targetCurrency = scanner.nextLine().toUpperCase();
        System.out.println("digite o valor desejado: ");
        var amount = scanner.nextDouble();

        CurrencyRequest currencyRequest = new CurrencyRequest();

        Conversion conversion = currencyRequest.conversion(baseCurrency,targetCurrency, amount);
        System.out.println(conversion);


    }
}
