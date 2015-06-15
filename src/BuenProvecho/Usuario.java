package BuenProvecho;

import java.util.Vector;
import java.util.ArrayList;

import BuenProvecho.Reserva;

public class Usuario {
	private String _nombre;
	private String _correo;
	private String _telefono;
	public BuenProvecho _unnamed_BuenProvecho_;
	public ArrayList<Reserva> reservas = new ArrayList<Reserva>();

	void crear(String aNombreUsuario, String aCorreo, String aTelefono) {
		_nombre = aNombreUsuario;
		_correo = aCorreo;
		_telefono = aTelefono;
	}

	boolean tienesReserva() {
		if(reservas.size() > 0)
			return true;
		else return false;
	}

	void anularReserva(String aCodReserva) {
		Reserva miReserva = new Reserva();
		
		miReserva = buscarReserva(aCodReserva);
		
		if(reservas.contains(miReserva) == true && miReserva.isConfirmed()){
			miReserva.anularReserva();
		}
	}

	void incluirReserva(Reserva aMiReserva) {
		//si el objeto no esta en el vector de reservas lo incluimos para no introducir reservas duplicadas
		
		if(reservas.contains(aMiReserva) == false)
			reservas.add(aMiReserva);
	}

	public ArrayList<Reserva> consultarMisReservas() {
		return reservas;
	}

	private Reserva buscarReserva(String aCodReserva) {
		Reserva miReserva = new Reserva();
		boolean esta = false;
		
		for(int i=0; i < reservas.size() && !esta; i++){
			if(reservas.get(i).getCodigoReserva() == aCodReserva){
				miReserva = reservas.get(i);
				esta = true;
			}
		}
		
		return miReserva;
	}
	
	public String getTelefono(){
		return _telefono;
	}

	public void eliminarReservasPasadas() {
		for(int i = 0; i < reservas.size(); i++){
			if(reservas.get(i).yaPasada())
				reservas.remove(reservas.get(i));
		}
	}

	public String getNombreUsuario() {
		return _nombre;
	}
}