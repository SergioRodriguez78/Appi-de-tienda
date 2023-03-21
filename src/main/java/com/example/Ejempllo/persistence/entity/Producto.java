package com.example.Ejempllo.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name="productos") //Esto se hace dbeido que en la BD esta con oro nombre la tabla (previamente creada)
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id_producto") //Esto se hace ya que la BD esta con otro nombre en la columna (Todo previamente creado)
    private Integer idProducto;

    private String nombre;
    @Column(name="id_categoria")
    private Integer idCategoria;
@Column(name="codigo_barras")
    private String codigoBarras;
@Column(name="precio_venta")
private Double precioVenta;
@Column(name="cantidad_stock")
private Integer cantidadStock;

        private Boolean estado;

    @ManyToOne //Esto debido a la relacion de la BD, muchas compras pueden estar en una categoria
    @JoinColumn(name="id_categoria", insertable = false, updatable = false) //Esto sirve para no crear categorias nuevas
    private Categoria categoria;


    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
