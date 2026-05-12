/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DAOs.UsuarioDAO;
import Sistema.Calendario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author eduardobp
 */
public class Usuario {
    private int id;
    private Pessoa pessoa;
    private String login;
    private String senha;
    private LocalDate data_criacao;
    private LocalDate data_modificacao;
    private String tipo;
    
    private static int cont = 1;

    public Usuario(Pessoa pessoa, String login, String senha, LocalDate data_criacao, UsuarioDAO bancoUsuarios) {
        this.id = cont++;
        this.pessoa = pessoa;
        this.login = login;
        this.senha = senha;
        this.data_criacao = data_criacao;
        this.data_modificacao = this.data_criacao;
        bancoUsuarios.adicionarUsuario(this);
    }
    
    public Usuario(){}
    
    public int getId() {
        return id;
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.pessoa);
        hash = 83 * hash + Objects.hashCode(this.login);
        hash = 83 * hash + Objects.hashCode(this.senha);
        hash = 83 * hash + Objects.hashCode(this.data_criacao);
        hash = 83 * hash + Objects.hashCode(this.data_modificacao);
        hash = 83 * hash + Objects.hashCode(this.tipo);
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
        final Usuario other = (Usuario) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        DateTimeFormatter FormaData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String CriacaoFormatada = data_criacao.format(FormaData);
        String ModificacaoFormatada = data_modificacao.format(FormaData);
        
        return "ID = " + id + "\nID do Dono(a) = " + pessoa.getId() + "\nLogin = " + login + "\nSenha = " + senha + "\nData de Criação = " + CriacaoFormatada + "\nData de Modificação = " + ModificacaoFormatada + "\nTipo da Conta = " + tipo;
    }
}
