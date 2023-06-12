package br.com.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.model.Cliente;
import br.com.projeto.api.model.Pessoa;
import br.com.projeto.api.repository.Repositorio;
import br.com.projeto.api.services.Servico;
import jakarta.validation.Valid;

@RestController
public class Controller {

    @Autowired
    private Repositorio acao;

    @Autowired
    private Servico servico;

    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa p) {
        return servico.cadastrar(p);
    }

    @GetMapping("/api")
    public ResponseEntity<?> selecionar() {
        return servico.selecionar();
    }

    @GetMapping("/api/{codigo}")
    public ResponseEntity<?> selecionarPeloCodigo(@PathVariable int codigo) {
        return servico.selecionarPeloCodigo(codigo);
    }

    @DeleteMapping("/api/{codigo}")
    public ResponseEntity<?> remover(@PathVariable int codigo) {
        return servico.remover(codigo);
    }

    @PutMapping("/api")
    public ResponseEntity<?> editar(@RequestBody Pessoa p) {
        return servico.editar(p);
    }

    @GetMapping("/api/contador")
    public long contador() {
        return acao.count();
    }

    @GetMapping("/api/ordenarNomes")
    public List<Pessoa> ordenarPessoas() {
        return acao.findByOrderByNome();
    }

    @GetMapping("/api/ordenarNomes2")
    public List<Pessoa> ordenarNomes() {
        return acao.findByNomeOrderByIdadeDesc("Tatiana");
    }

    @GetMapping("/api/nomeContem")
    public List<Pessoa> nomeContem() {
        return acao.findByNomeContaining("ana");
    }

    @GetMapping("/api/iniciaCom")
    public List<Pessoa> iniciaCom() {
        return acao.findByNomeStartsWith("a");
    }

    @GetMapping("/api/terminaCom")
    public List<Pessoa> terminaCom() {
        return acao.findByNomeEndsWith("a");
    }

    @GetMapping("/api/somaIdades")
    public int somaIdades() {
        return acao.somaIdades();
    }

    @GetMapping("/api/idadeMaiorIgual")
    public List<Pessoa> idadeMaiorIgual() {
        return acao.idadeMaiorIgual(40);
    }

    @GetMapping("/")
    public String mensagem() {
        return "Hello World!";
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Seja bem vindo(a)!";
    }

    @GetMapping("/boasvindas/{nome}")
    public String boasVindas(@PathVariable String nome) {
        return "Seja bem vindo(a), " + nome + "!";
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p) {
        return p;
    }

    @GetMapping("/status")
    public ResponseEntity<?> status() {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/cliente")
    public void cliente(@Valid @RequestBody Cliente obj){

    }
}
