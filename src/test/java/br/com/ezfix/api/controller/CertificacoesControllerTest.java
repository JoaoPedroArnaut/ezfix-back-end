package br.com.ezfix.api.controller;

import br.com.ezfix.api.controller.form.CertificacoesForm;
import br.com.ezfix.api.repository.AssistenciaRepository;
import br.com.ezfix.api.repository.CertificacoesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {CertificacoesController.class, CertificacoesRepository.class})
class CertificacoesControllerTest {

    @Autowired
    CertificacoesController controller;

    @MockBean
    CertificacoesRepository repository;

    @MockBean
    AssistenciaRepository assistenciaRepository;

//    @Test
//    void cadastrar_valido_201(){
//        assertEquals(201,controller.cadastrar(new CertificacoesForm(),1l).getStatusCodeValue());
//    }

    @Test
    void deletar_seIdInvalido_404(){
        assertEquals(404,controller.apagar(1l).getStatusCodeValue());
    }

//    @Test
//    void atualizar_invalido_404(){
//        assertEquals(404,controller.atualizar(1l, new CertificacoesForm()).getStatusCodeValue());
//    }

    @Test
    void buscaPorASssistencia_idInvalido_404(){
        assertEquals(404, controller.buscarPorAssistencia(1l).getStatusCodeValue());
    }


}