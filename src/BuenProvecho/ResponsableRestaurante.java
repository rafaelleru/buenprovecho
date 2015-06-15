package BuenProvecho;

import java.util.ArrayList;
import BuenProvecho.Restaurante;


public class ResponsableRestaurante {
	private String _nombreUsuario;
	private String _clave;
	private String _correo;
	private ArrayList<Restaurante> misRestaurantes;

	void crear (String aBreusuario, String aClave, String aCorreo) {
		_nombreUsuario = aBreusuario;
		_clave = aClave;
		_correo = aCorreo;
		misRestaurantes = new ArrayList<Restaurante>();
	}

	void incluirRestaurante(Restaurante aMiRestaurante) {
		misRestaurantes.add(aMiRestaurante);
	}

	ArrayList<Restaurante> obtenerMisRstaurantes() {
		return misRestaurantes;
	}

	public String getNombre() {
		return _nombreUsuario;
	}
	
	public String getCorreo(){
		return _correo;
	}
	
	public String getClave(){
		return _clave;
	}
}