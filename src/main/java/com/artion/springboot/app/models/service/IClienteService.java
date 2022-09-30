package com.artion.springboot.app.models.service;

import com.artion.springboot.app.models.entity.Cliente;
import com.artion.springboot.app.models.entity.Factura;
import com.artion.springboot.app.models.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IClienteService {
    public List<Cliente> findAll();
    public Page<Cliente> findAll(Pageable pageable);
    public void save(Cliente cliente);
    public Cliente findOne(Long id);
    public void delete(Long id);
    public List<Producto> findByNombre(String term);

    public void saveFactura(Factura factura);

    public Producto findProductoById(Long id);
}
