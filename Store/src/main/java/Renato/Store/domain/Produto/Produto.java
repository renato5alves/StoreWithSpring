package Renato.Store.domain.Produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "produtos")
@Entity(name = "produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;
    private Long preco;
    private Boolean status;

    public Produto(DadosCadastroProduto dados) {
        this.nome = dados.nome();
        this.categoria = dados.categoria();
        this.preco = dados.preco();
        this.status = true;
    }

    public void atualizarInformacoes(DadosAlterarProduto dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }if (dados.categoria() != null) {
            this.categoria = dados.categoria();
        }
        if (dados.preco() != null) {
            this.preco = dados.preco();
        }
    }

    public void excluir() {
        this.status = false;
    }
}
