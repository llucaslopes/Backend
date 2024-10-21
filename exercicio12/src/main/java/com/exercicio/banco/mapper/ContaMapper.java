package com.exercicio.banco.mapper;

import com.exercicio.banco.dto.ContaDTO;
import com.exercicio.banco.model.Conta;

public class ContaMapper {
    public static ContaDTO toContaDTO(Conta conta) {
        return new ContaDTO(conta.getCodigo(), conta.getCliente());
    }
}
