package br.com.ezfix.api.controller;

import br.com.ezfix.api.controller.form.CertificacoesForm;
import br.com.ezfix.api.controller.dto.CertificacoesDto;
import br.com.ezfix.api.model.Certificacao;
import br.com.ezfix.api.repository.AssistenciaRepository;
import br.com.ezfix.api.repository.CertificacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certificacoes")
public class CertificacoesController extends BaseController {

    @Autowired
    private AssistenciaRepository assistenciaRepository;

    @Autowired
    private CertificacoesRepository certificacoesRepository;

    @PostMapping("/{id}")
    public ResponseEntity<?> cadastrar(@RequestBody CertificacoesForm certificacoesForm, @PathVariable Long id){
        certificacoesForm.converterCertificacoes(assistenciaRepository.getById(id));
        certificacoesRepository.save(certificacoesForm.getCertificacoes());
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagar(@PathVariable Long id) {
        if(certificacoesRepository.existsById(id)){
            certificacoesRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id,@RequestBody CertificacoesForm certificacoesForm) {
        if(certificacoesRepository.existsById(id)){
            Certificacao certificacao = certificacoesRepository.findById(id).get();
            certificacoesForm.converterCertificacoes(certificacao.getAssistencia());
            certificacoesForm.getCertificacoes().setId(certificacao.getId());
            certificacoesRepository.save(certificacoesForm.getCertificacoes());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping
    @Override
    public ResponseEntity<Page<CertificacoesDto>> buscarTodos(@PageableDefault(page = 0,size = 10) Pageable paginacao) {
        return ResponseEntity.ok().body(CertificacoesDto.converter(certificacoesRepository.findAll(paginacao)));
    }
}
