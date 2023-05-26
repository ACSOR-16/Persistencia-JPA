package tienda.dao;

import tienda.modelo.Producto;

import javax.persistence.EntityManager;

public class ProductoDAO {
    private EntityManager em;

    public ProductoDAO(EntityManager em) {
        this.em = em;
    }

    public void guardar(Producto producto) {
        this.em.persist(producto);
    }
}
