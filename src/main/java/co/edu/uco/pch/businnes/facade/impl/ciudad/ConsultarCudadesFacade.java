package co.edu.uco.pch.businnes.facade.impl.ciudad;

import java.util.List;

import co.edu.uco.pch.businnes.assembler.dto.impl.CiudadAssemblerDTO;
import co.edu.uco.pch.businnes.facade.FacadeWhithRetunr;
import co.edu.uco.pch.crosscutting.Exceptions.PCHException;
import co.edu.uco.pch.crosscutting.Exceptions.custom.BusinnesPCHException;
import co.edu.uco.pch.dto.CiudadDTO;

public final class ConsultarCudadesFacade	
	implements FacadeWhithRetunr<CiudadDTO, List<CiudadDTO>>{

	@Override
	public List<CiudadDTO> excute(CiudadDTO dto) {
		try {
			var useCase = new ConsultarCudadesFacade(daoFactory);
			var ciudadDomain = CiudadAssemblerDTO.getInstance().toDomain(dto);
			useCase.excute(ciudadDomain);
			
		}catch (final PCHException exception) {
			
			throw exception;
			
		}catch (final Exception exception) {
			
			
			var mensajeUsuario = "se a presentado un error consultando la ciudad";
			var mensajeTectnico ="Se a presentado un error tratando de consultar la ciudad verifique los errores";
			
			throw new BusinnesPCHException(mensajeTectnico, mensajeUsuario, exception);
		}finally {
			daoFactory.cerrarConexion();
		}
	}	
}
