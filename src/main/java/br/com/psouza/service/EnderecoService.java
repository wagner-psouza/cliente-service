package br.com.psouza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.psouza.entity.Endereco;
import br.com.psouza.repository.EnderecoRepository;

@Service
public class EnderecoService extends GenericService<Endereco> {

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        super(enderecoRepository);
    }

}
