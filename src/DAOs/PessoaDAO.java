/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Pessoa;

/**
 *
 * @author Família
 */
public class PessoaDAO {
    private Pessoa[] Pessoas;

    public PessoaDAO(Pessoa[] Pessoas) {
        this.Pessoas = Pessoas;
    }
    
    public void adicionarPessoa(Pessoa pessoa){
        for(int i = 0; i < this.Pessoas.length; i++){
            if(this.Pessoas[i] == null){
                this.Pessoas[i] = pessoa;
                i = this.Pessoas.length;
            }
        }
    }
    
}
