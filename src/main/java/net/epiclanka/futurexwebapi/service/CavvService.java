package net.epiclanka.futurexwebapi.service;

import net.epiclanka.futurexwebapi.model.CavvRequest;
import net.epiclanka.futurexwebapi.model.TestRequest;
import org.springframework.http.ResponseEntity;

public interface CavvService {
    ResponseEntity<Object> generateCavv(CavvRequest cavvRequest);

    ResponseEntity<Object> testData(TestRequest testRequest);
}
