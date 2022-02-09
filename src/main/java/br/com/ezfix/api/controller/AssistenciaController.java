package br.com.ezfix.api.controller;

import br.com.ezfix.api.controller.request.AttTelefone;
import br.com.ezfix.api.controller.response.CardAsssitencia;
import br.com.ezfix.api.model.Assistencia;
import br.com.ezfix.api.repository.AssistenciaRepository;
import br.com.ezfix.api.repository.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/assistencia")
public class AssistenciaController{

    @Autowired
    private AssistenciaRepository assistenciaRepository;

    @Autowired
    private ServicosRepository servicosRepository;


    @PostMapping("/perfil/{id}")
    public ResponseEntity patchFoto(@PathVariable Long id, @RequestParam MultipartFile img) throws IOException {

        if(!assistenciaRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }

        Assistencia assistencia = assistenciaRepository.findById(id).get();

        byte[] novaFoto = img.getBytes();

        assistencia.setPerfil(novaFoto);

        assistenciaRepository.save(assistencia);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscaAssistenciaPorId(@PathVariable Long id){
        if (assistenciaRepository.existsById(id)){
            return ResponseEntity.ok().body(assistenciaRepository.findById(id).get());
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity buscarUsuarioPorEmail(@PathVariable String email){
        return ResponseEntity.status(200).body(assistenciaRepository.findByRepresentanteUsuarioEmail(email));
    }

    @GetMapping
    public ResponseEntity<Page<Assistencia>> buscarTodos(@PageableDefault(page = 0,size = 9) Pageable paginacao) {
        return ResponseEntity.ok().body(assistenciaRepository.findAll(paginacao));
    }

    @GetMapping("/card-assistencia")
    public ResponseEntity<Page<CardAsssitencia>> todosCard(@PageableDefault(page = 0,size = 9) Pageable paginacao){
        return ResponseEntity.ok().body(assistenciaRepository.todosCardAssistencia(paginacao));
    }

    @GetMapping("/perfil/{id}")
    public ResponseEntity getFoto(@PathVariable Long id){
        Assistencia assistencia = assistenciaRepository.findById(id).get();
        byte[] foto = assistencia.getPerfil();

        return ResponseEntity.status(200).header("content-type","image/jpeg").body(foto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagar(@PathVariable Long id) {
        if(assistenciaRepository.existsById(id)){
            assistenciaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}/{servico}")
    public ResponseEntity<?> adicionaServico(@PathVariable Long id, @PathVariable Long servico){
        Assistencia assistencia = assistenciaRepository.findById(id).get();
        assistencia.getServicos().add(servicosRepository.getById(servico));
        assistenciaRepository.save(assistencia);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizaTelefones(@PathVariable Long id, @RequestBody AttTelefone telefone){
        if(assistenciaRepository.existsById(id)){
            assistenciaRepository.atualizaTelefone(id,telefone.getTelefonePrimario(), telefone.getTelefoneSecundario());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(404).build();
    }
}
