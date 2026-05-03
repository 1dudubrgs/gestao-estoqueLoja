/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Classes.Pessoa;

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
            if(this.Pessoas[i] == null && !(jaExiste(pessoa.getCpf()))){
                this.Pessoas[i] = pessoa;
                i = this.Pessoas.length;
            }
        }
    }
    
    public boolean jaExiste(String CPF){
        for(int i = 0; i < this.Pessoas.length; i++){
            if(this.Pessoas[i] != null && this.Pessoas[i].getCpf().equals(CPF)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String string = "Pessoas Registradas no Sistema:\n\n";
        int cont = 0;
        
        for (Pessoa Pessoa1 : Pessoas) {
            if(Pessoa1 == null)
                cont++;
        }
           
        if(cont != this.Pessoas.length){
            for (Pessoa index : Pessoas) {
                if(index != null)
                    string += index + "\n\n"; 
            }
        }
        else
            string += "Não há pessoas registradas no sistema!";
        
        return string;
    }
}
