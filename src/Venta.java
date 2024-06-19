import java.util.Date;

public class Venta {
    private final int id;
    private final Date fecha;
    private final Libro libro;
    private final int cantidad;

    public Venta(int id, Libro libro, int cantidad) {
        this.id = id;
        this.fecha = new Date();
        this.libro = libro;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ID=" + id +
                ", Fecha=" + fecha +
                ", Libro='" + libro.getTitulo() + '\'' +
                ", Cantidad=" + cantidad +
                ", Precio=" + libro.getPrecio()* cantidad;
    }
}
