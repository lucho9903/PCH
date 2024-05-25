package co.edu.uco.pch.businnes.assembler.dto;

import java.util.List;

import co.edu.uco.pch.businnes.assembler.Assembler;

public interface AssemblerDTO <D,K> extends Assembler<D, K>{
	K toDTO(D domain);
	List<K> toDTOCollection(List<D> domainCollection);
}