package com.example.fipe_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/fipe")
public class FipeController {


    private final RestTemplate restTemplate;


    public FipeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/valor")
    public ResponseEntity<Map<String, Object>> getValorFipe(@RequestBody CarroRequest carroRequest) {

        String url = "https://deividfortuna.github.io/fipe/";


        Map<String, String> params = new HashMap<>();
        params.put("marca", carroRequest.getMarca());
        params.put("modelo", carroRequest.getModelo());
        params.put("ano", String.valueOf(carroRequest.getAno()));


        Map<String, Object> response = restTemplate.getForObject(url, Map.class, params);


        Map<String, Object> fipeData = new HashMap<>();
        fipeData.put("valor", 50000.0);
        fipeData.put("mes", "Setembro de 2024");


        return ResponseEntity.ok(fipeData);
    }
}

