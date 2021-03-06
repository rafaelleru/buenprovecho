package BuenProvecho;

import java.util.GregorianCalendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Scanner;

import BuenProvecho.ResponsableRestaurante;
import BuenProvecho.Restaurante;
import BuenProvecho.Usuario;

import java.util.ArrayList;

public class BuenProvecho {
	public BuenProvecho _unnamed_BuenProvecho_;
	public ArrayList<Usuario> _unnamed_Usuario_ = new ArrayList<Usuario>();
	public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	public ArrayList<ResponsableRestaurante> responsables = new ArrayList<ResponsableRestaurante>();
	public ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
	private static BuenProvecho instance = new BuenProvecho();
	
	public static BuenProvecho getInstance(){
		return instance;
	}

	public void solicitarRegistroRestaurante(String nombreUsuario, String nombre, String provincia, String localidad, String direccion, String telefono) {
		Restaurante miRestaurante = new Restaurante();
		miRestaurante.crear(nombre, provincia, localidad, direccion, telefono); 
		ResponsableRestaurante unResponsable = buscarResponsable(nombreUsuario);
        unResponsable.incluirRestaurante(miRestaurante);
        miRestaurante.activarRestaurante();
        restaurantes.add(miRestaurante);
	}

	public ArrayList obtenerRestaurantesPendientesAlta() {
		ArrayList<Restaurante> pendientes = new ArrayList();
		
		for(int i = 0; i < restaurantes.size(); i++){
			if(restaurantes.get(i).pendienteAlta())
				pendientes.add(restaurantes.get(i));
		}
		
		return pendientes;
	}

	public void confirmarRegistroRestaurante(ArrayList<String> listaTelefonosRestaurantes) {
		ArrayList<Restaurante> listaRestaurantes = new ArrayList();
		listaRestaurantes = seleccionarRestaurantes(listaTelefonosRestaurantes);
	        
		for (int i = 0; i < listaRestaurantes.size();i++)
	         listaRestaurantes.get(i).activarRestaurante();	}

    public void anularReserva(String codigoReserva, String nombreUsuario) {
        Usuario unUsuario = buscarUsuario(nombreUsuario);
        unUsuario.anularReserva(codigoReserva);
       	boolean tieneReservas = unUsuario.tienesReserva();
       	if(tieneReservas == false){
       		usuarios.remove(unUsuario);
        }
    }

	public ArrayList<Restaurante> obtenermisRestaurantes(String nombreUsuario) {
		ResponsableRestaurante responsable = buscarResponsable(nombreUsuario);
		return responsable.obtenerMisRstaurantes();
	}

	public String solicitarReservaRestaurante(String aNombreUsuario, String aCorreo, String aTelefono, String aTelefonoRestaurante, GregorianCalendar fecha, int aNumeroComensales) {
		
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
		unRestaurante.registrarReserva(unUsuario, fecha, aNumeroComensales);//essto incluye la reserva en el restaurante
		miReserva.crear(unUsuario, unRestaurante, fecha, aNumeroComensales); 
		
		unUsuario.incluirReserva(miReserva);
                
                return miReserva.getCodigoReserva();
		
		}

	public void confirmarReserva(String codigoReserva, String telefonoRestaurante) {
		Restaurante restaurante = buscarRestaurante(telefonoRestaurante);
		restaurante.confirmarReserva(codigoReserva);
	}

        public ArrayList<Reserva> consultarMisreservas(String telefonoUsuario) {
        	Usuario unUsuario = buscarUsuario(telefonoUsuario);
            return unUsuario.consultarMisReservas();
	}

	public void eliminaReservasPasadasClientesNoHabituales() {
		
		for(int i=0; i < usuarios.size(); i++){
			usuarios.get(i).eliminarReservasPasadas();
			
			if(usuarios.get(i).tienesReserva())
				usuarios.remove(usuarios.get(i));
		}
	}

	public void alteRegistro(String aNombreUsuario, String aClave, String aCorreo) throws Exception {
		boolean existe = existeResponsableRestaurante(aNombreUsuario);
		
		if (existe == false){
            ResponsableRestaurante unUsuarioRegistrado = new ResponsableRestaurante();
            unUsuarioRegistrado.crear(aNombreUsuario, aClave, aCorreo);
            responsables.add(unUsuarioRegistrado);
		}
        else{
            throw new Exception("Este usuario ya esta dado de alta");
        }
	}

	private boolean existeResponsableRestaurante(String aNombreUsuario) {
		boolean esta = false;
		
		for(int i = 0; i < responsables.size() && !esta; i++){
			if(responsables.get(i).getNombre() == aNombreUsuario)
				esta = true;
		}
		
		return esta;
	}

	public void actualizarDatosRestaurante(String aTelefono, String aNombre, String aNuevoTelefono, String aTipoCocina, float precioMedio, String descripcion, String aHorario) {
            Restaurante unRestaurante = buscarRestaurante(aTelefono);            
            unRestaurante.actualizarRestaurante(aTipoCocina, precioMedio, descripcion, aHorario);
            }

	private ResponsableRestaurante buscarResponsable(String aNombreUsuario) {
            boolean encontrado = false;
            int i = 0;
                    
            for(i=0 ; i < responsables.size() && encontrado == false; i++){
                if(responsables.get(i).getNombre() == aNombreUsuario)
                    encontrado = true;
            }
            return responsables.get(i);

            
        }

	private Usuario buscarUsuario(String aTelefonoUsuario) {
            boolean encontrado = false;
            int i;
            
            for(i=0; i < usuarios.size() && encontrado == false; i++){
                if(usuarios.get(i).getTelefono() == aTelefonoUsuario)
                    encontrado = true;
         }
            
            return usuarios.get(i);
        }

	public ArrayList<Restaurante> seleccionarRestaurantes(ArrayList<String> aListaTelefonosRestaurantes) {
		ArrayList<Restaurante> seleccionados = new ArrayList<Restaurante>();
                
                for(int j = 0; j < aListaTelefonosRestaurantes.size(); j++){
                    for(int i = 0; i < restaurantes.size(); i++){
                        if(restaurantes.get(i).getTelefono() == aListaTelefonosRestaurantes.get(j))
                            seleccionados.add(restaurantes.get(i));
                    }
                }
                
                return seleccionados;
	}
	
	/*
	 * Metodo privado para encapsular la recogida de la fecha para las reservas
	 * */
	public GregorianCalendar getFecha(){
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

	public ArrayList<String> verResponsables() {
		ArrayList<String> responsable = new ArrayList<String>();
		
		for(int i = 0; i < responsables.size(); i++){
			responsable.add(responsables.get(i).getNombre());
		}
		
		return responsable;
}
	
}