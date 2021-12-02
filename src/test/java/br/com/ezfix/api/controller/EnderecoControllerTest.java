package br.com.ezfix.api.controller;

import br.com.ezfix.api.controller.form.EnderecoForm;
import br.com.ezfix.api.repository.AssistenciaRepository;
import br.com.ezfix.api.repository.EnderecoEspecificoRepository;
import br.com.ezfix.api.repository.EnderecoGeralRepository;
import br.com.ezfix.api.repository.SolicitanteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {EnderecoController.class, EnderecoGeralRepository.class, EnderecoEspecificoRepository.class})
class EnderecoControllerTest {

    @Autowired
    EnderecoController controller;

    @MockBean
    EnderecoEspecificoRepository enderecoEspecificoRepository;

    @MockBean
    EnderecoGeralRepository enderecoGeralRepository;

    @MockBean
    private SolicitanteRepository solicitanteRepository;

    @MockBean
    AssistenciaRepository assistenciaRepository;

    @Test
    void addEnderecoSolicitante_status404(){
        assertEquals(404,controller.addEnderecoSolicitante("",new EnderecoForm(01414002l, "Haddock Lobo", "Consolacao", "São Paulo", "SP", 595l, "" )).getStatusCodeValue());
    }


}