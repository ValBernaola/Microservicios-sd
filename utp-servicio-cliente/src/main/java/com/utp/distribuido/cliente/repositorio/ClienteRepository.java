package com.utp.distribuido.cliente.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.distribuido.cliente.entidad.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
