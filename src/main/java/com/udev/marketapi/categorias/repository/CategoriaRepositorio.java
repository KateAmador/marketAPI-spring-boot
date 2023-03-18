package com.udev.marketapi.categorias.repository;

import com.udev.marketapi.categorias.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

    @Modifying
    @Query(value = "UPDATE categorias SET estado = FALSE WHERE ID=:id", nativeQuery = true)
    void categoriaDesactivado(@Param("id")Long id);
}
