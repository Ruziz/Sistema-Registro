package ec.edu.rsFigueroa.sistemaregistro.negocio;

import modelo.Persona;
import ec.edu.rsFigueroa.sistemaregistro.datos.PersonaDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class PersonaServicio {

    private final PersonaDAO personaDao;

    public PersonaServicio() {
        this.personaDao = new PersonaDAO();
    }

//    public void AgregarNuevaPersona(Persona persona){
//        try{
//            personaDao.agregarPersona(persona);
//        }catch(SQLException ex){
//            System.out.println("Error en capa de negocio: No se puede agregar persona " + ex);
//        }
//    }
    public int AgregarNuevsPersona(Persona persona) {
        LocalDate fecha_nacimiento = persona.getFecha_nacimiento();

        // se verifica que la persona sea mayor de edad para registrar
        if (calcularEdad(fecha_nacimiento) >= 18) {
            persona.setEdad(calcularEdad(fecha_nacimiento));
            // Ajusto el nombre y apellido para almacenarlo en formato de MAY.
            String nombrePersona = persona.getNombre().toUpperCase(); // Mayusculas
            persona.setNombre(nombrePersona);

            String apellidoPersona = persona.getApellido().toUpperCase(); // Minusculas
            persona.setApellido(apellidoPersona);

            return personaDao.RegistrarPersona(persona);
        } else {
            return 3;
        }
    }

    public List<Persona> ObtenerPersona() {
        return personaDao.obtenerPersona();
    }

    public int calcularEdad(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            return 0;
        }

        LocalDate actual = LocalDate.now();
        System.out.println("edad -> " + Period.between(fechaNacimiento, actual).getYears());
        return Period.between(fechaNacimiento, actual).getYears();
    }

    public boolean EliminarPersonaPorId(int numId) {
        return personaDao.EliminarPersona(numId);
    }

    public boolean ActualizarPersona(int id, Persona persona) {
        LocalDate fecha_nacimiento = persona.getFecha_nacimiento();
        persona.setEdad(calcularEdad(fecha_nacimiento));
        return personaDao.ActualizarPersona(id, persona);
    }

}
