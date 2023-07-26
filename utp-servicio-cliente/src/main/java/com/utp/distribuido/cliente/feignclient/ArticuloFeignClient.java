package com.utp.distribuido.cliente.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.utp.distribuido.cliente.modelos.Articulo;


@FeignClient(name="utp-servicio-articulos", url = "http://localhost:8082")
@RequestMapping("/articulo")
public interface ArticuloFeignClient {
	@PostMapping()
	public Articulo save(@RequestBody Articulo articulo);
	
	@GetMapping("/cliente/{clienteId}")
	public List<Articulo> getArticulos(@PathVariable("clienteId") int clienteId);

}
