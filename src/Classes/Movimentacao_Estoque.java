/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DAOs.Movimentacao_EstoqueDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author eduardobp
 */
public class Movimentacao_Estoque {
    private int id;
    private int id_produto;
    private int quantidade;
    private String tipo; //ENTRADA ,SAIDA ,AJUSTE
    private double valor_unitario;
    private LocalDate data_criacao;
    private LocalDate data_modificacao;
    
    private static int cont = 1;
    
    public Movimentacao_Estoque(int id_produto, int quantidade, double valor_unitario, String tipo, LocalDate data_criacao, Movimentacao_EstoqueDAO bancoMovimentacao_Estoque) {
        this.id = cont++;
        this.id_produto = id_produto;
        this.quantidade = quantidade;
        this.valor_unitario = valor_unitario;
        this.tipo = tipo;
        this.data_criacao = data_criacao;
        this.data_modificacao = data_criacao;
        bancoMovimentacao_Estoque.inserirMovimentacao_Estoque(this);
    }

    public int getId() {
        return id;
    }

    public int getId_produto() {
        return id_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor_unitario() {
        return valor_unitario;
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
    public String toString() {
        DateTimeFormatter FormaData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String CriacaoFormatada = data_criacao.format(FormaData);
        String ModificacaoFormatada = data_modificacao.format(FormaData);
        
        return "ID = " + id + "\nID do Produto = " + id_produto + "\nQuantidade = " + quantidade + "\nTipo = " + tipo + "\nValor Unitário = " + valor_unitario + "\nData de Criação = " + CriacaoFormatada + "\nData de Modificação = " + ModificacaoFormatada;
    }
}