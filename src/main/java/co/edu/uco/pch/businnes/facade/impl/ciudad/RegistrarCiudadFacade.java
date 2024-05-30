package co.edu.uco.pch.businnes.facade.impl.ciudad;

import co.edu.uco.pch.data.dao.factory.*;
import co.edu.uco.pch.businnes.assembler.dto.impl.CiudadAssemblerDTO;
import co.edu.uco.pch.businnes.domain.CiudadDomain;
import co.edu.uco.pch.businnes.facade.FacadeWhithoutReturn;
import co.edu.uco.pch.crosscutting.Exceptions.PCHException;
import co.edu.uco.pch.crosscutting.Exceptions.custom.BusinnesPCHException;
import co.edu.uco.pch.dto.CiudadDTO;
import co.edu.uco.pch.businnes.usecase.impl.ciudad.RegistrarCiudad;
import co.edu.uco.pch.businnes.usecase.impl.ciudad.ConsultarCiudades;
import co.edu.uco.pch.businnes.facade.FacadeWhithRetunr;
import co.edu.uco.pch.data.dao.factory.DAOFactory;
import java.util.List;



public final class RegistrarCiudadFacade implements FacadeWhithoutReturn<CiudadDTO>{
	
	private DAOFactory daoFactory;
	
	
	public RegistrarCiudadFacade() {
		daoFactory = DAOFactory.getFactory();
	}
	
	

	@Override
	public void execute(final CiudadDTO dto) {
		daoFactory.iniciarTransaccion();
		try {
			var useCase = new RegistrarCiudad(daoFactory);
			var ciudadDomain = CiudadAssemblerDTO.getInstance().toDomain(dto);
			useCase.execute(ciudadDomain);
			daoFactory.confirmarTransaccion();
		}catch (final PCHException exception) {
			daoFactory.cancelarTransaccion();
			throw exception;
			
		}catch (final Exception exception) {
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuario = "se a presentado un error registradnod laciudad";
			var mensajeTectnico ="Se a presentado un error tratando de registar la ciudad verifique los errores";
			
			throw new BusinnesPCHException(mensajeTectnico, mensajeUsuario, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
		
	}

}
