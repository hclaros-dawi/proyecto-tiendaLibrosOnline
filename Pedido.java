import java.util.List;
public class Pedido {
    private List<Libro> libros; //Crea una lista para los libros
    private String infoEnvio; //String que almacena la información del libro
    private String metodoPago; //String que almacena el método de pago

    //Constructor de la clase Pedido, inicializa sus atributos
    public Pedido(List<Libro> libros, String infoEnvio, String metodoPago) {
        this.libros = libros;
        this.infoEnvio = infoEnvio;
        this.metodoPago = metodoPago;
    }

    //Getters y setters
    public List<Libro> getLibros() {
        return libros;
    }
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
    public String getInfoEnvio() {
        return infoEnvio;
    }
    public void setInfoEnvio(String infoEnvio) {
        this.infoEnvio = infoEnvio;
    }
    public String getMetodoPago() {
        return metodoPago;
    }
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

}
