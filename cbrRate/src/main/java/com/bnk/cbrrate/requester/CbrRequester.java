package com.bnk.cbrrate.requester;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CbrRequester {
    public String getRatesAsXml(String url) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return httpResponse.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
