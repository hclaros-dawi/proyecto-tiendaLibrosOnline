//Definición de la excepción ClienteInvalidoException
//Se lanza cuando se intenta crear un cliente con datos inválidos
class ClienteInvalidoException extends Exception {
    //Constructor de la clase ClienteInvalidoException que recibe un mensaje de error como parámetro
    public ClienteInvalidoException(String mensaje) {
        //Llama al constructor de la clase padre (Exception) con el mensaje recibido como argumento
        super(mensaje);
    }
}

//Clase abstracta Cliente, que representa un cliente genérico
abstract class Cliente {
    //Atributos de la clase Cliente
    private String nombre;
    private String direccion;
    private String correoElectronico;

    //Constructor de la clase Cliente, inicializa sus atributos
    public Cliente(String nombre, String direccion, String correoElectronico) throws ClienteInvalidoException {
        if (nombre == null || nombre.isEmpty() || direccion == null || direccion.isEmpty() || correoElectronico == null || correoElectronico.isEmpty()) {
            throw new ClienteInvalidoException("Los datos del cliente son inválidos.");
        }
        //Asigna los valores que se pasan del cliente a los atributos
        this.nombre = nombre;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}