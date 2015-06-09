package BuenProvecho;

import java.util.GregorianCalendar;
import java.util.Date;
import java.util.Vector;
import java.util.Scanner;

import BuenProvecho.ResponsableRestaurante;
import BuenProvecho.Restaurante;
import BuenProvecho.Usuario;

import java.util.ArrayList;

public class BuenProvecho {
	public BuenProvecho _unnamed_BuenProvecho_;
	public Vector<Usuario> _unnamed_Usuario_ = new Vector<Usuario>();
	public Vector<Usuario> usuarios = new Vector<Usuario>();
	public Vector<ResponsableRestaurante> _registra = new Vector<ResponsableRestaurante>();
	public Vector<Restaurante> restaurantes = new Vector<Restaurante>();

	public void solicitarRegistroRestaurante(String aNombreUsuario, String aNombre, String aProvincia, String aLocalidad, String aDireccion, String aTelefono) {
		throw new UnsupportedOperationException();
	}

	public ArrayList obtenerRestaurantesPendientesAlta() {
		throw new UnsupportedOperationException();
	}

	public void confirmarRegistroRestaurante(String[] aListaTElefonosRestaurantes) {
		throw new UnsupportedOperationException();
	}

	public ArrayList anularReserva(String aCodREserva, String aTeledonoUsuario) {
		throw new UnsupportedOperationException();
	}

	public ArrayList obtenermisRestaurantes(String aNombreUsuario) {
		throw new UnsupportedOperationException();
	}

	public void solicitarReservaRestaurante(String aNombreUsuario, String aCorreo, String aTelefono, String aTelefonoRestaurante, GregorianCalendar fecha, int aNumeroComensales) {
		
		Usuario unUsuario = new Usuario();
		Restaurante unRestaurante = new Restaurante();
		Reserva miReserva = new Reserva();
		
		//comprobar si existe un usuario si no crearlo
		if(existeUsuario(aTelefono))
			unUsuario = buscarUsuario(aTelefono);
		else{
			unUsuario.crear(aNombreUsuario, aCorreo, aTelefono);
			incluirUsuario(unUsuario);
		}
		
		//buscar un restaurante
		unRestaurante = buscarRestaurante(aTelefonoRestaurante);
		
		//crear la reserva y enlazarla con restaurante y usuario
		unRestaurante.registrarReserva(unUsuario, fecha, aNumeroComensales);
		miReserva.crear(unUsuario, unRestaurante, fecha, aNumeroComensales);
		
		unRestaurante.incluirReserva(miReserva);
		unUsuario.incluirReserva(miReserva);
		
		}

	public void confirmarReserva(String aCodigoReserva, String aTelefonoRestaurante) {
		throw new UnsupportedOperationException();
	}

	public ArrayList consultarMisreservas(String aTelefonoUsuario) {
		throw new UnsupportedOperationException();
	}

	public void eliminaReservasPasadasClientesNoHabituales() {
		throw new UnsupportedOperationException();
	}

	public void alteRegistro(String aNombreUsuario, String aClave, String aCorreo, String aTipoUsuario) {
		throw new UnsupportedOperationException();
	}

	private boolean existeResponsableRestaurante(String aNombreUsuario) {
		throw new UnsupportedOperationException();
	}

	public void actualizarDatosRestaurante(String aTelefono, String aNombre, String aNuevoTelefono, String aTipoCocina, float precioMedio, String descripcion, String aHorario) {
		throw new UnsupportedOperationException();
	}

	private ResponsableRestaurante buscarResponsable(String aNombreUsuario) {
		throw new UnsupportedOperationException();
	}

	private Usuario buscarUsuario(String aTelefonoUsuario) {
		throw new UnsupportedOperationException();
	}

	private Restaurante[] seleccionarRestaurantes(String[] aListaTelefonosRestaurantes) {
		throw new UnsupportedOperationException();
	}
	
	/*
	 * Metodo privado para encapsular la recogida de la fecha para las reservas
	 * */
	private GregorianCalendar getFecha(){
		Scanner sc = new Scanner(System.in);
		
		// cogemos la fecha desde teclado
		System.out.print("dia : ");
		int dia= Integer.parseInt(sc.nextLine());
		System.out.print("mes : ");
		int mes = Integer.parseInt(sc.nextLine());
		System.out.print("hora :  ");
		int hora= Integer.parseInt(sc.nextLine());
		System.out.print("minutos :  ");
		int minutos = Integer.parseInt(sc.nextLine());
		
		GregorianCalendar fecha = new GregorianCalendar(2015,mes,dia,hora,minutos);
		
		return fecha;
	}
	
	//comprobar si existe un usuario
	private boolean existeUsuario(String tlf){
		
		boolean existe = true;
		
		for(int i = 0; i < usuarios.size(); i++){
			if(usuarios.get(i).getTelefono() == tlf)
				existe= true;
			else existe =   false;
		}
		return existe;
	}
	
	private Restaurante buscarRestaurante(String tlf){
		Restaurante unRestaurante = new Restaurante();
		
		for(int i = 0; i < restaurantes.size(); i++){
			if(restaurantes.get(i).getTelefono() == tlf)
				unRestaurante =  restaurantes.get(i);
		}
		
		return unRestaurante;
	}
	//incluir un usuario en el array de usuarios
	private void incluirUsuario(Usuario miusuario){
		usuarios.add(miusuario);
	}
}