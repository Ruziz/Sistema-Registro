package ec.edu.rsFigueroa.sistemaregistro.negocio;

import ec.edu.rsFigueroa.sistemaregistro.datos.PersonaDAO;
import ec.edu.rsFigueroa.sistemaregistro.datos.FacturaDAO;
import ec.edu.rsFigueroa.sistemaregistro.datos.ProductoDAO;
import modelo.*;

public class FacturaServicio {

    private final PersonaDAO personaDao;
    private final ProductoDAO productoDao;
    private final FacturaDAO facturaDao;

    public FacturaServicio() {
        this.personaDao = new PersonaDAO();
        this.productoDao = new ProductoDAO();
        this.facturaDao = new FacturaDAO();
    }

    public Persona BuscarPersonaPorCedula(String cedula) {
        Persona personaEncontrada = this.personaDao.BuscarPersonaPorCedula(cedula);
        if (personaEncontrada == null) {
            System.out.println("No existe esa persona con ese num de cedula");
        } else {
            System.out.println("Se encontrodo los detalles de la persona");
        }
        return personaEncontrada;
    }

    public Producto BuscarProductoPorCodigo(String codigo) {
        Producto productoEncontrado = this.productoDao.BuscarProductoPorCodigo(codigo);
        if (productoEncontrado == null) {
            System.out.println("No existe ese producto con ese num de codigo");
        } else {
            System.out.println("Se encontrodo los detalles del producto");
        }
        return productoEncontrado;
    }

    public Factura ObtenerFacturaCompleta(int idFactura) {
        return this.facturaDao.obtenerFacturaCompletaPorId(idFactura);
    }

    public void RegistrarNuevaFactura(Factura nuevaFactura) {
        this.facturaDao.RegistrarFactura(nuevaFactura);
    }

}
