package co.edu.uco.pch.crosscutting.Exceptions.custom;

import co.edu.uco.pch.crosscutting.Exceptions.PCHException;
import co.edu.uco.pch.crosscutting.Exceptions.enums.Lugar;

public final class DefaultPCHException extends PCHException{
	private static final long serialVersionUID = -3662331984905572117L;

	public DefaultPCHException(final String mensajeUsuario , Lugar lugar) {
		super(mensajeUsuario, Lugar.DEFAULT);
	}
	
	public DefaultPCHException(final String mensajeTecnico,final String mensajeUsuario, 
			final Throwable exceptionRaiz) {
		super(mensajeTecnico,mensajeUsuario, Lugar.DEFAULT, exceptionRaiz);
	}
	
}