package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class persistenceUtil {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaRegistroUsuario");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public static void Cerrar() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
