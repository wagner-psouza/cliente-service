package br.com.psouza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.psouza.entity.Cliente;
import br.com.psouza.repository.ClienteRepository;

@Service
public class ClienteService extends GenericService<Cliente> {

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        super(clienteRepository);
    }

}
