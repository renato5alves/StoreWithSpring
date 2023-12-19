package Renato.Store.Produto;

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

    public Produto(DadosCadastroProduto dados) {
        this.nome = dados.nome();
        this.categoria = dados.categoria();
        this.preco = dados.preco();
    }
}
