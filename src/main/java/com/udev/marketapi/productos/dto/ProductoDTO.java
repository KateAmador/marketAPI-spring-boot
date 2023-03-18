package com.udev.marketapi.productos.dto;

import com.udev.marketapi.categorias.model.Categoria;
import lombok.Data;

@Data
public class ProductoDTO {

    private String nombre;
    private int costo;
    private int precio;
    private String observacion;
    private int cantidad;
    //@Lob
    //private byte[] imagen;
    private String caracteristicas;
    private int descuento;
    private String descripcion;
    private Categoria categoria;
}
