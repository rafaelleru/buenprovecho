package IUBuenProvecho;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import BuenProvecho.BuenProvecho;
import BuenProvecho.*;
import java.util.GregorianCalendar;
 
public class PruebaBuenProvecho {
    
    public static void main(String[] args){ 
     
        // Obtener la Ãºnica instancia de la clase BuenProvecho (patrÃ³n sigleton)
        BuenProvecho aComer = BuenProvecho.getInstance(); 
        // Definir la variable que nos permite leer String desde teclado
        final Scanner in = new Scanner(System.in);
        int opcion = 0; 
        do{
            try{ // tratamiento de las excepciones. Bloque try en el que se puede producir una excepciÃ³n y la capturamos
		 
                 //Terminar de diseÃ±ar el menÃº (usando System.out.println(...)) con las opciones que faltan
		 // PodÃ©is hacer vuestros propios diseÃ±os de interfaz, esta es la interfaz mÃ­nima que tenÃ©is que entregar
                System.out.println("\n\n*********************************** MENU ***********************************\n" +
                                       "GESTIÃ“N DE USUARIOS   \n" +
                                     "\t10. Nuevo Responsable Restaurante \n" +
                                     "\t11. Ver todos Responsables Restaurantes \n");	
                                 
                System.out.println("GESTIÃ“N DE RESTAURANTES   \n" +                             
                                    "\t20. Solicitar registro restaurante \n" +
                                    "\t21. Ver restaurantes pendientes de registro \n" +
                                    "\t22. Confirmar registros de restaurantes \n" + 
                                    "\t23. Consultar los restaurantes de un responsable \n" +
                                    "\t24. Actualizar datos de un restaurante \n");
                
                System.out.println("GESTIÃ“N DE RESERVAS   \n" +
                                    "\t30. Solicitar  reserva \n" +
                                    "\t31. Confirmar reserva \n" +
                                    "\t32. Ver las reservas de un usuario \n" +
                                    "\t33. Anular una reserva \n" +
                                    "\t34. Anular reservas pasadas \n");
                
		System.out.println("TERMINAR ");          
                                  System.out.println("\t0. Terminar");
		System.out.println("\n**********************************************************************");
                 
                // Lectura de un int, para darle valor a opcion.
                opcion =Integer.parseInt(in.nextLine()); 
                
                // Estructura switch con todas las opciones de menÃº. Algunos de ellos ya lo tenÃ©is hecho
                // TenÃ©is que terminar las opciones que estÃ¡n incompletas y las que no estÃ¡n hechas
                switch(opcion){
                    case 10:// incluir un nuevo responsable de restaurante en el sistema 
                                            
                        System.out.print("Nombre de responsable:");
                        String nombreUsuario =in.nextLine();
                                       
                        System.out.print("Clave de responsable:");
                        String claveUsuario= in.nextLine();
                        
                        System.out.print("Correo de responsable:");
                        String correoUsuario= in.nextLine();
                        
                        aComer.alteRegistro(nombreUsuario, claveUsuario, correoUsuario);                                             
                        System.out.print("++++++  OperaciÃ³n realizada con Ã©xito ++++++");
                    break;         
                                              
                                     
                    case 11:/*Consultar todos los responsables de restaurantes que hay */
                        
                        List<String> salida = aComer.verResponsables(); // la salida la tenÃ©is que adaptar a la implementaciÃ³n que le deis a vuestras salidas
                        System.out.println("Responsables:");
                        for ( String s : salida) {
                            System.out.println("\t" + s);
                        }                                            
                    break;
//                  
                    case 20: /*Solicitar registro de restaurante */                         
                        System.out.println("Introduzca el nombre del responsable:");
                        String nombreResponsable =in.nextLine();
                        
                        System.out.println("Introduzca el nombre del restaurante:");
                        String nombreRestaurante = in.nextLine();
                        
                        System.out.println("introduzca la provincia:");
                        String provincia = in.nextLine();
                        
                        System.out.println("intorduzca la localidad:");
                        String localidad = in.nextLine();
                        
                        System.out.println("introduzca la direccion:");
                        String direccion = in.nextLine();
                        
                        System.out.println("introduzca la telefono:");
                        String telefono = in.nextLine();
                        
                        aComer.solicitarRegistroRestaurante(nombreResponsable, nombreRestaurante, provincia, localidad, direccion, telefono);
                        System.out.println("++++++  OperaciÃ³n realizada con Ã©xito ++++++");
                    break;
//                  
                    case 21: /* Ver restaurantes pendientes de registro  */
                        List<String> salida1 = aComer.obtenerRestaurantesPendientesAlta();
                        System.out.println("Restaurantes pendiente de:");
                        for ( String s : salida1) {
                            System.out.println("\t" + s);
                        }                                   
                    break;             
                        
//                  
                    case 22: /* Cofirmar registro de restaurante  */
                        String Final = "0000";
                        ArrayList<String> lista = new ArrayList();
                        String numero = "1";
                        Boolean sonIguales = false;
                        while(!sonIguales){
                            System.out.println("Escriba el telefono del restaurante que desea confirmar,\nsi no quiere añadir mas restaurantes escriba 0000" ); 
                            numero = in.nextLine();
                            lista.add(numero);
                            sonIguales = numero.equals(Final);                
                        }
                        
                        aComer.confirmarRegistroRestaurante(lista);
                        System.out.println("++++++  OperaciÃ³n realizada con Ã©xito ++++++");
                    break;
// 
                        
                    case 23: /* Consultar los restaurantes de un responsable  */
                        System.out.println("introduzca el nombre del responsable");
                        String nombreResponsableRestaurante = in.nextLine();
                        ArrayList<Restaurante> salida2 = aComer.obtenermisRestaurantes(nombreResponsableRestaurante); // la salida la tenÃ©is que adaptar a la implementaciÃ³n que le deis a vuestras salidas
                          
                        for(int i = 0; i < salida2.size(); i++){
                            System.out.print(salida2.get(i).getNombreRestaurante());
                        }
                        System.out.println("++++++  OperaciÃ³n realizada con Ã©xito ++++++");
                    break;
//
                    case 24: /*Actualizar datos de un restaurante */
                        System.out.println("introduzca el telefono del restaurante");
                        String tlf =in.nextLine();
                        
                        System.out.println("Introduzca el nuevo nombre del restaurante:");
                        String nombreA = in.nextLine();
                        
                        System.out.println("introduzca el nuevo telefono:");
                        String telefonoA = in.nextLine();
                        
                        System.out.println("introduzca el tipo de cocina:");
                        String tipoCocina = in.nextLine();
                        
                        System.out.println("intorduzca el precio medio:");
                        String precioMedio = in.nextLine();
                        
                        float precio = Integer.parseInt(precioMedio);
                        
                        System.out.println("introduzca la descripcion:");
                        String descripcion = in.nextLine();
                        
                        System.out.println("introduzca el horario");
                        String horario = in.nextLine();
                        
                        
                        aComer.actualizarDatosRestaurante(tlf, nombreA, telefonoA, tipoCocina, precio, descripcion, horario);
                        
                        System.out.println("++++++  OperaciÃ³n realizada con Ã©xito ++++++");
                    break;
//    
                    case 30: /* Solicitar Reserva */
                        GregorianCalendar fecha = new GregorianCalendar();
                        fecha = aComer.getFecha();
                        
                                                                    
                        System.out.print("Nombre de usuario:");
                        String usuario = in.nextLine();
                                       
                        System.out.print("Correo de usuario:");
                        String correo = in.nextLine();
                        
                        System.out.print("Telefono de contacto:");
                        String tlfUsuario = in.nextLine();
                        
                        System.out.print("Telefono del restaurante:");
                        String tlfRestaurante = in.nextLine();
                        
                        System.out.print("¿Cuantos comensales acudiran?");
                        int numeroComensales = Integer.parseInt(in.nextLine());
                        
                        String cod = aComer.solicitarReservaRestaurante(usuario, correo, tlfUsuario, tlfRestaurante, fecha, numeroComensales);
                        System.out.print("Su reserva se ha registrado con exito, su codigo de reserva es: " + cod);
                        
                    break;
//
                    case 31: /* Confirmar Reserva */
                        System.out.print("Introduzca el codigo de la reserva que desea confirmar:");
                        String codReserva =  in.nextLine();
                        
                        System.out.print("Introduzca el telefono del restaurante: ");
                        String tlfReserva = in.nextLine();
                        
                        aComer.confirmarReserva(codReserva, tlfReserva);
                        System.out.print("Reserva confirmada con exito, que aproveche.");
                                                
                    break;
//
                    case 32: /*  Ver las reservas de un usuario */
                        System.out.print("Introduzca su telefono: ");
                        String tlfUser = in.nextLine();
                                     
                        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
                        reservas = aComer.consultarMisreservas(tlfUser);
                        
                        for(int i = 0; i < reservas.size(); i++){
                            System.out.print("Reserva numero " + Integer.toString(i));
                            System.out.print(reservas.get(i).obrenerDatosReserva());
                        }                       
                    break;
//
                    case 33: /* Anular una reserva   */
                            System.out.print("Introduzca el codigo de la reserva que desea anular: ");
                            String codAnula = in.nextLine();
                            
                            System.out.print("Introduzca su nombre de usuario: ");
                            String usuarioAnula = in.nextLine();
                            
                            aComer.anularReserva(codAnula, usuarioAnula);
                            System.out.print("Reserva anulada correctamente, esperamos verle pronto.");
                    break;
//
                    case 34: 
//                        
                            aComer.eliminaReservasPasadasClientesNoHabituales();
                            
                            System.out.print("Todas las reservas eliminadas.");
                    break;

                    case 0: /* terminar */
                    break;                        
                                    
                    default:
                        System.out.println("opcion no vÃ¡lida");
                    break;
                }
//               
            }catch(Exception ex){ // captura de la excepciÃ³n
                System.err.println("se ha producido la siguiente excepcion: "+ ex);
            } 
        }while(opcion !=0); 
        System.exit(0);
    }  

}