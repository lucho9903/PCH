package co.edu.uco.pch.businnes.assembler.dto.impl;

import static co.edu.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;

import co.edu.uco.pch.businnes.assembler.dto.AssemblerDTO;
import co.edu.uco.pch.businnes.assembler.dto.AssemblerDTO;
import co.edu.uco.pch.businnes.domain.CiudadDomain;
import co.edu.uco.pch.businnes.domain.DepartamentoDomain;
import co.edu.uco.pch.businnes.domain.PaisDomain;
import co.edu.uco.pch.dto.CiudadDTO;
import co.edu.uco.pch.dto.DepartamentoDTO;
import co.edu.uco.pch.dto.PaisDTO;

public class DepartamentoAssemblerDTO implements AssemblerDTO<DepartamentoDomain, DepartamentoDTO>{
	private static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> paisAssembler = DepartamentoDTO; 
	
	
	private CiudadAssemblerDTO() {
		super();
		
	}
	public static final AssemblerDTO<CiudadDomain,CiudadDTO> getInstance(){
		return instance;
	}
	@Override
	public final DepartamentoDomain toDomain( final DepartamentoDTO data) {
		var departamentoDtoTmp = getObjectHelper().getDefaultValue(data, DepartamentoDTO.build());
		var paisDomain = PaisAssemebler.toDomain(departamentoDtoTmp.getPais());
		return DepartamentoDomain.build(departamentoDtoTmp.getId(),departamentoDtoTmp.getNombre());
	}

	@Override
	public final DepartamentoDomain toDTO(final DepartamentoDomain domain) {
		var departamentoDomainTmp = getObjectHelper().getDefaultValue(domain, DepartamentoDomain.build());
		return DepartamentoDTO.build().setId(departamentoDomainTmp.getId())
				.setNombre(departamentoDomainTmp.getNombre());
	}

}
