package Renato.Store.domain.Produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProduto(
    @NotBlank
    String nome,
    @NotBlank
    String categoria,
    @NotNull
    Long preco
    ){}
