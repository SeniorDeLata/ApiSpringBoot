package com.miaplication.proyectoapispringboot.service;

import com.miaplication.proyectoapispringboot.model.Producto;
import java.util.List;

public interface IProductoService {
    //Dar de alta un Producto
    public void saveProducto (Producto product);
    
    //Dar de baja un Producto
    public void deleteProducto(Long id);
    
    //Modificar un Producto
    public void editProducto(Producto product);
    
    //Buscar un Producto
    public Producto findProducto(Long id);
    
    //Listar los Productos
    public List<Producto> listProducto();
    
    //Listar productos con Stock inferior a 5
    public List<Producto> listStock5Producto();
    
}
