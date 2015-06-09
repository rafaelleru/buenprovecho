package BuenProvecho;

import java.util.Vector;
import java.util.GregorianCalendar;

import BuenProvecho.Reserva;

public class Restaurante {
	private String _nombre;
	private String _provincia;
	private String _localidad;
	private String _direccion;
	private String _telefono;
	private String _tipoCocina;
	private float _precioMedio;
	private String _descripcio;
	private String _horario;
	private Object _estado;
	public Vector<Reserva> reservas = new Vector<Reserva>();

	void crear(String aNombre, String aProvincia, String aLocalidad, String aDireccion, String aTelefono) {
		throw new UnsupportedOperationException();
	}

	boolean pendienteAlta() {
		throw new UnsupportedOperationException();
	}

	String[] obtenerDatosRestaurante() {
		throw new UnsupportedOperationException();
	}

	void activarRestaurante() {
		throw new UnsupportedOperationException();
	}

	void eliminarReserva(Object aReserva) {
		throw new UnsupportedOperationException();
	}

	void registrarReserva(Usuario aUnusuario, GregorianCalendar aFecha, int aNumeroComensales) {
		throw new UnsupportedOperationException();
	}

	void actualizarRestaurante(String aTipoCocina, float aPrecioMedio, String aDescripcion, String aHorario) {
		throw new UnsupportedOperationException();
	}

	public void confirmarReserva(Object aCodigoReserva) {
		throw new UnsupportedOperationException();
	}

	private Reserva buscarReserva(Object aCodReserva) {
		throw new UnsupportedOperationException();
	}
	
	void incluirReserva(Reserva reserva) {
		throw new UnsupportedOperationException();
	}
	
	public String getTelefono(){
		return _telefono;
	}
}