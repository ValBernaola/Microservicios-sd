package com.utp.distribuido.cliente.controlador;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;


import com.utp.distribuido.cliente.entidad.Cliente;
import com.utp.distribuido.cliente.modelos.Articulo;
import com.utp.distribuido.cliente.servicio.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarCliente(){
		List<Cliente> clientes = clienteService.getAll();
		if(clientes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(clientes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> obtenerCliente(@PathVariable("id") int id){
		Cliente cliente = clienteService.getClienteById(id);
		if(cliente == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cliente);
	}
	@PostMapping
	public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente){
		Cliente nuevoCliente = clienteService.save(cliente);
		return ResponseEntity.ok(nuevoCliente );
	}
	
	
	@PostMapping("/articulo/{clienteId}")
	public ResponseEntity<Articulo> guardarArticulo(@PathVariable("clienteId") int clienteId,@RequestBody Articulo articulo){
		Articulo nuevoArticulo = clienteService.saveArticulo(clienteId, articulo);
		return ResponseEntity.ok(nuevoArticulo);
	} 
	
	@GetMapping("/todos/{clienteId}")
	public ResponseEntity<Map<String, Object>> listarTodosArticulos(@PathVariable("clienteId") int clienteId){
	Map<String,Object> resultado = clienteService.getClienteAndArticulos(clienteId);
		return ResponseEntity.ok(resultado);
	}
}

