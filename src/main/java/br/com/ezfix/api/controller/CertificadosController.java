package br.com.ezfix.api.controller;

import br.com.ezfix.api.model.Assistencia;
import br.com.ezfix.api.model.Certificado;
import br.com.ezfix.api.repository.AssistenciaRepository;
import br.com.ezfix.api.repository.CertificadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certificacoes")
public class CertificadosController {

    @Autowired
    private AssistenciaRepository assistenciaRepository;

    @Autowired
    private CertificadoRepository certificadoRepository;

    @PostMapping("/{id}")
    public ResponseEntity<?> cadastrar(@RequestBody Certificado certificado, @PathVariable Long id){
        certificado.setAssistencia(new Assistencia(id));
        certificadoRepository.save(certificado);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagar(@PathVariable Long id) {
        if(certificadoRepository.existsById(id)){
            certificadoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(404).build();
    }

//    @PutMapping("/{id}")
//    public ResponseEntity atualizar(@PathVariable Long id,@RequestBody CertificacoesForm certificacoesForm) {
//        if(certificadoRepository.existsById(id)){
//            Certificado certificado = certificadoRepository.findById(id).get();
//            certificacoesForm.getCertificacoes().setId(certificado.getId());
//            certificadoRepository.save(certificacoesForm.getCertificacoes());
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.status(404).build();
//    }

    @GetMapping
    public ResponseEntity<Page<Certificado>> buscarTodos(@PageableDefault(page = 0,size = 10) Pageable paginacao) {
        return ResponseEntity.ok().body(certificadoRepository.findAll(paginacao));
    }
}
