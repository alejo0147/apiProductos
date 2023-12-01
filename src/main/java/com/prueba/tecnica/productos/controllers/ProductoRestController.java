package com.prueba.tecnica.productos.controllers;

import com.prueba.tecnica.productos.models.entities.ProductoEntity;
import com.prueba.tecnica.productos.models.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoRestController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public List<ProductoEntity> index(){
        return productoService.findAll();
    }

    @GetMapping("/productos/{id}")
    public ProductoEntity show(@PathVariable Long id){
        return productoService.findById(id);
    }

    @PostMapping("/productos")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoEntity create(@RequestBody ProductoEntity producto){
        return productoService.save(producto);
    }

    @PutMapping("/productos/{id}")
    public ProductoEntity update(@RequestBody ProductoEntity producto, @PathVariable Long id){
        ProductoEntity productoActual = productoService.findById(id);

        productoActual.setNombreProducto(producto.getNombreProducto());
        productoActual.setPrecio(producto.getPrecio());

        return productoService.save(productoActual);

    }
}
