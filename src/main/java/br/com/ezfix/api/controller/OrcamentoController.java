package br.com.ezfix.api.controller;

import br.com.ezfix.api.controller.form.ItemEditarForm;
import br.com.ezfix.api.controller.form.ItemForm;
import br.com.ezfix.api.controller.form.OrcamentoForm;
import br.com.ezfix.api.controller.request.AtualizarStatusPedido;
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

    @PostMapping("/{idSolicitante}/{idAssistencia}")
    private ResponseEntity novoOrcamento(
            @RequestBody List<ItemForm> itens,
            @PathVariable String idSolicitante,
            @PathVariable Long idAssistencia
    ){

        if(!solicitanteRepository.existsById(idSolicitante)){
            return ResponseEntity.status(404).build();
        }

        if(!assistenciaRepository.existsById(idAssistencia)){
            return ResponseEntity.status(404).build();
        }

        List<ItemOrcamento> itemOrcamentos = new ArrayList<>();

        for (ItemForm itemForm : itens){
            ItemOrcamento item = itemForm.converterItem(produtoRepository.findByMarcaAndModelo(itemForm.getMarca(),itemForm.getModelo()));
            itemOrcamentoRepository.save(item);
            itemOrcamentos.add(item);
        }

        orcamentoRepository.save(
                new Orcamento(
                    solicitanteRepository.findById(idSolicitante).get(),
                    assistenciaRepository.findById(idAssistencia).get(),
                        itemOrcamentos
                )
        );

        return ResponseEntity.status(201).build();
    }

    @PostMapping("/txt/{idSolicitante}/{idAssistencia}")
    private ResponseEntity novoOrcamentoporTxt(
            @RequestParam MultipartFile itens,
            @PathVariable String idSolicitante,
            @PathVariable Long idAssistencia
    ) {

        if(!solicitanteRepository.existsById(idSolicitante)){
            return ResponseEntity.status(404).build();
        }

        if(!assistenciaRepository.existsById(idAssistencia)){
            return ResponseEntity.status(404).build();
        }

        List<ItemOrcamento> itemOrcamentos = new ArrayList<>();
//        File txt = new File("/opt/ezfix/provisorio.txt");
        File txt = new File("src/main/resources/provisorio.txt");

        FilaObj<ItemOrcamento> filaObj = new FilaObj<>(1000);
        try {
            txt.delete();
            txt.createNewFile();
            itens.transferTo(txt.getAbsoluteFile());
            BufferedReader entrada = new BufferedReader(new FileReader(txt));
            String register = entrada.readLine();


            String registerType;
            while (register != null) {
                registerType = register.substring(0, 2);
                switch (registerType) {
                    case "00":
                        System.out.println("----------Header----------");
                        System.out.println("Tipo do arquivo: " + register.substring(2, 15).trim());
                        System.out.println("Data/Hora de geração do arquivo: " + register.substring(16, 34).trim());
                        break;
                    case "02":
                        System.out.println("----------Registro do Body (Produto)----------");
                        ItemOrcamento item = new ItemOrcamento();
                        item.setProduto(new Produto());
                        item.getProduto().setId(Long.parseLong(register.substring(3, 6).trim()));
                        item.setProblema(register.substring(6, 26).trim());
                        item.getProduto().setTipo(register.substring(27, 36).trim());
                        item.getProduto().setMarca(register.substring(37, 46).trim());
                        item.getProduto().setModelo(register.substring(47, 51).trim());
                        filaObj.insert(item);
                        break;
                    case "01":
                        System.out.println("----------Trailer----------");
                        System.out.println(Integer.valueOf(register.substring(3, 7).trim()));
                        break;
                    default:
                        System.out.println("Tipo de registro inválido");
                        break;
                }

                register = entrada.readLine();
            }

            entrada.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        while (!filaObj.isEmpty()){
            ItemOrcamento item = filaObj.poll();
            itemOrcamentos.add(item);

            itemOrcamentoRepository.save(item);
        }

        orcamentoRepository.save(
                new Orcamento(
                        solicitanteRepository.findById(idSolicitante).get(),
                        assistenciaRepository.findById(idAssistencia).get(),
                        itemOrcamentos
                )
        );

        return ResponseEntity.status(201).build();
    }



    @PostMapping("/{id}")
    public ResponseEntity adicionaItem(@PathVariable Long id,@RequestBody ItemForm itemForm){

        if (!orcamentoRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }

        ItemOrcamento novoItem = itemForm.converterItem(produtoRepository.findById(id).get());

        Orcamento orcamento = orcamentoRepository.findById(id).get();
        orcamento.getItens().add(novoItem);

        itemOrcamentoRepository.save(novoItem);
        orcamentoRepository.save(orcamento);

        return ResponseEntity.ok().build();
    }

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

        for (ItemEditarForm i : orcamentoForm.getItemEditarForms()){
            ItemOrcamento item = itemOrcamentoRepository.findById(i.getI()).get();
            item.setValorServico(i.getV());
            orcamento.setValorTotal(orcamento.getValorTotal() + i.getV());
            itemOrcamentoRepository.save(item);
        }


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

    @GetMapping("/assistencia/novo/{id}")
    public ResponseEntity buscarNovosOrcamentos(@PathVariable Long id){
        if(!assistenciaRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }

        List<Orcamento> orcamentos = orcamentoRepository.findAllByAssistenciaIdAndStatusGeral(id,"agurdando resposta tecnico");

        orcamentos = orcamentos.stream().sorted(Comparator.comparing(Orcamento::getDataSolicitacao)).collect(Collectors.toList());
        FilaObj<Orcamento> orcamentoFilaObj = new FilaObj<>(orcamentos.size());

        for (Orcamento o : orcamentos){
            orcamentoFilaObj.insert(o);
        }
        if(orcamentos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.ok().body(orcamentoFilaObj);

    }

    @GetMapping("/count/{id}")
    public ResponseEntity totalOrcamentosDia(@PathVariable Long id){
        if (!assistenciaRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok().body(Arrays.asList(orcamentoRepository.totalOrcamentoDia(id),comentarioRepository.contarTodosComentariosHoje(id)));
    }

    @GetMapping("/nota/{id}")
    public ResponseEntity gerarNota(@PathVariable Long id) throws IOException {
        if(!orcamentoRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }
        Orcamento orcamento = orcamentoRepository.findById(id).get();
//        File txt = new File("/opt/ezfix/nota.txt");
        File txt = new File("src/main/resources/nota.txt");
        txt.delete();
//        BufferedWriter saida = new BufferedWriter (new FileWriter("/opt/ezfix/nota.txt", true));
        BufferedWriter saida = new BufferedWriter (new FileWriter("src/main/resources/nota.txt", true));


        // Monta o registro de header
        String header = "00LISTAPRODUTOS";
        Date dataDeHoje = new Date();
        SimpleDateFormat formataData =
                new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header += formataData.format(dataDeHoje);
        header += "01";

        // Grava o registro do header
        saida.append(header + "\n");

        // Monta e grava o corpo
        for (ItemOrcamento i : orcamento.getItens()) {
            String corpo = "02";
            corpo += String.format("%04d",i.getProduto().getId());
            corpo += String.format("%-20.20s",  i.getProblema());
            corpo += String.format("%-10.10s", i.getProduto().getTipo());
            corpo += String.format("%-10.10s", i.getProduto().getMarca());
            corpo += String.format("%-15.15s", i.getProduto().getModelo());
            saida.append(corpo + "\n");
        }


        // Monta e grava o trailer
        String trailer = "01";
        trailer += String.format("%05d", orcamento.getItens().size());
        saida.append(trailer + "\n");

        saida.close();

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + txt.getName() + "\"").body(FileUtils.readFileToByteArray(txt));
    }
}
