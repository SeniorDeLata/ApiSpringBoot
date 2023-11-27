package com.miaplication.proyectoapispringboot.service;

import com.miaplication.proyectoapispringboot.dto.VentaClienteDTO;
import com.miaplication.proyectoapispringboot.dto.VentasCantDTO;
import com.miaplication.proyectoapispringboot.model.Producto;
import com.miaplication.proyectoapispringboot.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    //Dar de alta una Venta
    public void saveVenta (Venta vent);
    
    //Dar de baja una Venta
    public void deleteVenta(Long id);
    
    //Modificar una Venta
    public void editPVenta(Venta vent);
    
    //Buscar una Venta
    public Venta findVenta(Long id);
    
    //Listar las Ventas
    public List<Venta> listVenta();
    
    //Listar Productos de una Venta
    public List<Producto> listProductoVenta(Long id);
    
    //Devuelve el monto total y las ventas realizadas en un determinado dia
    public VentasCantDTO montoCantidadVenta(LocalDate fecha);
    
    //Retorno Datos de la Venta con el Mayor Monto
    public VentaClienteDTO mayorVenta();
}
