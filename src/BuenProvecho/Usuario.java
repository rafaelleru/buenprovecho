package BuenProvecho;

import java.util.Vector;
import java.util.ArrayList;
import BuenProvecho.Reserva;

public class Usuario {
	private String _nombre;
	private String _correo;
	private String _telefono;
	public BuenProvecho _unnamed_BuenProvecho_;
	public Vector<Reserva> reservas = new Vector<Reserva>();

	void crear(String aNombreUSuario, String aCorreo, String aTelefono) {
		throw new UnsupportedOperationException();
	}

	boolean tienesReserva() {
		throw new UnsupportedOperationException();
	}

	void anularReserva(String aCodReserva) {
		throw new UnsupportedOperationException();
	}

	void incluirReserva(Reserva aMiReserva) {
		throw new UnsupportedOperationException();
	}

	ArrayList consultarMisReservas() {
		throw new UnsupportedOperationException();
	}

	private Reserva buscarREserva(String aCodReserva) {
		throw new UnsupportedOperationException();
	}
	
	public String getTelefono(){
		return _telefono;
	}
}