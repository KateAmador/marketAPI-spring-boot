package com.udev.marketapi.productos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //foranea proveedor
    //foranea categoria
    private String nombre;
    private int costo;
    private int precio;
    private String observacion;
    private boolean estadoProducto;
    private int cantidad;
    @Lob
    private byte[] imagen;
    private String caracteristicas;
    private int descuento;
    private String descripcion;
}
