package net.epiclanka.futurexwebapi.service;

import org.apache.http.HttpRequest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

public interface ApiClientService {
    HttpRequest setRequestMethod(RequestMethod requestMethod, String url);
    CloseableHttpResponse sendRequest(RequestMethod requestMethod, String url, String payload) throws IOException;

}
