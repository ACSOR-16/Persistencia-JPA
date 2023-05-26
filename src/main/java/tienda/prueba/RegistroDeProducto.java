package tienda.prueba;

import tienda.modelo.Producto;

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

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.close();
    }
}
