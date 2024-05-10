package br.com.rafacfrank.realtimecurrencyconverter.models;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyRequest {

    private String yourKey = "bafede3b9265d3e78c923bb8";

    public Conversion conversion (String baseCurrency, String targetCurrency, double amount) {
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + yourKey + "/pair/" + baseCurrency + "/" + targetCurrency + "/" + amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Conversion.class);
        } catch (Exception e){
            throw new RuntimeException("Não foi possível encontrar os dados informados");
        }
    }
}
