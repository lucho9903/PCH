package co.edu.uco.pch.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.edu.uco.pch.crosscutting.Exceptions.custom.DataPCHException;
import co.edu.uco.pch.data.dao.entity.CiudadDAO;
import co.edu.uco.pch.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.pch.entity.CiudadEntity;

public class CiudadAzureSqlDAO extends SqlConnection implements CiudadDAO{

	public CiudadAzureSqlDAO(final Connection connection) {
		super(connection);
		
	}

	
	
	@Override
	public final void crear(final CiudadEntity data) {
		final StringBuilder sentenciasSql = new StringBuilder();
		
		sentenciasSql.append("INSERT INTO ciudad (id, nombre, departamento) ");
		sentenciasSql.append("SELECT ?, ?, ?");
		
		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciasSql.toString())){
			
			sentenciaSqlPreparada.setObject(1, data.getId() );
			sentenciaSqlPreparada.setString(2, data.getNombre());
			sentenciaSqlPreparada.setObject(3, data.getDepartamento().getId());
			
			sentenciaSqlPreparada.executeUpdate();


						
		} catch (final SQLException exception) {
			var mensajeUsiario = "Se ha presentado un problema trantando de crear la ciudad \"${1}\" por favor intente de nuevo y si el problema persiste contacte a el administrador";
			var mensajeTecnico ="Se ha presentado una excepcion de tipo SQLException tratando de realizar el INSERT de la ciudad \" {1}\"para mas detalles revise la excepcion raiz presentada..";
		
			throw new DataPCHException(mensajeTecnico, mensajeUsiario, exception);
		}catch (final Exception exception) {
			var mensajeUsiario = "Se ha presentado un problema trantando de crear la ciudad \"${1}\" por favor intente de nuevo y si el problema persiste contacte a el administrador";
			var mensajeTecnico ="Se ha presentado un problema INESPERADO con una excepcion de tipo Exception tratando de realizar el INSERT de la ciudad \" {1}\"para mas detalles revise la excepcion raiz presentada..";
		
			throw new DataPCHException(mensajeTecnico, mensajeUsiario, exception);

		}
	}

	@Override
	public List<CiudadEntity> consultar(CiudadEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(CiudadEntity data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}