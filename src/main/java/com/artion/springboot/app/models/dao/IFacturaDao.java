package com.artion.springboot.app.models.dao;

import com.artion.springboot.app.models.entity.Factura;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository<Factura, Long> {
}
