/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DAOs.Itens_PedidoDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author eduardobp
 */
public class Itens_Pedido {
    private int id;
    private int id_pedido;
    private int id_produto;
    private int quantidade;
    private double preco_unitario;
    private double subtotal;
    private LocalDate data_criacao;
    private LocalDate data_modificacao;
    
    private static int cont = 1;
    
    public Itens_Pedido(int id_pedido, int id_produto, int quantidade, double preco_unitario, LocalDate data_criacao, Itens_PedidoDAO bancoItens_Pedido) {
        this.id = cont++;
        this.id_pedido = id_pedido;
        this.id_produto = id_produto;
        this.quantidade = quantidade;
        this.preco_unitario = preco_unitario;
        this.subtotal = this.quantidade * this.preco_unitario;
        this.data_criacao = data_criacao;
        this.data_modificacao = data_criacao;
        bancoItens_Pedido.inserirItens_Pedido(this);
    }

    public int getId() {
        return id;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public int getId_produto() {
        return id_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco_unitario() {
        return preco_unitario;
    }

    public double getSubtotal() {
        return subtotal;
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
        
        if(num == 0){
            return "ID = " + id + "\nID do Pedido = " + id_pedido + "\nID do Produto = " + id_produto + "\nQuantidade = " + quantidade + "\nPreço Unitário = " + preco_unitario + "\nSubtotal = " + subtotal + "\nData de Criação = " + CriacaoFormatada + "\nData de Modificação = " + ModificacaoFormatada;

        } else {
            return "\nID do Produto = " + id_produto + "\nQuantidade = " + quantidade + "\nPreço Unitário = " + preco_unitario + "\nSubtotal = " + subtotal;
        }
    }
}
