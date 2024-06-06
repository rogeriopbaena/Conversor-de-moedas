package com.conversormoedas;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class conversordemoedas {

    private static final String CHAVE_API = "6eb17a9072c1ed14b953ce2a"; // Chave da API para autenticação
    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6/" + CHAVE_API + "/latest/";

    // Método para converter a quantidade entre duas moedas
    public double converter(String moedaOrigem, String moedaDestino, double quantidade) throws IOException, InterruptedException {
        String urlStr = URL_BASE + moedaOrigem; // Monta a URL da API com a moeda de origem
        HttpClient cliente = HttpClient.newHttpClient(); // Cria um cliente HTTP
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(urlStr)) // Cria a requisição HTTP para a URL
                .build();

        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString()); // Envia a requisição e recebe a resposta
        JsonObject jsonObject = JsonParser.parseString(resposta.body()).getAsJsonObject(); // Converte a resposta JSON em um objeto Java
        double taxaCambio = jsonObject.getAsJsonObject("conversion_rates").get(moedaDestino).getAsDouble(); // Obtém a taxa de câmbio da moeda de destino
        return quantidade * taxaCambio; // Calcula o valor convertido
    }
}
