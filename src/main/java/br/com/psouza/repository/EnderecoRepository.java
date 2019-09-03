package br.com.psouza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.psouza.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
