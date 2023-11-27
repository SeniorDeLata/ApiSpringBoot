
package com.miaplication.proyectoapispringboot.service;

import com.miaplication.proyectoapispringboot.model.Cliente;
import com.miaplication.proyectoapispringboot.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    IClienteRepository cliRepo;
    
    @Override
    public void saveCliente(Cliente client) {
        cliRepo.save(client);
    }

    @Override
    public void deleteCliente(Long id) {
        cliRepo.deleteById(id);
    }

    @Override
    public void editCliente(Cliente client) {
        this.saveCliente(client);
    }

    @Override
    public Cliente findCliente(Long id) {
        return cliRepo.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> listCliente() {
        return cliRepo.findAll();
    }
    
}
