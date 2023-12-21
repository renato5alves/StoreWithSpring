package Renato.Store.controller;

import Renato.Store.Produto.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroProduto dados){

        repository.save(new Produto(dados));
    }
    @GetMapping
    public Page<DadosListagemProdutos> listarProdrutos(Pageable pageable)
    {
       return repository.findAllByStatusTrue(pageable).map(DadosListagemProdutos::new);
    }

    @PutMapping
    @Transactional
    public void alterarProduto(@RequestBody @Valid DadosAlterarProduto dados)
    {
//        System.out.println(dados);
        var produto = repository.getReferenceById(dados.id());
        produto.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void removerProduto(@PathVariable Long id){
        //repository.deleteById(id);  //remove registro do banco de dados
        var produto = repository.getReferenceById(id);
        produto.excluir();

    }

}
