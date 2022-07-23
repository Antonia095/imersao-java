package br.com.imersao.controller;

import br.com.imersao.model.Linguagem;
import br.com.imersao.repository.LinguagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LinguagemController {

    @Autowired
    private LinguagemRepository linguagemRepository;

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = linguagemRepository.findAll();
        return linguagens;
    }

    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem linguagemSalva = linguagemRepository.save(linguagem);
        return linguagemSalva;
    }

    @DeleteMapping
    public void deletarLinguagem(Linguagem linguagem){
        linguagemRepository.delete(linguagem);
    }

}
