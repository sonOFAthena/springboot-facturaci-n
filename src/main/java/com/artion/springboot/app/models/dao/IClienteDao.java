package com.artion.springboot.app.models.dao;

import com.artion.springboot.app.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository< Cliente , Long> {

}
