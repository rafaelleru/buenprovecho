package IUBuenProvecho;
import java.util.List;
import java.util.Scanner;
import BuenProvecho.BuenProvecho;
 
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
//                  case 20: /*Soliciatar registro de restaurante */                         
//                                                     
//                  break;
//                  
//                  case21: /* Ver restaurantes pendientes de registro  */
//                                                   
//                  break;             
//                  
//                  case 22: /* Cofirmar registro de restaurante  */
//                                                    
//                  break;
// 
//                  case 23: /* Consultar los restaurantes de un responsable  */
//                                                     
//                  break;
//
//                  case 24: /*Actualizar datos de un restaurante */
//                                                        
//                  break;
//    
//                  case 30: /* Solicitar Reserva */
//                                        
//                  break;
//
//                  case 31: /* Confirmar Reserva */
//                                                
//                  break;
//
//                  case 32: /*  Ver las reservas de un usuario */
//                                  
//                  break;
//
//                  case 33: /* Anular una reserva   */
//
//                  break;
//
//                  case 34: /* Anular reservas pasadas */ 
//                                        
//                  break;

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