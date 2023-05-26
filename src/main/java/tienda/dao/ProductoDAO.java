package tienda.dao;

import tienda.modelo.Categoria;
import tienda.modelo.Producto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductoDAO {
    private EntityManager em;

    public ProductoDAO(EntityManager em) {
        this.em = em;
    }

    public void guardar(Producto producto) {
        this.em.persist(producto);
    }

    public Producto consultaPorId(Long id){
        return em.find(Producto.class, id);
    }

    public List<Producto> consultarTodos() {
        String jpql = "SELECT P FROM Producto AS P";
        return em.createQuery(jpql, Producto.class).getResultList();
    }

}
