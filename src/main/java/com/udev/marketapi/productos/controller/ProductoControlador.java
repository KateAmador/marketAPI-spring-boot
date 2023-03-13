package com.udev.marketapi.productos.controller;

import com.udev.marketapi.productos.dto.ProductoDTO;
import com.udev.marketapi.productos.model.Producto;
import com.udev.marketapi.productos.service.ProductoServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {

    private final ProductoServicio productoServicio;

    public ProductoControlador(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @PostMapping
    public Producto crearProducto(@RequestBody ProductoDTO productoDTO){
        return this.productoServicio.crearProducto(productoDTO);
    }
}
