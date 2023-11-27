package com.miaplication.proyectoapispringboot.controller;

import com.miaplication.proyectoapispringboot.dto.VentaClienteDTO;
import com.miaplication.proyectoapispringboot.dto.VentasCantDTO;
import com.miaplication.proyectoapispringboot.model.Producto;
import com.miaplication.proyectoapispringboot.model.Venta;
import com.miaplication.proyectoapispringboot.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    
    @Autowired
    IVentaService venServ;
    
    @PostMapping("/ventas/crear")
    public String saveVenta (@RequestBody Venta ven){
        venServ.saveVenta(ven);
        return "Venta creada exitosamente!";
    }
    
    @GetMapping("/ventas")
    public List<Venta> listVentas(){
        return venServ.listVenta();
    }
    
    @GetMapping("/ventas/buscar/{codigo_venta}")
    public Venta findVenta(@PathVariable Long codigo_venta){
        return venServ.findVenta(codigo_venta);
    }
    
    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editVenta(@PathVariable Long codigo_venta,
                                   @RequestBody Venta ven){
        this.saveVenta(ven);
        return venServ.findVenta(codigo_venta);
    }
    
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta (@PathVariable Long codigo_venta){
        venServ.deleteVenta(codigo_venta);
        return "Venta eliminada exitosamente!";
    }
    
    @GetMapping("/ventas/productos/codigo_venta")
    public List<Producto> listProductoVenta(@PathVariable Long codigo_venta){
        return venServ.listProductoVenta(codigo_venta);
    }
    
    @GetMapping("/ventas/fecha")
    public VentasCantDTO ventasCantFecha(@RequestParam LocalDate fecha){
        return venServ.montoCantidadVenta(fecha);
    }
    
    @GetMapping("ventas/mayor_venta")
    public VentaClienteDTO mayorVenta(){
        return venServ.mayorVenta();
    }
    
    
}
