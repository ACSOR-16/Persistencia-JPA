package tienda.prueba;

import tienda.dao.CategoriaDao;
import tienda.dao.ClienteDAO;
import tienda.dao.ProductoDAO;
import tienda.modelo.*;
import tienda.utils.JPAUtils;
import tienda.dao.PedidoDAO;
import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RegistroDePedido {
    public static void main(String[] args) {
        registrarProducto();

        EntityManager em = JPAUtils.getEntityManager();

        ProductoDAO productoDAO = new ProductoDAO(em);
        Producto producto = productoDAO.consultaPorId(1L);

        ClienteDAO clienteDAO = new ClienteDAO(em);
        PedidoDAO pedidoDao = new PedidoDAO(em);

        Cliente cliente = new Cliente("juan", "70440047");
        Pedido pedido = new Pedido(cliente);
        pedido.agregarItems(new ItemsPedido(5, producto, pedido));

        em.getTransaction().begin();

        clienteDAO.guardar(cliente);
        pedidoDao.guardar(pedido);

        em.getTransaction().commit();
//        em.close();
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
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.guardar(celulares);
        productoDAO.guardar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
