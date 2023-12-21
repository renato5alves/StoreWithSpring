package Renato.Store.Produto;

import jakarta.validation.constraints.NotNull;

public record DadosAlterarProduto(
        @NotNull
        Long id,
        String nome,
        String categoria,
        Long preco
) {

}
