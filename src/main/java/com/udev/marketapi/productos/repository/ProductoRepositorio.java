package com.udev.marketapi.productos.repository;

import com.udev.marketapi.productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

    @Modifying
    @Query(value = "UPDATE productos SET estado = FALSE WHERE ID=:id", nativeQuery = true)
    void productoDesactivado(@Param("id")Long id);
}
