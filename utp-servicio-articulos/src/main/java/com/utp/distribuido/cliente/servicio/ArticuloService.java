package com.utp.distribuido.cliente.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utp.distribuido.cliente.entidad.Articulo;
import com.utp.distribuido.cliente.repositorio.ArticuloRepository;

@Service
public class ArticuloService {
	@Autowired
	private ArticuloRepository articuloRepository;
	
	public List<Articulo> getAll(){
		return articuloRepository.findAll();
	}
	
	public Articulo getArticuloById(int id) {
		return articuloRepository.findById(id).orElse(null);
	}
	
	public Articulo save(Articulo articulo) {
		Articulo nuevoArticulo = articuloRepository.save(articulo);
		return nuevoArticulo;
	}
	
	public List<Articulo> byClienteId(int clienteId){
		return articuloRepository.findByClienteId(clienteId);
	}

}
