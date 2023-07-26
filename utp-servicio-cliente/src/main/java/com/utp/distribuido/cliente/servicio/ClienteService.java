package com.utp.distribuido.cliente.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.utp.distribuido.cliente.entidad.Cliente;
import com.utp.distribuido.cliente.feignclient.ArticuloFeignClient;
import com.utp.distribuido.cliente.modelos.Articulo;
import com.utp.distribuido.cliente.repositorio.ClienteRepository;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ArticuloFeignClient articuloFeignClient;

	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}

	public Cliente getClienteById(int id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public 	Cliente save(Cliente cliente) {
		Cliente nuevoCliente = clienteRepository.save(cliente);
		return nuevoCliente;
	}

	public Articulo saveArticulo(int clienteId,Articulo articulo) {
		articulo.setClienteId(clienteId);
		Articulo nuevoArticulo = articuloFeignClient.save(articulo);
		return nuevoArticulo;
	}
	
	public Map<String, Object> getClienteAndArticulos(int clienteId){
		Map<String,Object> resultado = new HashMap<>();
		Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
		
		if(cliente == null) {
			resultado.put("Mensaje", "El cliente no existe");
			return resultado;
		}
		
		resultado.put("Cliente",cliente);
		List<Articulo> articulos = articuloFeignClient.getArticulos(clienteId);
		if(articulos.isEmpty()) {
			resultado.put("Articulos", "El cliente no tiene articulos");
		}
		else {
			resultado.put("Articulos", articulos);
		}
		
		return resultado;
	}




}
