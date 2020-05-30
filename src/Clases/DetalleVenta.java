
package Clases;

import java.util.Objects;

public class DetalleVenta {
    
    public class idDetalleVenta{
        private Long idVenta;
        private Long idCategoria;

        public idDetalleVenta(Long idVenta, Long idCategoria) {
            this.idVenta = idVenta;
            this.idCategoria = idCategoria;
        }

        public Long getIdVenta() {
            return idVenta;
        }

        public void setIdVenta(Long idVenta) {
            this.idVenta = idVenta;
        }

        public Long getIdCategoria() {
            return idCategoria;
        }

        public void setIdCategoria(Long idCategoria) {
            this.idCategoria = idCategoria;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 37 * hash + Objects.hashCode(this.idVenta);
            hash = 37 * hash + Objects.hashCode(this.idCategoria);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final idDetalleVenta other = (idDetalleVenta) obj;
            if (!Objects.equals(this.idVenta, other.idVenta)) {
                return false;
            }
            if (!Objects.equals(this.idCategoria, other.idCategoria)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "idDetalleVenta{" + "idVenta=" + idVenta + ", idCategoria=" + idCategoria + '}';
        }
        
    }
    
    private idDetalleVenta id;
    private int cantidad;
    private String nombreCategoria;
    
    public DetalleVenta() {
        this.id = new idDetalleVenta(null, null);
    }
    
    public DetalleVenta(idDetalleVenta id) {
        this.id = id;
    }
    
    public DetalleVenta(Long venta, Long categoria){
        this.id = new idDetalleVenta(venta, categoria);
    }

    public idDetalleVenta getId() {
        return id;
    }

    public void setId(idDetalleVenta id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + this.cantidad;
        hash = 79 * hash + Objects.hashCode(this.nombreCategoria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetalleVenta other = (DetalleVenta) obj;
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (!Objects.equals(this.nombreCategoria, other.nombreCategoria)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "id=" + id + ", cantidad=" + cantidad + ", nombreCategoria=" + nombreCategoria + '}';
    }
    
}
