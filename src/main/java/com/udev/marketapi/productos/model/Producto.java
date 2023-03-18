package com.udev.marketapi.productos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.udev.marketapi.categorias.model.Categoria;
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoria_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Categoria categoria;
    private String nombre;
    private int costo;
    private int precio;
    private String observacion;
    private boolean estado;
    private int cantidad;
    @Lob
    private byte[] imagen;
    private String caracteristicas;
    private int descuento;
    private String descripcion;
}
