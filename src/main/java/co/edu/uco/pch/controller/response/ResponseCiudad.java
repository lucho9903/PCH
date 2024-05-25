package co.edu.uco.pch.controller.response;

import java.util.ArrayList;

import co.edu.uco.pch.dto.CiudadDTO;

public class ResponseCiudad  extends Response<CiudadDTO>{
	public ResponseCiudad() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
