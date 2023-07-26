package com.utp.distribuido.cliente.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.distribuido.cliente.entidad.Articulo;



public interface ArticuloRepository extends JpaRepository<Articulo, Integer>{

	List<Articulo> findByClienteId(int clienteId);
	

}
