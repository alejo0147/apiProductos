package com.prueba.tecnica.productos.models.services;

import com.prueba.tecnica.productos.models.dao.IProductoDao;
import com.prueba.tecnica.productos.models.entities.ProductoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private IProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<ProductoEntity> findAll() {
        return (List<ProductoEntity>) productoDao.findAll();
    }

    @Override
    public ProductoEntity findById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    public ProductoEntity save(ProductoEntity producto) {
        return productoDao.save(producto);
    }
}
