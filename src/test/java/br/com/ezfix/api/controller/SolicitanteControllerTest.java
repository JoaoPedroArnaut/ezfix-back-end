package br.com.ezfix.api.controller;

import br.com.ezfix.api.model.Solicitante;
import br.com.ezfix.api.repository.SolicitanteRepository;
import br.com.ezfix.api.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {SolicitanteController.class, SolicitanteRepository.class})
class SolicitanteControllerTest {

    @Autowired
    SolicitanteController controller;

    @MockBean
    SolicitanteRepository repository;

    @MockBean
    UsuarioRepository usuarioRepository;

    @Test
    void buscarUsuarioPorEmail_status200(){
        assertEquals(200, controller.buscarUsuarioPorEmail("cliente@teste.com").getStatusCodeValue());
    }

    @Test
    void buscarUsuarioPorCpf_status200(){
        assertEquals(200, controller.buscarUsuarioPorCpf("123456789-10").getStatusCodeValue());
    }

    @Test
    void atualizarUsuario_invalido_status404(){
        assertEquals(404,controller.atualizar("1", new Solicitante()) .getStatusCodeValue());
    }

    @Test
    void apagarUsuario_invalido_status404(){
        assertEquals(404,controller.apagar("1").getStatusCodeValue());
    }
}