/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DAOs.PessoaDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author eduardobp
 */
public class Pessoa {
    private int id;
    private String nome;
    private LocalDate nascimento;
    private String cpf;
    private LocalDate data_cricao;
    private LocalDate data_modificacao;
    
    private static int cont = 1;

    public Pessoa(String nome, LocalDate nascimento, String cpf, LocalDate data_atual,PessoaDAO bancoPessoas) {
        this.id = cont++;
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.data_cricao = data_atual;
        this.data_modificacao = this.data_cricao;
        bancoPessoas.adicionarPessoa(this);
    }

    public Pessoa(){}
    
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getData_cricao() {
        return data_cricao;
    }

    public void setData_cricao(LocalDate data_cricao) {
        this.data_cricao = data_cricao;
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
        String NascimentoFormatado = nascimento.format(FormaData);
        String CriacaoFormatado = data_cricao.format(FormaData);
        String ModificacaoFormatado = data_modificacao.format(FormaData);
        
        return "ID = " + id + "\nNome = " + nome + "\nNascimento = " + NascimentoFormatado + "\nCPF = " + cpf + "\nData de Criação = " + CriacaoFormatado + "\nData de Modificação = " + ModificacaoFormatado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.nascimento);
        hash = 17 * hash + Objects.hashCode(this.cpf);
        hash = 17 * hash + Objects.hashCode(this.data_cricao);
        hash = 17 * hash + Objects.hashCode(this.data_modificacao);
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
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.cpf, other.cpf);
    }
}
