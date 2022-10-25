package br.com.fiap.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.challenge.model.Loja;

public interface LojaRepository extends JpaRepository<Loja, Long>{

	//Pesquisar por parte do nome ignorando case sensitive
    List<Loja> findByNomeContainsIgnoreCase(String nome);

    List<Loja> deleteByNome(String nome);

}