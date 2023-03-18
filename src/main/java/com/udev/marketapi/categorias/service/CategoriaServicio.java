package com.udev.marketapi.categorias.service;

import com.udev.marketapi.categorias.dto.CategoriaDTO;
import com.udev.marketapi.categorias.mapper.CategoriaDTOACategoria;
import com.udev.marketapi.categorias.model.Categoria;
import com.udev.marketapi.categorias.repository.CategoriaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicio {

    private CategoriaRepositorio repositorio;
    private CategoriaDTOACategoria mapper;

    public CategoriaServicio(CategoriaRepositorio repositorio, CategoriaDTOACategoria mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public Categoria crearCategoria(CategoriaDTO categoriaDTO){
        Categoria categoria = this.mapper.map(categoriaDTO);
        return this.repositorio.save(categoria);
    }

    public List<Categoria> listarCategoria(){
        return this.repositorio.findAll();
    }

    public Optional<Categoria> buscarCategoria(Long id){
        return this.repositorio.findById(id);
    }

    public Categoria actualizarCategoria(Long id, CategoriaDTO categoriaDTO){
        Categoria categoria = this.repositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        categoria.setNombre(categoriaDTO.getNombre());
        categoria.setDescripcion(categoriaDTO.getDescripcion());
        return this.repositorio.save(categoria);
    }

    @Transactional
    public void actualizarEstadoCategoria(Long id){
        Optional<Categoria> optionalCategoria = this.repositorio.findById(id);
        this.repositorio.categoriaDesactivado(id);
    }
}
