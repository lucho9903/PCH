package co.edu.uco.pch.businnes.facade.impl.ciudad;

import java.util.List;
import co.edu.uco.pch.businnes.assembler.dto.impl.CiudadAssemblerDTO;
import co.edu.uco.pch.businnes.usecase.impl.ciudad.ConsultarCiudades;
import co.edu.uco.pch.businnes.facade.FacadeWhithRetunr;
import co.edu.uco.pch.crosscutting.Exceptions.PCHException;
import co.edu.uco.pch.crosscutting.Exceptions.custom.BusinnesPCHException;
import co.edu.uco.pch.data.dao.factory.DAOFactory;
import co.edu.uco.pch.dto.CiudadDTO;

public final class ConsultarCudadesFacade	
	implements FacadeWhithRetunr<CiudadDTO, List<CiudadDTO>>{
	
	private DAOFactory daoFactory;
	
	
	public ConsultarCudadesFacade() {
		daoFactory = DAOFactory.getFactory();
	}

	@Override
	public List<CiudadDTO> execute(final CiudadDTO dto) {

		try {
			var usecase = new ConsultarCiudades(daoFactory);
			var ciudadDomain = CiudadAssemblerDTO.getInstance().toDomain(dto);
			var resultadosDomain = usecase.execute(ciudadDomain);
			return CiudadAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);

		} catch (final PCHException exception) {
			throw exception;
			
		} catch (final Exception exception) {

			var mensajeUsuario = "Se ha presentado un problema consultar la informacion de las ciudad";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de consultar la ciudad";

			throw new BusinnesPCHException(mensajeTecnico, mensajeUsuario, exception);

		} finally {
			daoFactory.cerrarConexion();
		}
	}

}