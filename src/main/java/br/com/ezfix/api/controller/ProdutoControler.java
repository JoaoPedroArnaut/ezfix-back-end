package br.com.ezfix.api.controller;

import br.com.ezfix.api.controller.response.ProdutoSimples;
import br.com.ezfix.api.model.Marca;
import br.com.ezfix.api.model.Modelo;
import br.com.ezfix.api.model.Produto;
import br.com.ezfix.api.model.Tipo;
import br.com.ezfix.api.repository.MarcaRepository;
import br.com.ezfix.api.repository.ModeloRepository;
import br.com.ezfix.api.repository.ProdutoRepository;
import br.com.ezfix.api.repository.TipoRepository;
import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoControler {

    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/tipos")
    public ResponseEntity<List<Tipo>> getTipos(){
        List<Tipo> tipos = tipoRepository.findAll();

        return tipos.isEmpty() ? ResponseEntity.status(204).build(): ResponseEntity.status(200).body(tipos);
    }

    @GetMapping("/marcas/{id}")
    public ResponseEntity<List<Marca>> getMarcas(@PathVariable Long id){
        List<Marca> marcas = produtoRepository.obterPorTodosTipo(id);

        return marcas.isEmpty() ? ResponseEntity.status(204).build(): ResponseEntity.status(200).body(marcas);
    }

    @GetMapping("/modelos/{idTipo}/{idMarca}")
    public ResponseEntity<List<Modelo>> getModelos(@PathVariable Long idTipo,@PathVariable Long idMarca){
        List<Modelo> modelos = produtoRepository.obterPorTodosTipoAndMarca(idTipo,idMarca);

        return modelos.isEmpty() ? ResponseEntity.status(204).build(): ResponseEntity.status(200).body(modelos);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos(){
        List<Produto> produtos = produtoRepository.findAll();

        return produtos.isEmpty() ? ResponseEntity.status(204).build(): ResponseEntity.status(200).body(produtos);
    }
}
