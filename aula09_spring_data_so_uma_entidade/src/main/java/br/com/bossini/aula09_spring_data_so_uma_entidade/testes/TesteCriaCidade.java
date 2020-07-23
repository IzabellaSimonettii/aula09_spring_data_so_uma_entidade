package br.com.bossini.aula09_spring_data_so_uma_entidade.testes;

import br.com.bossini.aula09_spring_data_so_uma_entidade.model.Cidade;
import br.com.bossini.aula09_spring_data_so_uma_entidade.repository.CidadeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TesteCriaCidade {
    private CidadeRepository cidadeRepository;

    @Test
    public void testInsertCidade() {
        Cidade cidade = new Cidade();
        cidade.setId((long) 12345);
        cidade.setNome("Sao Paulo");
        cidade.setLatitude("40.7143528");
        cidade.setLongitude("-74.0059731");
        cidade = cidadeRepository.save(cidade);
        System.out.println(cidade.getId());
    }
}

