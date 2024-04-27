package co.edu.uco.pch.crosscutting.Exceptions.custom;

import co.edu.uco.pch.crosscutting.Exceptions.PCHException;
import co.edu.uco.pch.crosscutting.Exceptions.enums.Lugar;

public final class BusinnesPCHException extends PCHException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinnesPCHException(final String mensajeUsuiario) {
		super(mensajeUsuiario, Lugar.DATA);
	}

	public BusinnesPCHException(final String mensajeTecnico, final Throwable excepcionRaiz, final String mensajeUsuario) {
		super(mensajeTecnico, Lugar.DATA, excepcionRaiz, mensajeUsuario);
	}

	


	
}
