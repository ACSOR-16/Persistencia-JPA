package tienda.prueba;

import tienda.dao.ProductoDAO;
import tienda.modelo.Categoria;
import tienda.modelo.Producto;
import tienda.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class RegistroDeProducto {
    public static void main(String[] args) {
        Categoria celulares = new Categoria("celulares");

        EntityManager em = JPAUtils.getEntityManager();

        em.getTransaction().begin();

        em.persist(celulares);

        celulares.setNombre("LIBROS");

        em.flush();
        em.clear();

        celulares = em.merge(celulares);
        // NO SE CONSIDERA POR QUE YA SE CIERRA LA CONEXCION
        celulares.setNombre("SOFTWARES");

        em.flush();
        em.clear();
        celulares = em.merge(celulares);
        em.remove(celulares);
        em.flush();
    }
}
