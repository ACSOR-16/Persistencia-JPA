package tienda.vo;

import java.time.LocalDate;

public class RelatorioDeVenta {
    private String nombreDelProducto;
    private Long CantidadDelProducto;
    private LocalDate FechaDeUltimaVenta;

    public RelatorioDeVenta(String nombreDelProducto, Long cantidadDelProducto, LocalDate fechaDeUltimaVenta) {
        this.nombreDelProducto = nombreDelProducto;
        CantidadDelProducto = cantidadDelProducto;
        FechaDeUltimaVenta = fechaDeUltimaVenta;
    }

    public String getNombreDelProducto() {
        return nombreDelProducto;
    }

    public void setNombreDelProducto(String nombreDelProducto) {
        this.nombreDelProducto = nombreDelProducto;
    }

    public Long getCantidadDelProducto() {
        return CantidadDelProducto;
    }

    public void setCantidadDelProducto(Long cantidadDelProducto) {
        CantidadDelProducto = cantidadDelProducto;
    }

    public LocalDate getFechaDeUltimaVenta() {
        return FechaDeUltimaVenta;
    }

    public void setFechaDeUltimaVenta(LocalDate fechaDeUltimaVenta) {
        FechaDeUltimaVenta = fechaDeUltimaVenta;
    }

    @Override
    public String toString() {
        return "RelatorioDeVenta{" +
                "nombreDelProducto='" + nombreDelProducto + '\'' +
                ", CantidadDelProducto=" + CantidadDelProducto +
                ", FechaDeUltimaVenta=" + FechaDeUltimaVenta +
                '}';
    }
}
