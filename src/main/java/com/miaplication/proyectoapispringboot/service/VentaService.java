package com.miaplication.proyectoapispringboot.service;

import com.miaplication.proyectoapispringboot.dto.VentaClienteDTO;
import com.miaplication.proyectoapispringboot.dto.VentasCantDTO;
import com.miaplication.proyectoapispringboot.model.Producto;
import com.miaplication.proyectoapispringboot.model.Venta;
import com.miaplication.proyectoapispringboot.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {
    
    @Autowired
    IVentaRepository ventaRepo;
    
    @Override
    public void saveVenta(Venta vent) {
        ventaRepo.save(vent);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    public void editPVenta(Venta vent) {
        this.saveVenta(vent);
    }

    @Override
    public Venta findVenta(Long id) {
        return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Venta> listVenta() {
        return ventaRepo.findAll();
    }

    @Override
    public List<Producto> listProductoVenta(Long id) {
        return this.findVenta(id).getListaProductos();
    }

    @Override
    public VentasCantDTO montoCantidadVenta(LocalDate fecha) {
        VentasCantDTO cantDTO = new VentasCantDTO();
        int cantVentas = 0;
        double montoTotal = 0.0;
        for (Venta venta : this.listVenta()) {
            if(venta.getFecha_venta().equals(fecha)){
                cantVentas= cantVentas+1;
                montoTotal= montoTotal+venta.getTotal();
            }
        }
        cantDTO.setMonto(montoTotal);
        cantDTO.setVentasCant(cantVentas);
        return cantDTO;
    }

    @Override
    public VentaClienteDTO mayorVenta() {
        VentaClienteDTO ventaDTO = new VentaClienteDTO();
        Venta ven = new Venta();
        ven.setTotal(0.0);
        for (Venta venta : this.listVenta()) {
            if(venta.getTotal()>ven.getTotal()){
                ven=venta;
            }
        }
        ventaDTO.setCodigo_venta(ven.getCodigo_venta());
        ventaDTO.setTotal(ven.getTotal());
        ventaDTO.setCantidad_productos(ven.getListaProductos().size());
        ventaDTO.setNombre_cliente(ven.getUnCliente().getNombre());
        ventaDTO.setApellido_cliente(ven.getUnCliente().getApellido());
        return ventaDTO;
        
    }
    
}
