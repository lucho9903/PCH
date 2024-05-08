package co.edu.uco.pch.crosscutting.Exceptions.custom;

import co.edu.uco.pch.crosscutting.Exceptions.PCHException;
import co.edu.uco.pch.crosscutting.Exceptions.enums.Lugar;

public final class InitializerPCHException extends PCHException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InitializerPCHException(final String mensajeUsuiario) {
		super(mensajeUsuiario, Lugar.INITIALIZER);
	}

	public InitializerPCHException(final String mensajeTecnico,final String mensajeUsuario,
			final Throwable exceptionRaiz) {
		super(mensajeTecnico,mensajeUsuario, Lugar.INITIALIZER, exceptionRaiz);
	}
	
	


	
}
