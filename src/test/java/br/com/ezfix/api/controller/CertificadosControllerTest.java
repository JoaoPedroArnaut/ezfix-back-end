package br.com.ezfix.api.controller;

import br.com.ezfix.api.repository.AssistenciaRepository;
import br.com.ezfix.api.repository.CertificadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {CertificadosController.class, CertificadoRepository.class})
class CertificadosControllerTest {

    @Autowired
    CertificadosController controller;

    @MockBean
    CertificadoRepository repository;

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


}