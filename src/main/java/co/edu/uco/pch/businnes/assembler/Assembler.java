package co.edu.uco.pch.businnes.assembler;

public interface Assembler<D, K> {
	D toDomain(K data);
	

}
