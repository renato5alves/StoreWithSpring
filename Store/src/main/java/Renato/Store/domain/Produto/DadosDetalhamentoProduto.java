package Renato.Store.domain.Produto;

public record DadosDetalhamentoProduto(Long id, String nome, String categoria, Long preco) {

    public DadosDetalhamentoProduto(Produto produto)
    {
        this(produto.getId(), produto.getNome(), produto.getCategoria(), produto.getPreco());
    }
}
