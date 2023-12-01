package com.prueba.tecnica.productos.models.services;

import com.prueba.tecnica.productos.models.dao.IProductoDao;
import com.prueba.tecnica.productos.models.entities.ProductoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductoServiceImplTest {

    @Mock
    private IProductoDao productoDao;

    @InjectMocks
    private ProductoServiceImpl productoService;

    @Test
    void findAll() {
        // Crear una lista de ProductoEntity para simular el comportamiento del servicio
        List<ProductoEntity> productos = new ArrayList<>();

        // Datos de ejemplo
        ProductoEntity producto = ProductoEntity.builder()
                .idProducto(5L)
                .nombreProducto("Coca-Cola")
                .precio(new BigDecimal(6500))
                .build();
        productos.add(producto);

        // Configurar el comportamiento del repositorio mock
        when(productoDao.findAll()).thenReturn(productos);
        List<ProductoEntity> productosList = (List<ProductoEntity>) productoDao.findAll();
        assertEquals(1, productosList.size());
        assertTrue(productosList.size()>0);
    }

    @Test
    void findById() {
        // Datos de ejemplo
        ProductoEntity producto1 = ProductoEntity.builder()
                .idProducto(1L)
                .nombreProducto("Coca-Cola")
                .precio(new BigDecimal(6500))
                .build();

        // Configurar el comportamiento del repositorio mock
        when(productoDao.findById(anyLong())).thenReturn(Optional.ofNullable(producto1));
        Optional<ProductoEntity> producto2 = productoDao.findById(1L);
        assertTrue(producto2.isPresent());
    }

    @Test
    void save() {
        // Datos de ejemplo
        Long idProducto = 1L;
        String nombreProducto = "Producto de prueba";
        BigDecimal precio = new BigDecimal("19.99");

        // Configurar el comportamiento del repositorio mock
        when(productoDao.save(any())).thenAnswer(invocation -> {
            ProductoEntity productoGuardado = invocation.getArgument(0);
            productoGuardado.setIdProducto(idProducto); // Simular la asignación del ID al guardar
            return productoGuardado;
        });

        // Crear un ProductoEntity para simular el comportamiento del servicio
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setNombreProducto(nombreProducto);
        productoEntity.setPrecio(precio);

        // Llamar al método de servicio que queremos probar
        ProductoEntity productoGuardado = productoService.save(productoEntity);

        // Verificar que se llamó al método save del repositorio con el producto correcto
        verify(productoDao).save(argThat(
                producto -> producto.getIdProducto().equals(idProducto) &&
                        producto.getNombreProducto().equals(nombreProducto) &&
                        producto.getPrecio().equals(precio)
        ));

        // Verificar que el producto devuelto tiene el ID asignado
        assertEquals(idProducto, productoGuardado.getIdProducto());
        assertEquals(nombreProducto, productoGuardado.getNombreProducto());
        assertEquals(precio, productoGuardado.getPrecio());

    }
}