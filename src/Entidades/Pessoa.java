/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import DAOs.PessoaDAO;
import java.time.LocalDate;

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
    
    private static int cont;

    public Pessoa(String nome, LocalDate nascimento, String cpf, PessoaDAO bancoPessoas) {
        this.id = cont++;
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.data_modificacao = this.data_cricao;
        bancoPessoas.adicionarPessoa(this);
    }
    
    
}
