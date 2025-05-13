package ec.edu.rsFigueroa.sistemaregistro.negocio;

import ec.edu.rsFigueroa.sistemaregistro.datos.ProductoDAO;
import java.util.List;
import modelo.Persona;
import modelo.Producto;

public class ProductoServicio {

    private final ProductoDAO productoDao;

    public ProductoServicio() {
        this.productoDao = new ProductoDAO();
    }

    public int AgregarNuevoProducto(Producto producto) {
        return productoDao.RegistrarProducto(producto);
    }

    public List<Producto> ObtenerProducto() {
        return productoDao.obtenerProductos();
    }

    public boolean EliminarProductoPorId(int numId) {
        return productoDao.EliminarProducto(numId);
    }

    public boolean ActualizarProducto(int id, Producto producto) {
        return productoDao.ActualizarProducto(id, producto);
    }
}
