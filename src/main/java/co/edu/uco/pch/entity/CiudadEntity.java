package co.edu.uco.pch.entity;

import java.util.UUID;

import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;
import co.edu.uco.pch.crosscutting.helpers.TextHelper;
import co.edu.uco.pch.crosscutting.helpers.UUIDHelper;

public class CiudadEntity {
	private UUID id;
	private String nombre;
	private DepartamentoEntity departamento;
	
	public CiudadEntity(final UUID id,final String nombre,final DepartamentoEntity departamento) {
		setId(id);
		setNombre(nombre);
		setDepartamento(departamento);
	}
	
	public CiudadEntity() {
		super();
	}
	
	public static final CiudadEntity build() {
		return new CiudadEntity();
	}
	
	public final UUID getId() {
		return id;
	}
	public final CiudadEntity setId(final UUID id) {
		this.id = UUIDHelper.obtenerValorDefecto(id);
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final CiudadEntity setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}
	public final DepartamentoEntity getDepartamento() {
		return departamento;
	}
	public final CiudadEntity setDepartamento(final DepartamentoEntity departamento) {
		this.departamento = ObjectHelper.getObjectHelper().getDefaultValue(departamento,new DepartamentoEntity());
		return this;
	}
	
	
}