package com.udev.marketapi.entradas.controller;

import com.udev.marketapi.entradas.dto.EntradaDTO;
import com.udev.marketapi.entradas.model.Entrada;
import com.udev.marketapi.entradas.service.EntradaServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entradas")
public class EntradaControlador {

    private EntradaServicio entradaServicio;

    public EntradaControlador(EntradaServicio entradaServicio) {
        this.entradaServicio = entradaServicio;
    }

    @PostMapping
    public Entrada crearEntrada(@RequestBody EntradaDTO entradaDTO) {
        return this.entradaServicio.crearEntrada(entradaDTO);
    }
    @GetMapping
    public List<Entrada> listarEntrada(){
        return this.entradaServicio.listarEntrada();
    }

    @GetMapping("/{id}")
    public Optional<Entrada> buscarEntrada(@PathVariable("id") Long id){
        return this.entradaServicio.buscarEntrada(id);
    }

    @PutMapping("/{id}")
    public Entrada actualizarEntrada(@PathVariable("id") Long id, @RequestBody EntradaDTO entradaDTO){
        return this.entradaServicio.actualizarEntrada(id, entradaDTO);
    }
}
