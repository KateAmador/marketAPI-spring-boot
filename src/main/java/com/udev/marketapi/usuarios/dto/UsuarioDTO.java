package com.udev.marketapi.usuarios.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String contraseña;
}
