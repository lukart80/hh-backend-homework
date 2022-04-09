package ru.hh.school.hhApiClient;


import javax.ws.rs.ServerErrorException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class hhApiClient {

    private final String HH_API_URL = "https://api.hh.ru";


    private HttpRequest buildRequest(String uri) {
        return HttpRequest.newBuilder(
                URI.create(HH_API_URL + uri)
        ).header("accept", "application/json").GET().build();
    }

    public String executeRequest(String uri) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = buildRequest(uri);
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            }
            throw new ServerErrorException(500);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new ServerErrorException(500);
        }

    }







}
