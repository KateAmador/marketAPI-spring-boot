package com.udev.marketapi.entradas.dto;

import com.udev.marketapi.productos.model.Producto;
import lombok.Data;

@Data
public class EntradaDTO {
    private int cantidad;
    private int costo;
    private Producto producto;
}
