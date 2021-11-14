package br.com.ezfix.api.controller;

import br.com.ezfix.api.controller.dto.SolicitanteDto;
import br.com.ezfix.api.model.Solicitante;
import br.com.ezfix.api.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/solicitante")
public class SolicitanteController {

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @GetMapping
    public ResponseEntity<Page<SolicitanteDto>> buscarTodos(@PageableDefault(page = 0,size = 10) Pageable paginacao) {
        return ResponseEntity.ok().body(SolicitanteDto.converter(solicitanteRepository.findAll(paginacao)));
    }

    @PostMapping("/perfil/{id}")
    public ResponseEntity patchFoto(@PathVariable String id, @RequestParam MultipartFile img) throws IOException {

        if(!solicitanteRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }

        Solicitante solicitante = solicitanteRepository.findById(id).get();

        byte[] novaFoto = img.getBytes();

        solicitante.setPerfil(novaFoto);

        solicitanteRepository.save(solicitante);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/perfil/{id}")
    public ResponseEntity getFoto(@PathVariable String id){
        Solicitante solicitante = solicitanteRepository.findById(id).get();
        byte[] foto = solicitante.getPerfil();

        return ResponseEntity.status(200).header("content-type","image/jpeg").body(foto);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity buscarUsuarioPorEmail(@PathVariable String email){
        return ResponseEntity.status(200).body(solicitanteRepository.findByUsuarioEmail(email));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity buscarUsuarioPorCpf(@PathVariable String cpf){
        return ResponseEntity.status(200).body(solicitanteRepository.findById(cpf));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagar(@PathVariable String id) {
        if(solicitanteRepository.existsById(id)){
            solicitanteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(404).build();
    }
}
