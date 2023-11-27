package com.miaplication.proyectoapispringboot.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentasCantDTO implements Serializable{
    private double monto;
    private int ventasCant;

    public VentasCantDTO() {
    }

    public VentasCantDTO(double monto, int ventasCant) {
        this.monto = monto;
        this.ventasCant = ventasCant;
    }
    
    
}
