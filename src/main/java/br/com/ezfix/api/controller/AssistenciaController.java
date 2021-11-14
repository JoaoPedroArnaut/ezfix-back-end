package br.com.ezfix.api.controller;

import br.com.ezfix.api.controller.dto.AssistenciaDto;
import br.com.ezfix.api.model.Assistencia;
import br.com.ezfix.api.model.Orcamento;
import br.com.ezfix.api.model.Solicitante;
import br.com.ezfix.api.repository.AssistenciaRepository;
import br.com.ezfix.api.repository.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assistencia")
public class AssistenciaController extends BaseController {

    @Autowired
    private AssistenciaRepository assistenciaRepository;

    @Autowired
    private ServicosRepository servicosRepository;

    @GetMapping
    @Override()
    public ResponseEntity<Page<AssistenciaDto>> buscarTodos(@PageableDefault(page = 0,size = 10) Pageable paginacao) {
        return ResponseEntity.ok().body(AssistenciaDto.converter(assistenciaRepository.findAll(paginacao)));
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
}
