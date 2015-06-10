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

	void crear(String aNombreUsuario, String aCorreo, String aTelefono) {
		_nombre = aNombreUsuario;
		_correo = aCorreo;
		_telefono = aTelefono;
	}

	boolean tienesReserva() {
		throw new UnsupportedOperationException();
	}

	void anularReserva(String aCodReserva) {
		throw new UnsupportedOperationException();
	}

	void incluirReserva(Reserva aMiReserva) {
		//si el objeto no esta en el vector de reservas lo incluimos para no introducir reservas duplicadas
		
		if(reservas.contains(aMiReserva) == false)
			reservas.add(aMiReserva);
	}

	ArrayList consultarMisReservas() {
		throw new UnsupportedOperationException();
	}

	private Reserva buscarREserva(String aCodReserva) {
		Reserva miReserva;
		
		for(int i=0; i < reservas.size(); i++){
			if(reservas.get(i).getCodigoReserva() == aCodReserva){
				miReserva = reservas.get(i);
			}
		}
		
		throw new UnsupportedOperationException();
	}
	
	public String getTelefono(){
		return _telefono;
	}
}