package co.edu.uco.pch.businnes.facade.impl.ciudad;

import java.util.UUID;

import co.edu.uco.pch.businnes.assembler.dto.impl.CiudadAssemblerDTO;
import co.edu.uco.pch.businnes.facade.FacadeWhithoutReturn;
import co.edu.uco.pch.crosscutting.Exceptions.PCHException;
import co.edu.uco.pch.crosscutting.Exceptions.custom.BusinnesPCHException;
import co.edu.uco.pch.data.dao.factory.DAOFactory;
import co.edu.uco.pch.dto.CiudadDTO;
import co.edu.uco.pch.businnes.usecase.impl.ciudad.EliminarCiudad;

public class EliminarCiudadFacade implements FacadeWhithoutReturn<CiudadDTO> {
	
	private DAOFactory daoFactory;
	
	public EliminarCiudadFacade() {
		daoFactory = DAOFactory.getFactory();
	}
	
	

	@Override
	public void execute(final CiudadDTO dto) {
		daoFactory.iniciarTransaccion();
		try {
			var useCase = new EliminarCiudad(daoFactory);
			var ciudadDomain = CiudadAssemblerDTO.getInstance().toDomain(dto);
			useCase.execute(ciudadDomain);
			daoFactory.confirmarTransaccion();
		}catch (final PCHException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
			
		}catch (final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuario = "se a presentado un error eliminado la ciudad";
			var mensajeTectnico ="Se a presentado un error tratando de eliminar la ciudad verifique los errores";
			
			throw new BusinnesPCHException(mensajeTectnico, mensajeUsuario, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}



	public void execute(UUID id) {
		
		
	}


}
