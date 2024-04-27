package co.edu.uco.pch.crosscutting.Exceptions.custom;

import co.edu.uco.pch.crosscutting.Exceptions.PCHException;
import co.edu.uco.pch.crosscutting.Exceptions.enums.Lugar;

public final class InitializerPCHException extends PCHException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InitializerPCHException(final String mensajeUsuiario) {
		super(mensajeUsuiario, Lugar.DATA);
	}

	public InitializerPCHException(final String mensajeTecnico, final Throwable excepcionRaiz, final String mensajeUsuario) {
		super(mensajeTecnico, Lugar.DATA, excepcionRaiz, mensajeUsuario);
	}

	


	
}
