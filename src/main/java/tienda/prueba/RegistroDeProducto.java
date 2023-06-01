package tienda.prueba;

import tienda.dao.CategoriaDAO;
import tienda.dao.ProductoDAO;
import tienda.modelo.Categoria;
import tienda.modelo.CategoriaId;
import tienda.modelo.Producto;
import tienda.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RegistroDeProducto {
    public static void main(String[] args) {
        registrarProducto();
        EntityManager em = JPAUtils.getEntityManager();
        ProductoDAO productoDAO = new ProductoDAO(em);
        Producto producto = productoDAO.consultaPorId(1L);
        System.out.println(producto.getNombre());

//        List<Producto> productos = productoDAO.consultaPorNombreDeCategoria("CELULARES");
//        productos.forEach(prod -> System.out.println(prod.getDescripcion()));
        BigDecimal precio = productoDAO.consultarPrecioPorNombreDeProducto("Xiaomi Redmi");
        System.out.println(precio);

        Categoria find = em.find(Categoria.class, new CategoriaId("CELULARES", "nombreramdom"));
        System.out.println(find.getNombre());
    }

    private static void registrarProducto() {
        Categoria celulares = new Categoria("CELULARES");

        Producto celular = new Producto(
                "Xiaomi Redmi",
                "Muy Legal",
                new BigDecimal("800"),
                celulares);

        EntityManager em = JPAUtils.getEntityManager();
        ProductoDAO productoDAO = new ProductoDAO(em);
        CategoriaDAO categoriaDao = new CategoriaDAO(em);

        em.getTransaction().begin();

        categoriaDao.guardar(celulares);
        productoDAO.guardar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
