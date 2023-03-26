package com.example.Ejempllo.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="compras")
public class Compra {
    @Id
    @Column(name="id_compra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idCompra;
@Column(name="id_cliente")
    private String idCliente;

private LocalDateTime fecha; //Se usa esta clase debido que Date ya no se usa tanto
@Column(name="medio_pago")
    private String medioPago;

private String comentario;
private String estado;
@ManyToOne
@JoinColumn(name ="id_cliente", insertable = false, updatable = false) //Se pone la PK del cliente y se pone los otro satributos para no crear nuevos clientes
private Cliente cliente;
@OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL}) //Todos los procesos con compra incluyen sus productos
private List<ComprasProducto> productos;
    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ComprasProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<ComprasProducto> productos) {
        this.productos = productos;
    }
}
