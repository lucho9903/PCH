package co.edu.uco.pch.data.dao.entity.concrete;

import java.sql.Connection;

import co.edu.uco.pch.crosscutting.helpers.SQLHelper;

public class SqlConnection {
	
	private Connection conexion;
	
	protected SqlConnection(final Connection connection) {
		setConexion(connection);
	}

	protected final Connection getConexion() {
		return conexion;
	}

	private final void setConexion(final Connection conexion) {
		if(!SQLHelper.isOpen(conexion)) {
			
			
		}
	
	}
}