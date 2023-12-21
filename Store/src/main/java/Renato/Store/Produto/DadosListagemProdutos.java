package Renato.Store.Produto;

public record DadosListagemProdutos(Long id, String nome, String categoria, Long preco, Boolean status){
    public DadosListagemProdutos(Produto produto)
    {
        this(produto.getId(), produto.getNome(), produto.getCategoria(), produto.getPreco(), produto.getStatus());
    }
}
