package br.com.ezfix.api.controller;

import br.com.ezfix.api.config.security.TokenService;
import br.com.ezfix.api.controller.form.ItemEditarForm;
import br.com.ezfix.api.controller.form.ItemForm;
import br.com.ezfix.api.controller.form.OrcamentoForm;
import br.com.ezfix.api.controller.request.AtualizarStatusPedido;
import br.com.ezfix.api.controller.response.Pedidos;
import br.com.ezfix.api.model.ItemOrcamento;
import br.com.ezfix.api.model.Orcamento;
import br.com.ezfix.api.model.Produto;
import br.com.ezfix.api.model.Solicitante;
import br.com.ezfix.api.repository.*;
import br.com.ezfix.api.util.FilaObj;
import org.apache.commons.io.FileUtils;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orcamentos")
public class OrcamentoController{

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @Autowired
    private ItemOrcamentoRepository itemOrcamentoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private AssistenciaRepository assistenciaRepository;

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/novo/{idAssistencia}")
    public ResponseEntity novoOrcamento(
            @RequestBody List<ItemOrcamento> itens,
            @RequestHeader(value = "Authorization") String token,
            @PathVariable Long idAssistencia
    ){

        if(!assistenciaRepository.existsById(idAssistencia)){
            return ResponseEntity.status(404).build();
        }

        Orcamento orcamento = new Orcamento(solicitanteRepository.getCpfByEmail(tokenService.getIdUsuario(token.substring(7))), idAssistencia);
        orcamentoRepository.save(orcamento);
        orcamento.setId(orcamentoRepository.getUltimoId());


        for (ItemOrcamento itemOrcamento: itens){
            itemOrcamento.setOrcamento(orcamento);
        }

        itemOrcamentoRepository.saveAll(itens);

        return ResponseEntity.status(201).build();
    }

    @GetMapping("/pedidos")
    public ResponseEntity getPedidos(@RequestHeader(value = "Authorization") String token){
        String cpf = solicitanteRepository.getCpfByEmail(tokenService.getIdUsuario(token.substring(7)));
        List<Pedidos> pedidos = orcamentoRepository.getPedidos(cpf);
        pedidos.forEach(pedido -> {
            pedido.setItens(itemOrcamentoRepository.getItemOrcamento(pedido.getIdOrcamento()));
        });
        return ResponseEntity.ok().body(pedidos);
    }

//    @PostMapping("/{id}")
//    public ResponseEntity adicionaItem(@PathVariable Long id,@RequestBody ItemForm itemForm){
//
//        if (!orcamentoRepository.existsById(id)){
//            return ResponseEntity.status(404).build();
//        }
//
//        ItemOrcamento novoItem = itemForm.converterItem(produtoRepository.findById(id).get());
//
//        Orcamento orcamento = orcamentoRepository.findById(id).get();
//
//        itemOrcamentoRepository.save(novoItem);
//        orcamentoRepository.save(orcamento);
//
//        return ResponseEntity.ok().build();
//    }

    @GetMapping
    public ResponseEntity buscarTodos(@PageableDefault(page = 0,size = 10) Pageable paginacao){
        return ResponseEntity.ok().body(orcamentoRepository.findAll(paginacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagar(@PathVariable Long id){
        if(orcamentoRepository.existsById(id)){
            orcamentoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody OrcamentoForm orcamentoForm) {
        if(!orcamentoRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }

        Orcamento orcamento = orcamentoRepository.findById(id).get();
        orcamento.setStatusGeral(orcamentoForm.getStatus());

//        for (ItemEditarForm i : orcamentoForm.getItemEditarForms()){
//            ItemOrcamento item = itemOrcamentoRepository.findById(i.getI()).get();
//            item.setValorServico(i.getV());
//            orcamento.setValorTotal(orcamento.getValorTotal() + i.getV());
//            itemOrcamentoRepository.save(item);
//        }


        orcamentoRepository.save(orcamento);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity atualizaStatus(@RequestBody AtualizarStatusPedido pedido){
        if (orcamentoRepository.existsById(pedido.getId())){
            orcamentoRepository.atualizaStatus(pedido.getId(),pedido.getStatus());
            return ResponseEntity.ok().build();
        }
        
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/solicitante/{cpf}")
    public ResponseEntity buscarTodosOrcamentosSolicitante(@PathVariable String cpf){
        if(solicitanteRepository.existsById(cpf)){
            return ResponseEntity.ok().body(orcamentoRepository.findAllBySolicitanteCpf(cpf));
        }

        return ResponseEntity.status(404).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        if(orcamentoRepository.existsById(id)){
            return ResponseEntity.ok().body(orcamentoRepository.findById(id).get());
        }

        return ResponseEntity.status(404).build();
    }

    @GetMapping("/assistencia/{id}")
    public ResponseEntity buscarPorIdAssistencia(@PathVariable Long id){
        if(!assistenciaRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }

        List<Orcamento> orcamentos = orcamentoRepository.findAllByAssistenciaId(id);
        if(orcamentos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.ok().body(orcamentos);

    }

    @GetMapping("/count/{id}")
    public ResponseEntity totalOrcamentosDia(@PathVariable Long id){
        if (!assistenciaRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok().body(Arrays.asList(orcamentoRepository.totalOrcamentoDia(id),comentarioRepository.contarTodosComentariosHoje(id)));
    }
}
