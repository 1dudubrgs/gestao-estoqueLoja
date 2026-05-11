/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DAOs.EntregasDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author eduardobp
 */
public class Entregas {
    private int id;
    private int id_pedido;
    private String status; //preparando, enviado, em_transito, entregue, cancelada
    private String transportadora;
    private int codigo_rastreio;
    private LocalDate data_envio;
    private LocalDate data_entrega;
    private LocalDate data_criacao;
    private LocalDate data_modificacao;
    
    private static int cont = 1;
    private static int contRastreio = 1;

    public Entregas(int id_pedido, String transportadora, LocalDate data_criacao, EntregasDAO bancoEntregas) {
        this.id = cont++;
        this.id_pedido = id_pedido;
        this.status = "Preparando";
        this.transportadora = transportadora;
        this.codigo_rastreio = contRastreio++;
        this.data_envio = null;
        this.data_entrega = null;
        this.data_criacao = data_criacao;
        this.data_modificacao = this.data_criacao;
        bancoEntregas.adicionarEntrega(this);
    }

    public int getId() {
        return id;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    public LocalDate getData_envio() {
        return data_envio;
    }

    public void setData_envio(LocalDate data_envio) {
        this.data_envio = data_envio;
    }

    public LocalDate getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(LocalDate data_entrega) {
        this.data_entrega = data_entrega;
    }

    public LocalDate getData_modificacao() {
        return data_modificacao;
    }

    public void setData_modificacao(LocalDate data_modificacao) {
        this.data_modificacao = data_modificacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + this.id_pedido;
        hash = 37 * hash + Objects.hashCode(this.status);
        hash = 37 * hash + Objects.hashCode(this.transportadora);
        hash = 37 * hash + this.codigo_rastreio;
        hash = 37 * hash + Objects.hashCode(this.data_envio);
        hash = 37 * hash + Objects.hashCode(this.data_entrega);
        hash = 37 * hash + Objects.hashCode(this.data_criacao);
        hash = 37 * hash + Objects.hashCode(this.data_modificacao);
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
        final Entregas other = (Entregas) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        DateTimeFormatter dma = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "ID = " + id + "\nID Pedido = " + id_pedido + "\nStatus = " + status + "\nTransportadora = " + transportadora + "\nCódigo Rastreio = " + codigo_rastreio + "\nData de envio = " + data_envio.format(dma) + "\nData de entrega = " + data_entrega.format(dma) + "\nData de criação = " + data_criacao.format(dma) + "\nData de modificacao = " + data_modificacao.format(dma);
    }
}
