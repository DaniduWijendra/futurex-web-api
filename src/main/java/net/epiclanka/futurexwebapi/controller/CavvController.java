package net.epiclanka.futurexwebapi.controller;

import net.epiclanka.futurexwebapi.dto.CavvRequestDto;
import net.epiclanka.futurexwebapi.dto.TestRequestDto;
import net.epiclanka.futurexwebapi.model.CavvRequest;
import net.epiclanka.futurexwebapi.model.TestRequest;
import net.epiclanka.futurexwebapi.service.CavvService;
import net.epiclanka.futurexwebapi.util.EndPoint;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/cavv")
public class CavvController {

    private CavvService cavvService;
    private ModelMapper modelMapper;

    @Autowired
    public CavvController(CavvService cavvService,ModelMapper modelMapper) {
        this.cavvService = cavvService;
        this.modelMapper = modelMapper;
    }
    @PostMapping(value = EndPoint.GENERATE_CAVV, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> cavvRequest(@RequestBody CavvRequestDto cavvRequestDto) {
        CavvRequest cavvRequest = modelMapper.map(cavvRequestDto, CavvRequest.class);
        return cavvService.generateCavv(cavvRequest);
    }
    @PostMapping(value = EndPoint.TEST_CONNECTION, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> testRequest(@RequestBody TestRequestDto testRequestDto) {
        TestRequest testRequest = modelMapper.map(testRequestDto, TestRequest.class);
        return cavvService.testData(testRequest);
    }


}
