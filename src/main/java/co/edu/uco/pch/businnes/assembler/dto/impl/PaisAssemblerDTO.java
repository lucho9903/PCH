package co.edu.uco.pch.businnes.assembler.dto.impl;

import co.edu.uco.pch.businnes.assembler.dto.AssemblerDTO;
import co.edu.uco.pch.businnes.domain.PaisDomain;
import static co.edu.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;
import co.edu.uco.pch.dto.PaisDTO;

public class PaisAssemblerDTO implements AssemblerDTO<PaisDomain, PaisDTO> {
	private static final AssemblerDTO<PaisDomain, PaisDTO> instance 
	 = new PaisAssemblerDTO();
	private PaisAssemblerDTO() {
		super();
	}
	public static final AssemblerDTO<PaisDomain, PaisDTO>

	@Override
	public final PaisDomain toDomain(final PaisDTO data) {
		var PaisDtoTmp = getObjectHelper().getDefaultValue(data, PaisDTO.build());
		// TODO Auto-generated method stub
		return PaisDomain.build(PaisDtoTmp.getId(),PaisDtoTmp.getNombre());
	}

	@Override
	public final PaisDomain toDTO(final PaisDomain domain) {
		var paisDomainTmp = getObjectHelper().getDefaultValue(domain, PaisDomain.build());
		return PaisDTO.build().setId(paisDomainTmp.getId())
				.setNombre(paisDomainTmp.getNombre());
	}

}
