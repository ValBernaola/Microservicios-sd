package com.utp.distribuido.cliente.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utp.distribuido.cliente.entidad.Articulo;
import com.utp.distribuido.cliente.servicio.ArticuloService;



@RestController
@RequestMapping("/articulo")
public class ArticuloController {

	@Autowired
	private ArticuloService articuloService;
	
	@GetMapping
	public ResponseEntity<List<Articulo>> listarArticulos(){
		List<Articulo> articulos = articuloService.getAll();
		if(articulos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(articulos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Articulo> obtenerArticulo(@PathVariable("id") int id){
		Articulo articulo = articuloService.getArticuloById(id);
		if(articulo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(articulo);
	}
	
	@PostMapping
	public ResponseEntity<Articulo> guardarArticulo(@RequestBody Articulo articulo){
		Articulo nuevoArticulo = articuloService.save(articulo);
		return ResponseEntity.ok(nuevoArticulo);
	}
	
	@GetMapping("/cliente/{clienteId}")
	public ResponseEntity<List<Articulo>> listarArticulosPorClienteId(@PathVariable("clienteId") int id){
		List<Articulo> articulos = articuloService.byClienteId(id);
		if(articulos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(articulos);
	}

}
