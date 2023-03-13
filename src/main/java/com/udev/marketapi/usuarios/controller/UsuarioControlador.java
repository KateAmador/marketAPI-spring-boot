package com.udev.marketapi.usuarios.controller;

import com.udev.marketapi.usuarios.dto.UsuarioDTO;
import com.udev.marketapi.usuarios.modelo.Usuario;
import com.udev.marketapi.usuarios.service.UsuarioServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
