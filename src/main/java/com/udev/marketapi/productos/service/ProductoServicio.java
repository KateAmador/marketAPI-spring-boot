package com.udev.marketapi.productos.service;

import com.udev.marketapi.productos.dto.ProductoDTO;
import com.udev.marketapi.productos.mapper.ProductoDTOAProducto;
import com.udev.marketapi.productos.model.Producto;
import com.udev.marketapi.productos.repository.ProductoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {

    private ProductoRepositorio repositorio;
    private ProductoDTOAProducto mapper;

    public ProductoServicio(ProductoRepositorio repositorio, ProductoDTOAProducto mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public Producto crearProducto(ProductoDTO productoDTO){
        Producto producto = mapper.map(productoDTO);
        return this.repositorio.save(producto);
    }

    public List<Producto> listarProducto(){
        return this.repositorio.findAll();
    }

    public Optional<Producto> buscarProducto(Long id){
        return this.repositorio.findById(id);
    }

    public Producto actualizarProducto(Long id, ProductoDTO productoDTO){
        Producto producto = repositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        producto.setNombre(productoDTO.getNombre());
        producto.setCosto(productoDTO.getCosto());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setObservacion(productoDTO.getObservacion());
        producto.setCantidad(producto.getCantidad());
        producto.setCaracteristicas(producto.getCaracteristicas());
        producto.setDescuento(productoDTO.getDescuento());
        producto.setDescripcion(producto.getDescripcion());
        return repositorio.save(producto);
    }
}
