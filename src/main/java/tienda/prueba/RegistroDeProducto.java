package tienda.prueba;

import tienda.dao.CategoriaDao;
import tienda.dao.ProductoDAO;
import tienda.modelo.Categoria;
import tienda.modelo.Producto;
import tienda.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class RegistroDeProducto {
    public static void main(String[] args) {
        registrarProducto();
        EntityManager em = JPAUtils.getEntityManager();
        ProductoDAO productoDAO = new ProductoDAO(em);
        Producto producto = productoDAO.consultaPorId(1L);
        System.out.println(producto.getNombre());

        List<Producto> productos = productoDAO.consultarTodos();
        productos.forEach(prod -> System.out.println(prod.getDescripcion()));
    }

    private static void registrarProducto() {
        Categoria celulares = new Categoria("CELULARES");

        Producto celular = new Producto(
                "Xiaomi Redmi",
                "Muito Legal",
                new BigDecimal("800"),
                celulares);

        EntityManager em = JPAUtils.getEntityManager();
        ProductoDAO productoDAO = new ProductoDAO(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.guardar(celulares);
        productoDAO.guardar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
