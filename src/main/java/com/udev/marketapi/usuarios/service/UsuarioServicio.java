package com.udev.marketapi.usuarios.service;

import com.udev.marketapi.usuarios.dto.UsuarioDTO;
import com.udev.marketapi.usuarios.mapper.UsuarioDTOAUsuriao;
import com.udev.marketapi.usuarios.modelo.Usuario;
import com.udev.marketapi.usuarios.repository.UsuarioRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    private final UsuarioRepositorio repositorio;
    private final UsuarioDTOAUsuriao mapper;

    public UsuarioServicio(UsuarioRepositorio repositorio, UsuarioDTOAUsuriao mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public Usuario crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = mapper.map(usuarioDTO);
        return this.repositorio.save(usuario);
    }

    public List<Usuario> listarUsuarios(){
        return this.repositorio.findAll();
    }

    public Optional<Usuario> buscarUsuario(Long id) {
        return repositorio.findById(id);
    }

    public Usuario actualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = repositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setContraseña(usuarioDTO.getContraseña());
        return repositorio.save(usuario);
    }
}
