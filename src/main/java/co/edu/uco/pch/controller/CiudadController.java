package co.edu.uco.pch.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.pch.controller.response.Response;
import co.edu.uco.pch.controller.response.ResponseCiudad;
import co.edu.uco.pch.crosscutting.Exceptions.PCHException;
import co.edu.uco.pch.dto.CiudadDTO;

@RestController
@RequestMapping("/api/v1/ciudades")
public final class CiudadController {
	
	
	@GetMapping("/dummy")
	public CiudadDTO dummy() {
		return CiudadDTO.build();
	}
	@GetMapping
	public ResponseEntity<ResponseCiudad> consultar() {
		var httpStatusCode = HttpStatus.ACCEPTED;
		var ResponseCiudad = new ResponseCiudad();
		try {
			
		}catch (final PCHException exception) {
			httpStatusCode = HttpStatus.BAD_GATEWAY;
			responseCiudad.
			
		}catch
		
		
		
	}
	

}
