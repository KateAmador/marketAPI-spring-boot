package com.udev.marketapi.entradas.service;

import com.udev.marketapi.entradas.dto.EntradaDTO;
import com.udev.marketapi.entradas.mapper.EntradaDTOAEntrada;
import com.udev.marketapi.entradas.model.Entrada;
import com.udev.marketapi.entradas.repository.EntradaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaServicio {

    private EntradaRepositorio repositorio;
    private EntradaDTOAEntrada mapper;

    public EntradaServicio(EntradaRepositorio repositorio, EntradaDTOAEntrada mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public Entrada crearEntrada(EntradaDTO entradaDTO) {
        Entrada entrada = mapper.map(entradaDTO);
        return this.repositorio.save(entrada);
    }

    public List<Entrada> listarEntrada(){
        return this.repositorio.findAll();
    }

    public Optional<Entrada> buscarEntrada(Long id){
        return this.repositorio.findById(id);
    }

    public Entrada actualizarEntrada(Long id, EntradaDTO entradaDTO){
        Entrada entrada = this.repositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        entrada.setCantidad(entradaDTO.getCantidad());
        entrada.setCosto(entradaDTO.getCosto());
        entrada.setProducto(entradaDTO.getProducto());
        entrada.setTotal(entradaDTO.getCosto() * entrada.getCantidad());
        return this.repositorio.save(entrada);
    }
}
