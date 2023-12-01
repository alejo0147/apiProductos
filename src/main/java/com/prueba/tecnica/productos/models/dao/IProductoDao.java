package com.prueba.tecnica.productos.models.dao;

import com.prueba.tecnica.productos.models.entities.ProductoEntity;
import org.springframework.data.repository.CrudRepository;

public interface IProductoDao extends CrudRepository<ProductoEntity, Long> {

}
