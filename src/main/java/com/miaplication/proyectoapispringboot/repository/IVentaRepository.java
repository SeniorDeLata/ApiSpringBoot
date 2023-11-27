package com.miaplication.proyectoapispringboot.repository;

import com.miaplication.proyectoapispringboot.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long>{
    
}
