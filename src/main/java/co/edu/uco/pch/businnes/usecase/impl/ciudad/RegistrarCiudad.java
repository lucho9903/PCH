package co.edu.uco.pch.businnes.usecase.impl.ciudad;

import java.util.UUID;

import co.edu.uco.pch.businnes.assembler.dto.impl.CiudadAssemblerDTO;
import co.edu.uco.pch.businnes.assembler.dto.impl.DepartamentoAssemblerDTO;
import co.edu.uco.pch.businnes.domain.CiudadDomain;
import co.edu.uco.pch.businnes.usecase.UseCaseWithoutReturn;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.UUIDHelper;
import co.edu.uco.pch.data.dao.factory.DAOFactory;
import co.edu.uco.pch.entity.CiudadEntity;

public final class RegistrarCiudad implements UseCaseWithoutReturn<CiudadDomain>{
	
	private DAOFactory factory;
	
	public RegistrarCiudad(final DAOFactory factory) {
		if (ObjectHelper.getObjectHelper().isNull(factory)) {
			var mensajeUsuario = "Se a presentado un problema tratando de crear la ciudad";
			var mensajeTecnico = "el dao factory la ciudad llego mnula";
			throw new BusinnessPCHExeption(mensajeTecnico, mensajeUsuario);
		}
		
	}
	
	

	@Override
	public void excute(final CiudadDomain data) {
		//aca deben ir las politicas
		var ciudadEntity = CiudadEntity.build().setId(generarIdentificadorCiudad())
				.setNombre(data.getNombre())
				.setDepartamento(DepartamentoAssemblerEntity.get)
		var ciudadEntity = CiudadAssemblerEntity.getInsatnce().toEntity(data);
		factory.getCiudadDAO().crear(CiudadEntity);
		
		
	}
	private final UUID generarIdentificadorCiudad() {
		UUID id ;
		boolean existeId = false;
		
		while(!existeId) {
			id = UUIDHelper.generate();
			var ciudadEntity = CiudadEntity.build().setId(id);
			var resultados = factory.getCiudadDAO().consultar(ciudadEntity);
			existeId = !resultados.isEmpty();
		}
		return id;
	
	}	
}
