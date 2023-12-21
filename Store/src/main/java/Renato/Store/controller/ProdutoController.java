package Renato.Store.controller;

//import Renato.Store.Produto.*;
import Renato.Store.domain.Produto.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProduto dados, UriComponentsBuilder uriBuilder){

        var produto = new Produto(dados);
        repository.save(produto);

        var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        var dto = new DadosDetalhamentoProduto(produto);
        return ResponseEntity.created(uri).body(dto);
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemProdutos>> listarProdrutos(Pageable pageable)
    {
       var page = repository.findAllByStatusTrue(pageable).map(DadosListagemProdutos::new);
       return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id)
    {
        var produto = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
    }


    @PutMapping
    @Transactional
    public ResponseEntity alterarProduto(@RequestBody @Valid DadosAlterarProduto dados)
    {
//        System.out.println(dados);
        var produto = repository.getReferenceById(dados.id());
        produto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoProduto(produto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity removerProduto(@PathVariable Long id){
        //repository.deleteById(id);  //remove registro do banco de dados
        var produto = repository.getReferenceById(id);
        produto.excluir();

        return ResponseEntity.noContent().build();
    }

}
