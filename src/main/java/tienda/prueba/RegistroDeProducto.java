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
        Producto celular = new Producto(
                "Samsung",
                "Celular Reacondicionado",
                new BigDecimal("1000"),
                celulares);

        EntityManager em = JPAUtils.getEntityManager();

        ProductoDAO productoDAO = new ProductoDAO(em);

        em.getTransaction().begin();

        productoDAO.guardar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
