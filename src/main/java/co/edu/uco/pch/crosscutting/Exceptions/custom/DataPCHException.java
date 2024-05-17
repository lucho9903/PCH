package co.edu.uco.pch.crosscutting.Exceptions.custom;

import co.edu.uco.pch.crosscutting.Exceptions.PCHException;
import co.edu.uco.pch.crosscutting.Exceptions.enums.Lugar;

public final class DataPCHException extends PCHException {

	private static final long serialVersionUID = 361322697118899300L;
	private static final Lugar lugar = Lugar.DATA;

	public DataPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}
	
	public DataPCHException(final String mensajeUsuario, final String mensajeTecnico) {
		super(mensajeUsuario,mensajeTecnico, lugar);
	}

	public DataPCHException(final String mensajeTecnico, final String mensajeUsuario,
			Throwable exepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, exepcionRaiz);
	}

}