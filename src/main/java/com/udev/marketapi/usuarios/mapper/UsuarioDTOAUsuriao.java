package com.udev.marketapi.usuarios.mapper;

import com.udev.marketapi.usuarios.dto.UsuarioDTO;
import com.udev.marketapi.usuarios.modelo.TipoUsuarios;
import com.udev.marketapi.usuarios.modelo.Usuario;
import com.udev.marketapi.util.IMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UsuarioDTOAUsuriao implements IMapper<UsuarioDTO, Usuario> {

    @Override
    public Usuario map(UsuarioDTO in) {
        Usuario usuario = new Usuario();
        usuario.setNombre(in.getNombre());
        usuario.setApellido(in.getApellido());
        usuario.setTelefono(in.getTelefono());
        usuario.setEmail(in.getEmail());
        usuario.setContraseña(in.getContraseña());
        usuario.setTipoUsuario(TipoUsuarios.CLIENTE);
        usuario.setEstado(true);
        //usuario.setUltimoIngreso(String.valueOf(new Date()));
        usuario.setFechaRegistro(LocalDateTime.now());
        return usuario;
    }
}
