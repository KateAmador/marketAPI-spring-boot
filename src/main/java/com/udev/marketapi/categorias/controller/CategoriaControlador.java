package com.udev.marketapi.categorias.controller;

import com.udev.marketapi.categorias.dto.CategoriaDTO;
import com.udev.marketapi.categorias.model.Categoria;
import com.udev.marketapi.categorias.service.CategoriaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaControlador {

    private CategoriaServicio categoriaServicio;

    public CategoriaControlador(CategoriaServicio categoriaServicio) {
        this.categoriaServicio = categoriaServicio;
    }

    @PostMapping
    public Categoria crearCategoria(@RequestBody CategoriaDTO categoriaDTO){
        return this.categoriaServicio.crearCategoria(categoriaDTO);
    }

    @GetMapping
    public List<Categoria> listarCategoria(){
        return this.categoriaServicio.listarCategoria();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> buscarCategoria(@PathVariable("id") Long id){
        return this.categoriaServicio.buscarCategoria(id);
    }

    @PutMapping("/{id}")
    public Categoria actualizarCategoria(@PathVariable("id") Long id, @RequestBody CategoriaDTO categoriaDTO){
        return this.categoriaServicio.actualizarCategoria(id, categoriaDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> desactivar(@PathVariable("id") Long id){
        this.categoriaServicio.actualizarEstadoCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
