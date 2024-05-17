package co.edu.uco.pch.data.dao.entity.concrete;

import java.sql.Connection;

import co.edu.uco.pch.crosscutting.Exceptions.custom.DataPCHException;
import co.edu.uco.pch.crosscutting.Exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.pch.crosscutting.Exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.helpers.SQLHelper;

public class SqlConnection {
	
	private Connection conexion;
	
	protected SqlConnection(final Connection conexion) {
		setConexion(conexion);
	}
	protected SqlConnection() {
		super();
	}

	protected final Connection getConexion() {
		return conexion;
	}

	protected final void setConexion(final Connection conexion) {
		if(!SQLHelper.isOpen(conexion)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "No es posible crer el DAo deseado con una conexion cerrada";
			
			throw new DataPCHException(mensajeTecnico, mensajeUsuario);
		}
		this.conexion = conexion;
	
	}
}