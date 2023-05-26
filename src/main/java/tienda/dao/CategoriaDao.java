package tienda.dao;

import tienda.modelo.Categoria;
import tienda.modelo.Producto;

import javax.persistence.EntityManager;

public class CategoriaDao {
    private EntityManager em;

    public CategoriaDao(javax.persistence.EntityManager em) {
        this.em = em;
    }

    public void guardar(Categoria categoria) {
        this.em.persist(categoria);
    }

    public void actualizar(Categoria categoria){
        this.em.merge(categoria);
    }
}