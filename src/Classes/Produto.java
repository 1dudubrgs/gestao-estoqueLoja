/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DAOs.ProdutosDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import Sistema.Calendario;

/**
 *
 * @author eduardobp
 */
public class Produto {
    private int id;
    private int quantidade;
    private String nome;
    private String descricao;
    private double preco_venda;
    private boolean ativo;
    private LocalDate data_criacao;
    private LocalDate data_modificacao;

    private static int cont = 1;

    public Produto(int quantidade, String nome, String descricao, double preco_venda, LocalDate data_criacao, ProdutosDAO bancoProdutos) {
        this.id = cont++;
        this.quantidade = quantidade;
        this.nome = nome;
        this.descricao = descricao;
        this.preco_venda = preco_venda;
        this.ativo = this.quantidade > 0;
        this.data_criacao = data_criacao;
        this.data_modificacao = data_criacao;
        bancoProdutos.inserirProduto(this);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        if(quantidade == 0){
            this.setAtivo(false);
        }
    }
    
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
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

    public void setData_criacao(LocalDate data_criacao) {
        this.data_criacao = data_criacao;
    }

    public LocalDate getData_modificacao() {
        return data_modificacao;
    }

    public void setData_modificacao(LocalDate data_modificacao) {
        this.data_modificacao = data_modificacao;
    }
    
    public void vendaProduto(int quantidade){
        this.setQuantidade(this.getQuantidade() - quantidade);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.descricao);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.preco_venda) ^ (Double.doubleToLongBits(this.preco_venda) >>> 32));
        hash = 97 * hash + (this.ativo ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.data_criacao);
        hash = 97 * hash + Objects.hashCode(this.data_modificacao);
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
        final Produto other = (Produto) obj;
        return this.id == other.id;
    }

    public String toString(int num) {
        DateTimeFormatter FormaData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String CriacaoFormatado = data_criacao.format(FormaData);
        String ModificacaoFormatado = data_modificacao.format(FormaData);
        String ativoText = "";
        
        if(ativo)
            ativoText = "Sim";
        else
            ativoText = "Não";
        
        if(num == 0)
            return "ID = " + id + "\nNome = " + nome + "\nDescricao = " + descricao + "\nQuantidade = " + quantidade +  "\nPreço = R$" + preco_venda + "\nAtivo: " + ativoText + "\nCriado em: " + CriacaoFormatado + "\nModificado em: " + ModificacaoFormatado;
        else
            return "ID = " + id + "\nNome = " + nome + "\nDescricao = " + descricao + "\nQuantidade = " + quantidade + "\nPreço = R$" + preco_venda;
    }
}
