import java.util.Comparator;
public class Libro implements Comparable<Libro> {
    private String titulo;
    private String autor;
    private String genero;
    private double precio;

    public Libro(String titulo, String autor, String genero, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método toString para mostrar información sobre el objeto Libro
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    // Comparable para comparar libros por precio
    public int compareTo(Libro Libro2) {
        // Método de compareTo que recibe dos argumentos
        // precio del objeto libro y el precio del otro libro
        return Double.compare(this.precio, Libro2.getPrecio());
    }
}
