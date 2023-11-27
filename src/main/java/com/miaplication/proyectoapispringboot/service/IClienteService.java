package com.miaplication.proyectoapispringboot.service;

import com.miaplication.proyectoapispringboot.model.Cliente;
import java.util.List;

public interface IClienteService {
    //Dar de alta un Cliente
    public void saveCliente (Cliente client);
    
    //Dar de baja un Cliente
    public void deleteCliente(Long id);
    
    //Modificar un Cliente
    public void editCliente(Cliente client);
    
    //Buscar un Cliente
    public Cliente findCliente(Long id);
    
    //Listar los Clientes
    public List<Cliente> listCliente();
        
}
