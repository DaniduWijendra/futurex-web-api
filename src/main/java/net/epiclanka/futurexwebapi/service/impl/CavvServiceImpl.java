package net.epiclanka.futurexwebapi.service.impl;

import net.epiclanka.futurexwebapi.model.*;
import net.epiclanka.futurexwebapi.service.CavvService;
import net.epiclanka.futurexwebapi.util.MessageVarList;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;



class CreateHostnameVerifier implements HostnameVerifier {
    @Override
    public boolean verify(String hostname, SSLSession session) {

        return true;
    }
}


@Service
public class CavvServiceImpl implements CavvService {

    private static final Logger logger = Logger.getLogger(CavvServiceImpl.class);


    HttpHeaders headers;

    @Value("${virtucrypt.url}")
    private String virtucryptUrl;
    @Autowired
    private SSLContext sslContext;
    @Autowired
    private RestTemplate restTemplate;

    private static final String ERROR = "Error Message";

    @Override
    public ResponseEntity<Object> generateCavv(CavvRequest cavvRequest) {
        logger.info("Log message " + cavvRequest.toString());



        try {

            headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setConnection("Keep-Alive");
            logger.info(headers);
            CreateHostnameVerifier hv = new CreateHostnameVerifier();
            HttpClient httpClient = HttpClientBuilder.create()
                    .setSSLContext(sslContext)
                    .setSSLHostnameVerifier(hv)
                    .build();

            ClientHttpRequestFactory requestFactory =
                    new HttpComponentsClientHttpRequestFactory(httpClient);

            restTemplate.setRequestFactory(requestFactory);
            CavvRespond cavvRespond = restTemplate.postForObject(virtucryptUrl, cavvRequest, CavvRespond.class);
            logger.info(cavvRespond.toString());
            return new ResponseEntity<>(cavvRespond, HttpStatus.ACCEPTED);

        } catch (ResourceAccessException e) {
            e.printStackTrace();
            ErrorRes errorRes = new ErrorRes();
            errorRes.setMessageType(MessageVarList.ERROR_MESSAGE_TYPE);
            errorRes.setMessageId(MessageVarList.CONNECTION_TIMEOUT_ID);
            errorRes.setMessageDescription(MessageVarList.CONNECTION_TIMEOUT_MSG);
            logger.info(ERROR + errorRes.toString());
            return new ResponseEntity<>(errorRes, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorRes errorRes = new ErrorRes();
            errorRes.setMessageType(MessageVarList.ERROR_MESSAGE_TYPE);
            errorRes.setMessageId(MessageVarList.CONNECTION_ERROR_ID);
            errorRes.setMessageDescription(MessageVarList.CONNECTION_ERROR_MSG);
            logger.info(ERROR + errorRes.toString());
            return new ResponseEntity<>(errorRes, HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<Object> testData(TestRequest testRequest) {
        logger.info("Log message " + testRequest.toString());


        try {

            headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setConnection("Keep-Alive");
            logger.info(headers);
            CreateHostnameVerifier hv = new CreateHostnameVerifier();
            HttpClient httpClient = HttpClientBuilder.create()
                    .setSSLContext(sslContext)
                    .setSSLHostnameVerifier(hv)
                    .build();

            ClientHttpRequestFactory requestFactory =
                    new HttpComponentsClientHttpRequestFactory(httpClient);

            restTemplate.setRequestFactory(requestFactory);
            TestRespond testRespond = restTemplate.postForObject(virtucryptUrl, testRequest, TestRespond.class);
            logger.info(testRespond.toString());
            return new ResponseEntity<>(testRespond, HttpStatus.ACCEPTED);

        } catch (ResourceAccessException e) {
            e.printStackTrace();
            ErrorRes errorRes = new ErrorRes();
            errorRes.setMessageType(MessageVarList.ERROR_MESSAGE_TYPE);
            errorRes.setMessageId(MessageVarList.CONNECTION_TIMEOUT_ID);
            errorRes.setMessageDescription(MessageVarList.CONNECTION_TIMEOUT_MSG);
            logger.info(ERROR + errorRes.toString());
            return new ResponseEntity<>(errorRes, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorRes errorRes = new ErrorRes();
            errorRes.setMessageType(MessageVarList.ERROR_MESSAGE_TYPE);
            errorRes.setMessageId(MessageVarList.CONNECTION_ERROR_ID);
            errorRes.setMessageDescription(MessageVarList.CONNECTION_ERROR_MSG);
            logger.info(ERROR + errorRes.toString());
            return new ResponseEntity<>(errorRes, HttpStatus.BAD_REQUEST);
        }
    }
}
