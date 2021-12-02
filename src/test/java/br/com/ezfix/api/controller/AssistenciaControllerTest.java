package br.com.ezfix.api.controller;

import br.com.ezfix.api.controller.AssistenciaController;
import br.com.ezfix.api.repository.AssistenciaRepository;
import br.com.ezfix.api.repository.ServicosRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest(classes = {AssistenciaController.class, AssistenciaRepository.class})
public class AssistenciaControllerTest {

    @Autowired
    AssistenciaController controller;

    @MockBean
    AssistenciaRepository repository;

    @MockBean
    ServicosRepository servicosRepository;

    @Test
    void buscaAssistenciaPorId_idInvalido_404(){
        assertEquals(404, controller.buscaAssistenciaPorId(1l).getStatusCodeValue());
    }
}
