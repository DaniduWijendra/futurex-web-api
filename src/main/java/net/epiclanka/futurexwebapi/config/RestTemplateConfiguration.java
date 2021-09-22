package net.epiclanka.futurexwebapi.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

@Configuration
public class RestTemplateConfiguration {
    private static final Logger logger = Logger.getLogger(RestTemplateConfiguration.class);

    @Value("${trust.store}")
    private String trustStore;

    @Value("${trust.store.password}")
    private String trustStorePassword;

    @Bean
    public SSLContext getSSLContext() throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {


        try (FileInputStream trustStoreStream = new FileInputStream(trustStore);
             FileInputStream keyStoreStream = new FileInputStream(trustStore);) {

            KeyStore trustStores = KeyStore.getInstance("JKS");
            KeyStore keystore = KeyStore.getInstance("JKS");

            trustStores.load(trustStoreStream, trustStorePassword.toCharArray());
            keystore.load(keyStoreStream, trustStorePassword.toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory
                    .getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keystore, trustStorePassword.toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory
                    .getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(trustStores);

            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(),
                    new SecureRandom());

            return sslContext;

        } catch (Exception e) {
            logger.error(e);
            return null;
        }

    }
}
