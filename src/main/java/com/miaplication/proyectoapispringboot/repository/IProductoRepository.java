package com.miaplication.proyectoapispringboot.repository;

import com.miaplication.proyectoapispringboot.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long>{
    
}
