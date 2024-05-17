package co.edu.uco.pch.data.dao.entity.concrete.azuresql;



import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.edu.uco.pch.data.dao.entity.DepartamentoDAO;
import co.edu.uco.pch.data.dao.entity.concrete.SqlConnection;
import co.edu.uco.pch.entity.DepartamentoEntity;
import co.edu.uco.pch.entity.PaisEntity;


public class DepartamentoAzureSqlDAO extends SqlConnection implements DepartamentoDAO{

	public DepartamentoAzureSqlDAO(final Connection connection) {
		super(connection);
		
	}

	@Override
	public List<DepartamentoEntity> consultar(DepartamentoEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartamentoEntity obtenerPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
