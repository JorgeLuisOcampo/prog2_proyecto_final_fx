package co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.service;

import co.edu.uniquindio.billetera_virtual.billetera_virtual_fx.mapping.dto.CategoriaDto;

import java.util.ArrayList;

public interface CategoriaObserver {
    void onCategoriaListChanged(ArrayList<CategoriaDto> nuevaCategoria);
}
