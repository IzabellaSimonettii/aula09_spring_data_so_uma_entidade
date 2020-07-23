package br.com.bossini.aula09_spring_data_so_uma_entidade.repository;


import br.com.bossini.aula09_spring_data_so_uma_entidade.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> buscaPorCidadaeIgnoreCase(String letra);

    List<Cidade> findAll();

    List<Cidade> buscaPorNome(String letra);

    Cidade buscaPorCoordenadas(String latitude, String longitude);

    Cidade save(Cidade cidade);

}

//    Exercicio - Buscar cidade pelo seu nome.

//    Buscar cidade por latitude e longitude.

//    uscar cidades pelo seu nome, ignorando letras maiúsculas.
//    Pesquise para descobrir como se usa IgnoreCase.


