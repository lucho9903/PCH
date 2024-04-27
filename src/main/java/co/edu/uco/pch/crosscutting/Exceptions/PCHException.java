package co.edu.uco.pch.crosscutting.Exceptions;

import co.edu.uco.pch.crosscutting.Exceptions.enums.Lugar;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.TextHelper;

public class PCHException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String mensajeUsuario;
	protected Lugar lugar;
	
	public PCHException(String mensajeTecnico, Lugar lugar , Throwable excepcionRaiz, String mensajeUsuario) {
		super(mensajeTecnico, excepcionRaiz);
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
		
		
		
	
	}
	public PCHException(final String mensajeUsuiario, final Lugar lugar ) {
		super(mensajeUsuiario, new Exception());
		setMensajeUsuario (mensajeUsuario);
		setLugar(lugar);
	}
	public void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = TextHelper.applyTrim(mensajeUsuario);
	}
	public void setLugar(final Lugar lugar) {
		this.lugar = ObjectHelper.getObjectHelper().getDefaultValue(lugar,Lugar.DEFAULT );
	}
	
}
