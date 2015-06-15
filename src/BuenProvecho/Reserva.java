package BuenProvecho;

import java.util.Calendar;
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
		restaurante_.eliminarReserva(this);
	}

	public ArrayList<String> obrenerDatosReserva() {
		ArrayList<String> datos = new ArrayList<String>();
		//datos.add("Comensales :");
		datos.add(Integer.toString(numeroComensales));
		//datos.add("Confirmada:");
		if(confirmada)
			datos.add("Si");
		else datos.add("No");
		//datos.add("Codigo Reserva: ");
		datos.add(codReserva);
		datos.add(usuario_.getNombreUsuario());
		datos.add(restaurante_.getNombreRestaurante());
		
		return datos;
	}

	public boolean yaPasada() {
		Calendar fechaactual = GregorianCalendar.getInstance(); //fecha actual del sistema
		
		if(fecha.after(fechaactual))
			return true;
		else return false;
		
	}

	public void confirmar() {
		confirmada = true;
	}
	
	public String getCodigoReserva(){
		return codReserva;
	}
	
	public void anularReserva(){
		confirmada = false;
	}
	
	public boolean isConfirmed(){
		return confirmada;
	}
}