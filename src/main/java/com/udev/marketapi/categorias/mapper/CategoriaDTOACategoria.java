package com.udev.marketapi.categorias.mapper;

import com.udev.marketapi.categorias.dto.CategoriaDTO;
import com.udev.marketapi.categorias.model.Categoria;
import com.udev.marketapi.util.IMapper;
import org.springframework.stereotype.Component;
@Component
public class CategoriaDTOACategoria implements IMapper<CategoriaDTO, Categoria> {
    @Override
    public Categoria map(CategoriaDTO in) {
        Categoria categoria = new Categoria();
        categoria.setNombre(in.getNombre());
        categoria.setEstado(true);
        categoria.setDescripcion(in.getDescripcion());
        return categoria;
    }
}
