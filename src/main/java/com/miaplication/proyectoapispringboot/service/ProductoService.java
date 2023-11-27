package com.miaplication.proyectoapispringboot.service;

import com.miaplication.proyectoapispringboot.model.Producto;
import com.miaplication.proyectoapispringboot.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    IProductoRepository produRepo;
    
    @Override
    public void saveProducto(Producto product) {
        produRepo.save(product);
    }

    @Override
    public void deleteProducto(Long id) {
        produRepo.deleteById(id);
    }

    @Override
    public void editProducto(Producto product) {
        this.saveProducto(product);
    }

    @Override
    public Producto findProducto(Long id) {
        return produRepo.findById(id).orElse(null);
    }

    @Override
    public List<Producto> listProducto() {
        return produRepo.findAll();
    }

    @Override
    public List<Producto> listStock5Producto() {
        List<Producto> filtroList = new ArrayList<Producto>();
        for (Producto producto : this.listProducto()) {
            if(producto.getStock()<5){
                filtroList.add(producto);
            }
        }
        return filtroList;
    }
    
}
