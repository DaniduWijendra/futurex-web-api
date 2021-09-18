package net.epiclanka.futurexwebapi.service;

import net.epiclanka.futurexwebapi.model.CavvRequest;
import org.springframework.http.ResponseEntity;

public interface CavvService {
    public ResponseEntity<Object> generateCavv(CavvRequest cavvRequest);

}
