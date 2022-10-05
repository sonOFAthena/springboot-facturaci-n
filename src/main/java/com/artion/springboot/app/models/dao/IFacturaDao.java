package com.artion.springboot.app.models.dao;

import com.artion.springboot.app.models.entity.Factura;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository<Factura, Long> {

    //este lenguaje es llamado jpql  (ORM)
    @Query("select f from Factura f join fetch f.cliente c join fetch f.items l join fetch l.producto where f.id = ?1")
    public Factura fetchByIdWithClienteWithItemFacturaWithProducto(Long id);
}
