package tienda.prueba;

import tienda.dao.PedidoDAO;
import tienda.modelo.Pedido;
import tienda.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.io.FileNotFoundException;

public class PruebaDeDesempenho {
    public static void main(String[] args) throws FileNotFoundException {
        LoadRecords.cargarRegistros();

        EntityManager em = JPAUtils.getEntityManager();

        PedidoDAO pedidoDAO = new PedidoDAO(em);
        Pedido pedidoConCliente = pedidoDAO.consultarPedidoConCliente(2L);
        em.close();
        System.out.println(pedidoConCliente.getCliente().getNombre());

//        Pedido pedido = em.find(Pedido.class, 31);//
//        System.out.println(pedido.getFecha());
//        System.out.println(pedido.getItems().size());
//        System.out.println(pedido.getCliente().getNombre());
    }
}
