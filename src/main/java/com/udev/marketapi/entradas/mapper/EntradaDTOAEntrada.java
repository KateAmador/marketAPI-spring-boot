package com.udev.marketapi.entradas.mapper;

import com.udev.marketapi.entradas.dto.EntradaDTO;
import com.udev.marketapi.entradas.model.Entrada;
import com.udev.marketapi.util.IMapper;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class EntradaDTOAEntrada implements IMapper<EntradaDTO, Entrada> {
    @Override
    public Entrada map(EntradaDTO in) {
        Entrada entrada = new Entrada();
        entrada.setProducto(in.getProducto());
        entrada.setCantidad(in.getCantidad());
        entrada.setCosto(in.getCosto());
        entrada.setTotal(in.getCantidad() * in.getCosto());
        entrada.setFecha(LocalDateTime.now());
        return entrada;
    }
}
