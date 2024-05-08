package co.edu.uco.pch.crosscutting.Exceptions.custom;

import co.edu.uco.pch.crosscutting.Exceptions.PCHException;
import co.edu.uco.pch.crosscutting.Exceptions.enums.Lugar;

public final class BusinnesPCHException extends PCHException{
	
	private static final long serialVersionUID = -3662331984905572117L;

	public BusinnesPCHException(final String mensajeUsuario , Lugar lugar) {
		super(mensajeUsuario, Lugar.BUSINNES);
	}
	
	public BusinnesPCHException(final String mensajeTecnico,final String mensajeUsuario, 
			final Throwable exceptionRaiz) {
		super(mensajeTecnico,mensajeUsuario, Lugar.BUSINNES, exceptionRaiz);
	}
	
	
	
}
