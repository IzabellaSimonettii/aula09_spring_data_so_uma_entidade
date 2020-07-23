package br.com.bossini.aula09_spring_data_so_uma_entidade.controller;

import br.com.bossini.aula09_spring_data_so_uma_entidade.model.Cidade;
import br.com.bossini.aula09_spring_data_so_uma_entidade.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cidades")
class CidadeResource {

    @Autowired
    private CidadeRepository cidadeRepositorio;

    @GetMapping("/listaTodas")
    public List<Cidade> todasCidades() {
        return cidadeRepositorio.findAll();
    }

    @GetMapping("/{letra}")
    public List<Cidade> peloNome(@PathVariable String letra) {
        return cidadeRepositorio.buscaPorNome(letra);
    }

    @GetMapping("/{latitude}/{longitude}")
    public Cidade porCoordenadas(@PathVariable String latitude, @PathVariable String longitude) {
        return cidadeRepositorio.buscaPorCoordenadas(latitude, longitude);
    }

    @GetMapping("/{letra}")
    public List<Cidade> buscaCidadeIgnoreCase(@PathVariable String letra) {
        return cidadeRepositorio.buscaPorCidadaeIgnoreCase(letra);
    }


    @PostMapping("/salvar")
    public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade, HttpServletResponse response) {
        try {
            Cidade cidadeCadastro = cidadeRepositorio.save(cidade);
            URI uri = ServletUriComponentsBuilder.
                    fromCurrentServletMapping().path("/{id}").
                    buildAndExpand(cidadeCadastro.getId()).toUri();
            return ResponseEntity.created(uri).body(cidadeCadastro);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

