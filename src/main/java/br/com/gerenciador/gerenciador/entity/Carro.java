package br.com.gerenciador.gerenciador.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    private String marca;

    private String modelo;

    private String ano;

    private String kilometragem;

    private String cor;

    private Boolean vendido;
}
