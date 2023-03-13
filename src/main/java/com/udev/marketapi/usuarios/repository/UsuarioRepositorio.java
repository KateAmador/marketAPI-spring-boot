package com.udev.marketapi.usuarios.repository;

import com.udev.marketapi.usuarios.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    @Modifying
    @Query(value = "UPDATE usuarios SET estado_usuario = FALSE WHERE ID=:id", nativeQuery = true)
    void usuarioDesactivado(@Param("id")Long id);
}
