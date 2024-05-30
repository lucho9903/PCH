package co.edu.uco.pch.businnes.assembler.entity.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import co.edu.uco.pch.businnes.assembler.dto.AssemblerDTO;
import co.edu.uco.pch.businnes.assembler.dto.impl.CiudadAssemblerDTO;
import co.edu.uco.pch.businnes.assembler.entity.AssemblerEntity;
import co.edu.uco.pch.businnes.domain.CiudadDomain;
import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.dto.CiudadDTO;
import co.edu.uco.pch.entity.CiudadEntity;
import co.edu.uco.pch.entity.DepartamentoEntity;
import co.edu.uco.pch.businnes.domain.DepartamentoDomain;


public final class CiudadAssemblerEntity implements AssemblerEntity<CiudadDomain, CiudadEntity>{
	private static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> departamentoAssembler = DepartamentoAssemblerEntity
			.getInstance();
	private static final AssemblerEntity<CiudadDomain, CiudadEntity> instance=new CiudadAssemblerEntity();
	
	private CiudadAssemblerEntity() {
		super();
	}
	
	public static final AssemblerEntity<CiudadDomain, CiudadEntity> getInstance(){
		return instance;
	}

	@Override
	public final CiudadDomain toDomain(final CiudadEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final CiudadEntity toEntity(final CiudadDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CiudadDomain> toDomainCollection(final List<CiudadEntity> entityCollection) {
		var entityCollectionTmp = ObjectHelper.getObjectHelper()
				.getDefaultValue(entityCollection,new ArrayList<CiudadEntity>());
		
		return entityCollectionTmp.stream()
				.map(this::toDomain).toList();
	}

}