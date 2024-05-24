package co.edu.uco.pch.businnes.assembler.entity;

import co.edu.uco.pch.businnes.assembler.Assembler;

public interface AssemblerEntity<D,K> extends Assembler<D,K > {
	K toEntity(D domain);
}