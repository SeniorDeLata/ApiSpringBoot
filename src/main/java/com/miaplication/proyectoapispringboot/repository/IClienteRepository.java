package com.miaplication.proyectoapispringboot.repository;

import com.miaplication.proyectoapispringboot.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long>{
    
}
