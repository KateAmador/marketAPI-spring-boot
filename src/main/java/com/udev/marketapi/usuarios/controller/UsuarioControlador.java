package com.udev.marketapi.usuarios.controller;

import com.udev.marketapi.usuarios.dto.UsuarioDTO;
import com.udev.marketapi.usuarios.modelo.Usuario;
import com.udev.marketapi.usuarios.service.UsuarioServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return this.usuarioServicio.crearUsuario(usuarioDTO);
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return this.usuarioServicio.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> buscarPorId(@PathVariable("id") Long id) {
        return this.usuarioServicio.buscarUsuario(id);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable("id") Long id, @RequestBody UsuarioDTO usuarioDTO) {
        return this.usuarioServicio.actualizarUsuario(id, usuarioDTO);
    }
}
