package com.exercicio.banco.dto;

public record TransacaoResponseDTO(ContaDTO origem, ContaDTO destino, Double valor) {
}
