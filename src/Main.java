import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner entradamenu=new Scanner(System.in);
        int seleccion=0;
        LinkedList<Contacto> listacontactos=new LinkedList<Contacto>();

        while(seleccion!=99) {
            System.out.println("ADMINISTRADOR DE CONTACTOS:\n1)Nuevo contacto\n2)Listar todos los contactos\n3)Buscar contacto por nombre o apellido\n4)Buscar contacto por DNI\n5)Eliminar contacto por DNI\n6)Imprimir en un archivo\n7)Editar Contacto\n99)Salir\nIngrese una opcion: ");
            seleccion = entradamenu.nextInt();
            Scanner entrada = new Scanner(System.in);

            switch (seleccion) {
                case 1:
                    try {
                        System.out.println("Nombre: ");
                        String nom = entrada.nextLine();
                        System.out.println("Apellido: ");
                        String ap = entrada.nextLine();
                        System.out.println("DNI: ");
                        int dni = entrada.nextInt();
                        entrada.nextLine();
                        System.out.println("Telefono: ");
                        String tel = entrada.nextLine();
                        System.out.println("Email: ");
                        String email = entrada.nextLine();

                        Contacto contacto = new Contacto(nom, ap, tel, email, dni);
                        listacontactos.add(contacto);
                        System.out.println("Contacto cargado con éxito");
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR EN EL INGRESO DE DATOS");
                    }
                    break;
                case 2:
                    for (Contacto contacto : listacontactos
                    ) {
                        System.out.println(contacto.toString());
                    }
                    System.out.println("Cantidad de contactos: " + listacontactos.size());
                    break;
                case 3:
                    System.out.println("Ingrese un nombre o un apellido: ");
                    String busq = entrada.nextLine();
                    System.out.println("Contactos encontrados: ");
                    for (Contacto contacto : listacontactos
                    ) {
                        if (busq.equals(contacto.nombre) || busq.equals(contacto.apellido)) {
                            System.out.println(contacto.toString());
                        } else {
                            System.out.println("NO EXISTEN CONTACTOS QUE COINCIDAN CON EL CRITERIO");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ingrese un DNI: ");
                    int dnibusq = entrada.nextInt();
                    System.out.println("Contactos encontrados: ");
                    for (Contacto contacto : listacontactos
                    ) {
                        if (dnibusq == contacto.dni) {
                            System.out.println(contacto.toString());
                        } else {
                            System.out.println("NO EXISTEN CONTACTOS QUE COINCIDAN CON DNI: " + dnibusq);
                        }
                    }

                    break;
                case 5:
                    System.out.println("Ingrese un DNI: ");
                    int dnielimbusq = entrada.nextInt();
                    for (Contacto contacto : listacontactos
                    ) {
                        if (dnielimbusq == contacto.dni) {
                            listacontactos.remove(contacto);
                            System.out.println("CONTACTO ELIMINADO CON EXITO");
                        } else {
                            System.out.println("NO EXISTEN CONTACTOS QUE COINCIDAN CON DNI: " + dnielimbusq);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el nombre del archivo a guardar: ");
                    String nombrearchivo = entrada.nextLine();
                    try {
                        FileWriter escriturua = new FileWriter(nombrearchivo + ".txt", true);
                        for (Contacto contacto : listacontactos
                        ) {
                            for (int i = 0; i < contacto.toString().length(); i++) {
                                escriturua.write(contacto.toString().charAt(i));
                            }
                            escriturua.write("\n");

                        }
                        escriturua.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                case 7:
                    System.out.println("Ingrese el DNI del contacto a editar: ");
                    int dnibusc=entrada.nextInt();
                    entrada.nextLine();
                    for (Contacto contacto:
                         listacontactos) {
                        if (dnibusc == contacto.dni) {
                            System.out.println("Ingrese la opcion del dato a editar: \n1)Nombre\n2)Apellido\n3)Dni\n4)Telefono\n5)Email");
                            int opcdat = entrada.nextInt();
                            entrada.nextLine();
                            switch (opcdat) {
                                case 1:
                                    System.out.println("Ingrese el nombre: ");
                                    String nuevonombre = entrada.nextLine();
                                    contacto.nombre=nuevonombre;
                                    System.out.println("Nombre cambiado.");
                                    break;
                                case 2:
                                    System.out.println("Ingrese el apellido: ");
                                    String nuevoapellido = entrada.nextLine();
                                    contacto.apellido=nuevoapellido;
                                    System.out.println("Apellido cambiado.");
                                    break;
                                case 3:
                                    System.out.println("Ingrese el DNI: ");
                                    int nuevodni = entrada.nextInt();
                                    entrada.nextLine();
                                    contacto.dni=nuevodni;
                                    System.out.println("DNI cambiado.");
                                    break;
                                case 4:
                                    System.out.println("Ingrese el telefono: ");
                                    String nuevotelefono = entrada.nextLine();
                                    contacto.telefono=nuevotelefono;
                                    System.out.println("Telefono cambiado.");
                                    break;
                                case 5:
                                    System.out.println("Ingrese el email: ");
                                    String nuevoemail = entrada.nextLine();
                                    contacto.email=nuevoemail;
                                    System.out.println("Email cambiado.");
                                    break;
                            }

                        } else{
                            System.out.println("NO EXISTEN CONTACTOS CON EL DNI: "+dnibusc);
                        }
                    }

                    break;
                default:
                    System.out.println("OPCION INCORRECTA");
            }
        }
    }
}
