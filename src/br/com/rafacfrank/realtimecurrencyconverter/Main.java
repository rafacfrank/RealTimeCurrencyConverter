package br.com.rafacfrank.realtimecurrencyconverter;

import br.com.rafacfrank.realtimecurrencyconverter.models.Conversion;
import br.com.rafacfrank.realtimecurrencyconverter.models.CurrencyRequest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        CurrencyRequest currencyRequest = new CurrencyRequest();
        Conversion conversion = currencyRequest.conversion("USD","EUR", 500);
        System.out.println(conversion);
    }
}
