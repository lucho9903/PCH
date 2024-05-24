package co.edu.uco.pch.crosscutting.Exceptions.custom;

import co.edu.uco.pch.crosscutting.Exceptions.PCHException;
import co.edu.uco.pch.crosscutting.Exceptions.enums.Lugar;

public final class BusinnesPCHException extends PCHException {

    private static final long serialVersionUID = -3662331984905572117L;
    private static final Lugar lugar = Lugar.BUSINNES;

    public BusinnesPCHException(final String mensajeUsuario) {
        super(mensajeUsuario, lugar);
    }
    public BusinnesPCHException(final String mensajeTecnico, final String mensajeUsuario) {
        super(mensajeTecnico, mensajeUsuario, lugar);
    }

    public BusinnesPCHException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
        super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
    }
}