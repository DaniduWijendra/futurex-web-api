package net.epiclanka.futurexwebapi.service.impl;

import net.epiclanka.futurexwebapi.service.ApiClientService;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@Service
@Qualifier("apiClientService")
public class ApiClient implements ApiClientService {
    private static final Logger LOGGER = Logger.getLogger(ApiClient.class);

    @Autowired
    private SSLContext sSLContext;

    /**
     * set request method to HttpRequest
     *
     * @param requestMethod
     * @param url
     * @return
     */
    public HttpRequest setRequestMethod(RequestMethod requestMethod, String url) {
        HttpRequest request = null;
        switch (requestMethod) {
            case GET:
                request = new HttpGet(url);
                break;
            case POST:
                request = new HttpPost(url);
                break;
            case PUT:
                request = new HttpPut(url);
                break;
            case DELETE:
                request = new HttpDelete(url);
                break;
            default:
                request = new HttpPost(url);
                LOGGER.error("Incompatible HTTP request method " + requestMethod + " and system set POST by as default.");
        }
        return request;
    }

    private CloseableHttpResponse sendRequest(String payload, HttpRequest request) throws IOException {
        if (request instanceof HttpPost) {
            ((HttpPost) request).setEntity(new StringEntity(payload, StandardCharsets.UTF_8));
        } else if (request instanceof HttpPut) {
            ((HttpPut) request).setEntity(new StringEntity(payload, StandardCharsets.UTF_8));
        }

        return HttpClients.createDefault().execute((HttpUriRequest) request);
    }

    @Override
    public CloseableHttpResponse sendRequest(RequestMethod requestMethod, String url, String payload)
            throws IOException {

        HttpRequest request = setRequestMethod(requestMethod, url);
        request.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        request.setHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        return sendRequest(payload, request);
    }
    public HttpClient getHttpsClient() {

        SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sSLContext, new DefaultHostnameVerifier());
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(7 * 1000).build();

        return HttpClients.custom().setDefaultRequestConfig(requestConfig).setSSLSocketFactory(factory).build();
    }

    private HttpClient getRReqHttpsClient() {

        SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sSLContext, new DefaultHostnameVerifier());
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(7 * 1000)
                .setSocketTimeout(10000).build();

        return HttpClients.custom().setDefaultRequestConfig(requestConfig).setSSLSocketFactory(factory).build();
    }
}
