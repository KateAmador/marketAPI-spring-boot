package com.udev.marketapi.entradas.repository;

import com.udev.marketapi.categorias.model.Categoria;
import com.udev.marketapi.entradas.model.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaRepositorio extends JpaRepository<Entrada, Long> {
}
