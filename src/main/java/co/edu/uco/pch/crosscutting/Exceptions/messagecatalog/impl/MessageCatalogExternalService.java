package co.edu.uco.pch.crosscutting.Exceptions.messagecatalog.impl;

import co.edu.uco.pch.crosscutting.Exceptions.messagecatalog.MessageCatalog;
import co.edu.uco.pch.crosscutting.Exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.Exceptions.messagecatalog.data.Mensaje;

public class MessageCatalogExternalService implements MessageCatalog {

	@Override
	public final void inicializar() {		
	}

	@Override
	public final String obtenerContenidoMensaje(final CodigoMensaje codigo, String... parametros) {
		return null;
	}

	@Override
	public final Mensaje obtenerMensaje(final CodigoMensaje codigo, String... parametros) {
		return null;
	}

}

