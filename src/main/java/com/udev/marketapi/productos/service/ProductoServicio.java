package com.udev.marketapi.productos.service;

import com.udev.marketapi.productos.dto.ProductoDTO;
import com.udev.marketapi.productos.mapper.ProductoDTOAProducto;
import com.udev.marketapi.productos.model.Producto;
import com.udev.marketapi.productos.repository.ProductoRepositorio;
import org.springframework.stereotype.Service;

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
}
