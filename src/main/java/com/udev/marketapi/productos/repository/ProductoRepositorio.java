package com.udev.marketapi.productos.repository;

import com.udev.marketapi.productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

}
