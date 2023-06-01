package tienda.modelo;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CategoriaId implements Serializable {
    private String nombre;
    private String nommbre;

    public CategoriaId() {
    }

    public CategoriaId(String nombre, String nommbre) {
        this.nombre = nombre;
        this.nommbre = nommbre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNommbre() {
        return nommbre;
    }

    public void setNommbre(String nommbre) {
        this.nommbre = nommbre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaId that = (CategoriaId) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(nommbre, that.nommbre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nommbre);
    }
}
