/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DAOs.Itens_CarrinhoDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author eduardobp
 */
public class Itens_Carrinho {
    private int id;
    private int id_carrinho;
    private int id_produto;
    private int quantidade;
    private double preco_unitario;
    private LocalDate data_criacao;
    private LocalDate data_modificacao;
    
    private static int cont = 1;
    
    public Itens_Carrinho(Carrinho carrinho, Produto produto, int quantidade, LocalDate data_criacao, Itens_CarrinhoDAO bancoItens_Carrinho) {
        this.id = cont++;
        this.id_carrinho = carrinho.getId();
        this.id_produto = produto.getId();
        this.quantidade = quantidade;
        produto.setQuantidade(produto.getQuantidade() - quantidade);
        this.preco_unitario = produto.getPreco_venda();
        this.data_criacao = data_criacao;
        this.data_modificacao = this.data_criacao;
        bancoItens_Carrinho.adicionarItens_Carrinho(this);
    }

    public Itens_Carrinho(){}
    
    public int getId() {
        return id;
    }

    public int getId_carrinho() {
        return id_carrinho;
    }

    public int getId_produto() {
        return id_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco_unitario() {
        return preco_unitario;
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
    
    public String toString(int num) {
        DateTimeFormatter FormaData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String CriacaoFormatada = data_criacao.format(FormaData);
        String ModificacaoFormatada = data_modificacao.format(FormaData);
        
        if(num == 0)
            return "ID = " + id + "\nID do Carrinho = " + id_carrinho + "\nID do Produto = " + id_produto + "\nQuantidade=" + quantidade + "\nPreço Unitário = " + preco_unitario + "\nData de Criação = " + CriacaoFormatada + "\nData de Modificação = " + ModificacaoFormatada;
        else
            return "ID do Produto = " + id_produto + "\nQuantidade = " + quantidade + "\nPreço Unitário = " + preco_unitario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + this.id_carrinho;
        hash = 83 * hash + this.id_produto;
        hash = 83 * hash + this.quantidade;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.preco_unitario) ^ (Double.doubleToLongBits(this.preco_unitario) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.data_criacao);
        hash = 83 * hash + Objects.hashCode(this.data_modificacao);
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
        final Itens_Carrinho other = (Itens_Carrinho) obj;
        return this.id == other.id;
    }
}
