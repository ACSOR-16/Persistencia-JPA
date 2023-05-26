package tienda.prueba;

import tienda.dao.ProductoDAO;
import tienda.modelo.Producto;
import tienda.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class RegistroDeProducto {
    public static void main(String[] args) {
        Producto celular = new Producto();

        celular.setNombre("Samsung");
        celular.setDescripcion("celular usado");
        celular.setPrecio(new BigDecimal("1000"));

//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
        EntityManager em = JPAUtils.getEntityManager();

        ProductoDAO productoDAO = new ProductoDAO(em);

        em.getTransaction().begin();

        productoDAO.guardar(celular);
//        em.persist(celular);
        em.getTransaction().commit();
        em.close();
    }
}
