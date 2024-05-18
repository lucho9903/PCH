package co.edu.uco.pch.businnes.assembler.dto;

import co.edu.uco.pch.businnes.assembler.Assembler;

public interface AssemblerDTO <D, K> extends Assembler <D, K>{
	D toDTO(D domain);
	

}
