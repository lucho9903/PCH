package co.edu.uco.pch.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.pch.businnes.facade.impl.ciudad.*;
import co.edu.uco.pch.controller.response.Response;
import co.edu.uco.pch.businnes.facade.impl.ciudad.ConsultarCudadesFacade;
import co.edu.uco.pch.controller.response.CiudadResponse;
import co.edu.uco.pch.crosscutting.Exceptions.PCHException;
import co.edu.uco.pch.dto.CiudadDTO;

@RestController
@RequestMapping("/api/v1/ciudades")
public final class CiudadController {
	
	
	@GetMapping ("/dummy")
	public CiudadDTO dummy() {
		return CiudadDTO.build();
	}
	
	@GetMapping 
	public ResponseEntity<CiudadResponse> consultar(){
		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();
		
		try {
			var ciudadDTO = CiudadDTO.build();
			var facade = new ConsultarCudadesFacade();
			
			ciudadResponse.setDatos(facade.execute(null));
			ciudadResponse.getMensajes().add("Ciudades Consultada exitosamente...");
			
		}catch (final PCHException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(exception.getMensajeUsuario());		
			exception.printStackTrace();
		}catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "Se ha presentado un error tratando de consultar la informacion de la ciudades..";
			ciudadResponse.getMensajes().add(mensajeUsuario);
		}
		
		return new ResponseEntity<>(ciudadResponse, httpStatusCode);
		
		
	}
	@PostMapping
	public ResponseEntity<CiudadResponse> crear(@RequestBody CiudadDTO ciudad){
		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();
		
		try {
			var facade = new RegistrarCiudadFacade();
			
			facade.execute(ciudad);
			ciudadResponse.getMensajes().add("Ciudades creada exitosamente...");
			
		}catch (final PCHException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(exception.getMensajeUsuario());		
			exception.printStackTrace();
		}catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "Se ha presentado un error tratando de registar la informacion de la ciudad..";
			ciudadResponse.getMensajes().add(mensajeUsuario);
			
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(ciudadResponse, httpStatusCode);
		
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<CiudadResponse> eliminar(@PathVariable UUID id){
		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();
		
		try {
			var facade = new EliminarCiudadFacade();
			
			facade.execute(id);
			ciudadResponse.getMensajes().add("Ciudades eliminada exitosamente...");
			
		}catch (final PCHException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(exception.getMensajeUsuario());		
			exception.printStackTrace();
		}catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "Se ha presentado un error tratando de eliminar la informacion de la ciudad..";
			ciudadResponse.getMensajes().add(mensajeUsuario);
			
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(ciudadResponse, httpStatusCode);
		
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<CiudadResponse> modificar(@PathVariable UUID id,
			@RequestBody CiudadDTO ciudadDTO){
		
		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();
		
		try {
			ciudadDTO.setId(id);
			var facade = new ModificarCiudadFacade();
			
			facade.execute(id);
			ciudadResponse.getMensajes().add("Ciudades modificada exitosamente...");
			
		}catch (final PCHException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(exception.getMensajeUsuario());		
			exception.printStackTrace();
		}catch (final Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "Se ha presentado un error tratando de modificar la informacion de la ciudad..";
			ciudadResponse.getMensajes().add(mensajeUsuario);
			
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(ciudadResponse, httpStatusCode);
		
		
	}


}