package BuenProvecho;

import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Reserva {
	private GregorianCalendar fecha;
	private int numeroComensales;
	private boolean confirmada;
	private String codReserva;
	public Usuario usuario_;
	public Restaurante restaurante_;

	void crear(Usuario aUnUsuario, Restaurante aUnRestaurante, GregorianCalendar aFecha, int aNumeroComensales) {
		numeroComensales = aNumeroComensales;
		confirmada = false; //por defecto la reserva no estara confirmada
		/*
		 * Implementar el sistema para adignar un codigo a la nueva reserva 
		 */
		usuario_ = aUnUsuario;
		restaurante_ = aUnRestaurante;
		fecha = aFecha;
		
		throw new UnsupportedOperationException();
	}

	void eliminarDelRestaurante() {
		throw new UnsupportedOperationException();
	}

	ArrayList obrenerDatosReserva() {
		throw new UnsupportedOperationException();
	}

	boolean yaPasada() {
		throw new UnsupportedOperationException();
	}

	void confirmar() {
		throw new UnsupportedOperationException();
	}
}