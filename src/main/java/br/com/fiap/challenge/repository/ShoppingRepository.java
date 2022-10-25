package br.com.fiap.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.challenge.model.Shopping;

public interface ShoppingRepository extends JpaRepository<Shopping, Long>{
}