package co.edu.uco.pch.businnes.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.pch.businnes.assembler.dto.AssemblerDTO;
import co.edu.uco.pch.businnes.domain.CiudadDomain;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.dto.CiudadDTO;

public class CiudadAssemblerDTO implements AssemblerDTO<CiudadDomain, CiudadDTO>{

	private static final AssemblerDTO<CiudadDomain, CiudadDTO> instance=new CiudadAssemblerDTO();
	
	private CiudadAssemblerDTO() {
		super();
	}
	
	public static final AssemblerDTO<CiudadDomain, CiudadDTO> getInstance(){
		return instance;
	}
	@Override
	public CiudadDomain toDomain(CiudadDTO data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CiudadDTO toDTO(CiudadDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CiudadDomain> toDomainCollection(final List<CiudadDTO> dtoCollection) {
		var dtoCollectionTmp = ObjectHelper.getObjectHelper()
				.getDefaultValue(dtoCollection, new ArrayList<CiudadDTO>());
		var resultadoDomain = new ArrayList<CiudadDomain>();
		
		for (CiudadDTO ciudadDto : dtoCollection) {
			var ciudadDomainTmp = toDomain(ciudadDto);
			resultadoDomain.add(ciudadDomainTmp);
		}
		
		return resultadoDomain;
	}

	@Override
	public List<CiudadDTO> toDTOCollection(final List<CiudadDomain> domainCollection) {
		var domainCollectionTmp = ObjectHelper.getObjectHelper()
				.getDefaultValue(domainCollection, new ArrayList<CiudadDomain>());
		return null;
	}
	
	//TAREA

}