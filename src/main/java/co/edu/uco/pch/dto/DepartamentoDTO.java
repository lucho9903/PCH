package co.edu.uco.pch.dto;

import java.util.UUID;

import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.TextHelper;
import co.edu.uco.pch.crosscutting.helpers.UUIDHelper;

public class DepartamentoDTO {
	
	private UUID id;
	private String nombre;
	private PaisDTO pais;
	
	
	public DepartamentoDTO(final UUID id, final String nombre, final PaisDTO pais) {
		setId(id);
		setNombre(nombre);
		setPais(pais);
	}
	
	public DepartamentoDTO() {
		super();
	}
	
	public static final DepartamentoDTO build() {
		return new DepartamentoDTO();
	}

	public final UUID getId() {
		return id;
	}
	public final DepartamentoDTO setId(final UUID id) {
		this.id = UUIDHelper.obtenerValorDefecto(id);
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final DepartamentoDTO setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}
	public final PaisDTO getPais() {
		return pais;
	}
	public final DepartamentoDTO setPais(final PaisDTO pais) {
		this.pais = ObjectHelper.getObjectHelper().getDefaultValue(pais,new PaisDTO());
		return this;
	}
	
	
}