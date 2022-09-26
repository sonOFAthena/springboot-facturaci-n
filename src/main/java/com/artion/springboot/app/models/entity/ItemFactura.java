package com.artion.springboot.app.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "facturas_items")
public class ItemFactura implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  Long id;

    private Integer cantidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long calcularImporte(){
        return cantidad.longValue();
    }



    private static final long serialVersionUID = 1L;


}
