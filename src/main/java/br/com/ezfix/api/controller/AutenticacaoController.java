package br.com.ezfix.api.controller;

import br.com.ezfix.api.config.security.TokenService;
import br.com.ezfix.api.controller.form.LoginForm;
import br.com.ezfix.api.controller.vo.TokenVo;
import br.com.ezfix.api.controller.vo.UsuarioVo;
import br.com.ezfix.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController extends baseController{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<TokenVo> autenticar(@RequestBody @Valid LoginForm loginForm){
        try {
            Authentication authentication = authenticationManager.authenticate(loginForm.converter());
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenVo(token,"Bearer"));
        }catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    @Override
    public Page<UsuarioVo> buscarTodos(@PageableDefault(page = 0,size = 1) Pageable paginacao) {
        return UsuarioVo.converter(usuarioRepository.findAll(paginacao));
    }
}
