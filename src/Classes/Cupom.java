/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DAOs.CuponsDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author eduardobp
 */
public class Cupom {
    private int id;
    private String codigo;
    private String tipo_desconto; //FIXO, PERCENTUAL
    private double valor_desconto;
    private double valor_minimo_pedido;
    private LocalDate data_validade;
    private boolean ativo;
    private LocalDate data_criacao;
    private LocalDate data_modificacao;
    
    private static int cont = 1;

    public Cupom(String codigo, String tipo_desconto, double valor_desconto, double valor_minimo_pedido, LocalDate dataexpiracao, LocalDate datahoje, CuponsDAO bancoCupons) {
        this.id = cont++;
        this.codigo = codigo;
        this.tipo_desconto = tipo_desconto;
        this.valor_desconto = valor_desconto;
        this.valor_minimo_pedido = valor_minimo_pedido;
        this.data_validade = dataexpiracao;
        this.data_criacao = datahoje;
        this.data_modificacao = data_criacao;
        if(dataexpiracao.isAfter(datahoje)){
            this.ativo = true;
        } else {
            this.ativo = false;
        }
        bancoCupons.adicionarCupon(this);    
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
        
    public String getTipo_desconto() {
        return tipo_desconto;
    }

    public void setTipo_desconto(String tipo_desconto) {
        this.tipo_desconto = tipo_desconto;
    }

    public double getValor_desconto() {
        return valor_desconto;
    }

    public void setValor_desconto(double valor_desconto) {
        this.valor_desconto = valor_desconto;
    }

    public double getValor_minimo_pedido() {
        return valor_minimo_pedido;
    }

    public void setValor_minimo_pedido(double valor_minimo_pedido) {
        this.valor_minimo_pedido = valor_minimo_pedido;
    }

    public LocalDate getData_validade() {
        return data_validade;
    }

    public void setData_validade(LocalDate data_validade) {
        this.data_validade = data_validade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getData_criacao() {
        return data_criacao;
    }

    public LocalDate getData_modificacao() {
        return data_modificacao;
    }

    public void setData_modificacao(LocalDate data_modificacao) {
        this.data_modificacao = data_modificacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.codigo);
        hash = 59 * hash + Objects.hashCode(this.tipo_desconto);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.valor_desconto) ^ (Double.doubleToLongBits(this.valor_desconto) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.valor_minimo_pedido) ^ (Double.doubleToLongBits(this.valor_minimo_pedido) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.data_validade);
        hash = 59 * hash + (this.ativo ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.data_criacao);
        hash = 59 * hash + Objects.hashCode(this.data_modificacao);
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
        final Cupom other = (Cupom) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        DateTimeFormatter dma = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String simnao = "";
        if(ativo)
            simnao = "Sim";
        else
            simnao = "Não";
        
        return "ID = " + id + "\nCodigo = " + codigo + "\nTipo_desconto = " + tipo_desconto + "\nValor_desconto = " + valor_desconto + "\nValor_minimo_pedido = " + valor_minimo_pedido + "\nData_validade = " + data_validade.format(dma) + "\nAtivo = " + simnao + "\nData_criacao = " + data_criacao.format(dma) + "\nData_modificacao= " + data_modificacao.format(dma);
    }
    
    
}
