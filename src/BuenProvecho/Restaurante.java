package BuenProvecho;

import java.util.Vector;
import java.util.GregorianCalendar;

import BuenProvecho.Reserva;
import BuenProvecho.EstadosRestaurante;

public class Restaurante {
	private String _nombre;
	private String _provincia;
	private String _localidad;
	private String _direccion;
	private String _telefono;
	private String _tipoCocina;
	private float _precioMedio;
	private String _descripcion;
	private String _horario;
	private EstadosRestaurante _estado;
	public Vector<Reserva> reservas = new Vector<Reserva>();

	void crear(String aNombre, String aProvincia, String aLocalidad, String aDireccion, String aTelefono) {
		_nombre = aNombre;
		_provincia = aProvincia;
		_localidad = aLocalidad;
		_direccion = aDireccion;
		_telefono = aTelefono;
		_tipoCocina = "No hay informacion sobre el tipo de cocina de este restaurante";
		_precioMedio = 0;
		_descripcion = "La descripcion de este restaurante no esta disponible";
		_horario = "El horario de este restaurante no esta disponible";
		_estado = EstadosRestaurante.Inactivo;
	}

	boolean pendienteAlta() {
		if(_estado == EstadosRestaurante.PendienteAlta)
			return true;
		else return false;
	}

	String[] obtenerDatosRestaurante() {
		throw new UnsupportedOperationException();
	}

	void activarRestaurante() {
		if(_estado == EstadosRestaurante.Inactivo)
			_estado = EstadosRestaurante.Activo;
	}

	void eliminarReserva(Object aReserva) {
		if(reservas.contains(aReserva)){
			reservas.remove(aReserva);
		}
	}

	void registrarReserva(Usuario aUnusuario, GregorianCalendar aFecha, int aNumeroComensales) {
		Reserva reserva = new Reserva();
		
		reserva.crear(aUnusuario, this, aFecha, aNumeroComensales);
		incluirReserva(reserva);
		
		throw new UnsupportedOperationException();
	}

	void actualizarRestaurante(String aTipoCocina, float aPrecioMedio, String aDescripcion, String aHorario) {
		_tipoCocina = aTipoCocina;
		_precioMedio = aPrecioMedio;
		_descripcion = aDescripcion;
		_horario = aHorario;
	}

	public void confirmarReserva(String aCodigoReserva) {
		boolean esta = false;
		Reserva aux = new Reserva();
		
		for(int i = 0; i < reservas.size() && !esta; i++){
			if(reservas.get(i).getCodigoReserva() == aCodigoReserva){
				esta = true;
				aux = reservas.get(i);
			}
			else esta = false;
		}
		
		try{
			if(esta)
				aux.confirmar();
		}finally {
			System.out.print("esta Reserva no existe");
		}
				
	}

	private Reserva buscarReserva(String aCodReserva) {
		boolean esta = false;
		Reserva aux = new Reserva();
		
		for(int i = 0; i < reservas.size() && !esta; i++){
			if(reservas.get(i).getCodigoReserva() == aCodReserva){
				esta = true;
				aux = reservas.get(i);
			}
		}
		
		return aux;
	}
	
	void incluirReserva(Reserva reserva) {
		if(reservas.contains(reserva) == false)
			reservas.add(reserva);
	}
	
	public String getTelefono(){
		return _telefono;
	}
}