package co.edu.uco.pch.crosscutting.Exceptions.messagecatalog.data;

import static co.edu.uco.pch.crosscutting.helpers.TextHelper.concatenate;
import static co.edu.uco.pch.crosscutting.helpers.TextHelper.UNDERLINE;


public enum CodigoMensaje {
	
	M00001(TipoMensaje.TECNICO,categoriaMensaje.ERROR,"00001", true),
	M00002(TipoMensaje.USUARIO,categoriaMensaje.ERROR,"00002", true),
	M00003(TipoMensaje.TECNICO,categoriaMensaje.ERROR,"00003", true),
	M00004(TipoMensaje.TECNICO,categoriaMensaje.ERROR,"00003", true),
	;
	
	private TipoMensaje tipo;
	private categoriaMensaje categoria;
	private String codigo;
	private boolean base;
	
	private CodigoMensaje(final TipoMensaje tipo, 
			final categoriaMensaje categoria, final String codigo, 
			final boolean base) {
		setTipo(tipo);
		setCategoria(categoria);
		setCodigo(codigo);
		setBase(base);
	}

	public final TipoMensaje getTipo() {
		return tipo;
	}

	public final categoriaMensaje getCategoria() {
		return categoria;
	}

	public final String getCodigo() {
		return codigo;
	}

	private final void setTipo(final TipoMensaje tipo) {
		this.tipo = tipo;
	}

	private final void setCategoria(final categoriaMensaje categoria) {
		this.categoria = categoria;
	}

	private final void setCodigo(final String codigo) {
		this.codigo = codigo;
	}
	
	
	private final void setBase(final boolean base) {
		this.base = base;
	}

	public final boolean isBase() {
		return base;
	}

	public String getIdentificador() {
		return concatenate(getTipo().name(), UNDERLINE,
				getCategoria().name(), UNDERLINE,
				getCodigo());
		}
}

