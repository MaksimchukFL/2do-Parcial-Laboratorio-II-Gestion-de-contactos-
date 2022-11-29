public class Contacto extends Persona {

    public Contacto(String nombre, String apellido, String telefono, String email, int dni) {
        super(nombre,apellido,telefono,email,dni);
    }


    @Override
    public String toString() {
        return "["+nombre+","+apellido+" telefono: "+telefono+" email: "+email+" DNI: "+dni+"]";
    }
}
