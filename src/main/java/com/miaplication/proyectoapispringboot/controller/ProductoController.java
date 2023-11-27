package com.miaplication.proyectoapispringboot.controller;

import com.miaplication.proyectoapispringboot.model.Producto;
import com.miaplication.proyectoapispringboot.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    IProductoService produServ;
    
    @PostMapping("/productos/crear")
    public String saveProducto (@RequestBody Producto product){
        produServ.saveProducto(product);
        return "Producto creado exitosamente!";
    }
    
    @GetMapping("/productos")
    public List<Producto> listProductos(){
        return produServ.listProducto();
    }
    
    @GetMapping("/productos/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto){
        return produServ.findProducto(codigo_producto);
    }
    
    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto editProducto(@PathVariable Long codigo_producto,
                                   @RequestBody Producto product){
        this.saveProducto(product);
        return produServ.findProducto(codigo_producto);
    }
    
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto (@PathVariable Long codigo_producto){
        produServ.deleteProducto(codigo_producto);
        return "Producto eliminado exitosamente!";
    }
    
    @GetMapping("productos/falta_stock")
    public List<Producto> faltaStockProducto(){
        return produServ.listStock5Producto();
    }
    
    
}
