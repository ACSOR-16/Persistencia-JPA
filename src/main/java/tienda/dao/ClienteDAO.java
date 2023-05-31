package tienda.dao;

import tienda.modelo.Cliente;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ClienteDAO {
    private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    public void guardar(Cliente cliente) {
        this.em.persist(cliente);
    }

    public Cliente consultaPorId(Long id){
        return em.find(Cliente.class, id);
    }

    public List<Cliente> consultarTodos() {
        String jpql = "SELECT P FROM Cliente AS P";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public List<Cliente> consultaPorNombre(String nombre) {
        String jpql = " SELECT P FROM Cliente AS P WHERE P.nombre=:nombre ";
        return em.createQuery(jpql, Cliente.class).setParameter("nombre", nombre).getResultList();
    }

    public List<Cliente> consultaPorNombreDeCategoria(String nombre) {
        String jpql = " SELECT p FROM Cliente AS p WHERE p.categoria.nombre=:nombre";
        return em.createQuery(jpql, Cliente.class).setParameter("nombre", nombre).getResultList();
    }

    public BigDecimal consultarPrecioPorNombreDeCliente (String nombre) {
        String jpql = " SELECT P.precio FROM Cliente AS P WHERE P.nombre=:nombre";
        return em.createQuery(jpql, BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
    }
}
