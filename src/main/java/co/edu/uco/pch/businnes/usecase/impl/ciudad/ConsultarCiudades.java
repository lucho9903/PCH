package co.edu.uco.pch.businnes.usecase.impl.ciudad;

import java.util.List;

import co.edu.uco.pch.businnes.assembler.entity.impl.CiudadAssemblerEntity;
import co.edu.uco.pch.businnes.domain.CiudadDomain;
import co.edu.uco.pch.businnes.usecase.UseCaseWithReturn;
import co.edu.uco.pch.crosscutting.Exceptions.custom.BusinnesPCHException;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.data.dao.factory.DAOFactory;

public class ConsultarCiudades implements UseCaseWithReturn<CiudadDomain, List<CiudadDomain>> {
	
	
	
	
	private DAOFactory factory;
	public ConsultarCiudades(final DAOFactory factory){
        if(ObjectHelper.getObjectHelper().isNull(factory)){
            var mensajeUsuario = "Se ha presentado un porblema tratando de llevar a cabo la consulta de las  ciudades";
            var mensajeTecnico = "El DAOFactory para crear la ciudad llego nulo...";
            throw new BusinnesPCHException(mensajeTecnico, mensajeUsuario);
        }
        this.factory = factory;
    }
	@Override
	public List<CiudadDomain> execute( final CiudadDomain data) {
		var ciudadEntityFilter =  CiudadAssemblerEntity.getInstance().toEntity(data);
		var resultadosEntity = factory.getCiudadDAO().consultar(ciudadEntityFilter);
			
		
		return CiudadAssemblerEntity.getInstance().toDomainCollection(resultadosEntity);
	}

}
