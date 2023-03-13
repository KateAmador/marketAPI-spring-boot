package com.udev.marketapi.productos.controller;

import com.udev.marketapi.productos.dto.ProductoDTO;
import com.udev.marketapi.productos.model.Producto;
import com.udev.marketapi.productos.service.ProductoServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public List<Producto> listarProducto(){
        return  this.productoServicio.listarProducto();
    }

    @GetMapping("/{id}")
    public Optional<Producto> buscarProducto(@PathVariable("id") Long id){
        return this.productoServicio.buscarProducto(id);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable("id") Long id, @RequestBody ProductoDTO productoDTO){
        return this.productoServicio.actualizarProducto(id, productoDTO);
    }

    @PatchMapping("/desactivar/{id}")
    public ResponseEntity<Void> actualizarEstadoUsuario(@PathVariable("id") Long id){
        this.productoServicio.actualizarEstadoProducto(id);
        return ResponseEntity.noContent().build();
    }
}
