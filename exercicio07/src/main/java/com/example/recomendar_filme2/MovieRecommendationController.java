package com.example.recomendar_filme2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieRecommendationController {

    @GetMapping("/recomendar")
    public String recomendarFilme(
            @RequestParam String genero,
            @RequestParam String ambiente) {

        // Lógica para recomendar filme
        if (genero.equalsIgnoreCase("acao") && ambiente.equalsIgnoreCase("futurista")) {
            return "Homens de Preto";
        } else if (genero.equalsIgnoreCase("acao") && ambiente.equalsIgnoreCase("medieval")) {
            return "Coração Valente";
        } else if (genero.equalsIgnoreCase("comedia") && ambiente.equalsIgnoreCase("urbano")) {
            return "Se Beber, Não Case!";
        } else {
            return "Nenhuma recomendação disponível para essa combinação.";
        }
    }
}
