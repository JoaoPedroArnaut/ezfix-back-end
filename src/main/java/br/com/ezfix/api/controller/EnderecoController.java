package br.com.ezfix.api.controller;

import br.com.ezfix.api.controller.form.EnderecoForm;
import br.com.ezfix.api.model.Solicitante;
import br.com.ezfix.api.repository.AssistenciaRepository;
import br.com.ezfix.api.repository.EnderecoEspecificoRepository;
import br.com.ezfix.api.repository.EnderecoGeralRepository;
import br.com.ezfix.api.repository.SolicitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoEspecificoRepository enderecoEspecificoRepository;

    @Autowired
    private EnderecoGeralRepository enderecoGeralRepository;

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @Autowired
    private AssistenciaRepository assistenciaRepository;

    @PostMapping("/solicitante/{id}")
    public ResponseEntity addEnderecoSolicitante(@PathVariable String id, @RequestBody EnderecoForm enderecoForm){
        enderecoForm.converteEnderecoGeral();
        enderecoForm.converteEnderecoEspecifico();

        if (!solicitanteRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }
        if (!enderecoGeralRepository.existsById(enderecoForm.getCep())){
            enderecoGeralRepository.save(enderecoForm.getEnderecoGeral());
        }
        enderecoEspecificoRepository.save(enderecoForm.getEnderecoEspecifico());
        Solicitante solicitante = solicitanteRepository.findById(id).get();
        solicitante.getEnderecoEspecificos().add(enderecoForm.getEnderecoEspecifico());
        solicitanteRepository.save(solicitante);
        return ResponseEntity.ok().build();
    }
}
