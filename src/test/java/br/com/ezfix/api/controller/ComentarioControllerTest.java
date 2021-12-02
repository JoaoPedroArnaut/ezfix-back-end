package br.com.ezfix.api.controller;

import br.com.ezfix.api.model.Comentario;
import br.com.ezfix.api.repository.AssistenciaRepository;
import br.com.ezfix.api.repository.ComentarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {ComentarioController.class, ComentarioRepository.class})
class ComentarioControllerTest {

    @Autowired
    ComentarioController controller;

    @MockBean
    ComentarioRepository repository;

    @MockBean
    AssistenciaRepository assistenciaRepository;

    @Test
    void novoComentario_status201(){

        assertEquals(201,controller.novoComentario(new Comentario()).getStatusCodeValue());
    }

    @Test
    void buscarNovosOrcamentos_seIdInexistente_status400(){
        assertEquals(404, controller.buscarNovosOrcamentos(900l).getStatusCodeValue());
    }


}