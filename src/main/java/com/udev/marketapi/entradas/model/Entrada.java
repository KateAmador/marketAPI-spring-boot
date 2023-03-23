package com.udev.marketapi.entradas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.udev.marketapi.productos.model.Producto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "entradas")
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //foranea proveedor
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "producto_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Producto producto;
    private int cantidad;
    private int costo;
    private int total;
    private LocalDateTime fecha;
}
