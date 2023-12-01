package com.prueba.tecnica.productos.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PRODUCTOS")
public class ProductoEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPRODUCTO")
    private Long idProducto;

    @Column(name = "NOMBREPRODUCTO")
    private String nombreProducto;

    @Column(name = "PRECIO")
    private BigDecimal precio;

}
