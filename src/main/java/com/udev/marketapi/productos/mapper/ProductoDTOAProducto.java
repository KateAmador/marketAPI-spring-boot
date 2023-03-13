package com.udev.marketapi.productos.mapper;

import com.udev.marketapi.productos.dto.ProductoDTO;
import com.udev.marketapi.productos.model.Producto;
import com.udev.marketapi.util.IMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductoDTOAProducto implements IMapper<ProductoDTO, Producto> {

    @Override
    public Producto map(ProductoDTO in) {
        Producto producto = new Producto();
        producto.setNombre(in.getNombre());
        producto.setCosto(in.getCosto());
        producto.setPrecio(in.getPrecio());
        producto.setObservacion(in.getObservacion());
        producto.setEstadoProducto(true);
        producto.setCantidad(in.getCantidad());
        //producto.setImagen(in.getImagen());
        producto.setCaracteristicas(in.getCaracteristicas());
        producto.setDescuento(in.getDescuento());
        producto.setDescripcion(in.getDescripcion());
        return producto;
    }
}
