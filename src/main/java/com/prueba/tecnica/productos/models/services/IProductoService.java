package com.prueba.tecnica.productos.models.services;

import com.prueba.tecnica.productos.models.entities.ProductoEntity;

import java.util.List;

public interface IProductoService {

    public List<ProductoEntity> findAll();

    public ProductoEntity findById(Long id);

    public ProductoEntity save(ProductoEntity producto);

}
