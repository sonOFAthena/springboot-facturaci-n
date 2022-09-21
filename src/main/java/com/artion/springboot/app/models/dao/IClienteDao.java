package com.artion.springboot.app.models.dao;

import com.artion.springboot.app.models.entity.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClienteDao extends PagingAndSortingRepository< Cliente , Long> {

}
