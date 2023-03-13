package com.udev.marketapi.usuarios.repository;

import com.udev.marketapi.usuarios.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
