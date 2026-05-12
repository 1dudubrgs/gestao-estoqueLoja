/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Classes.Movimentacao_Estoque;

/**
 *
 * @author Felipe
 */
public class Movimentacao_EstoqueDAO {
    private Movimentacao_Estoque[] listaMovimentacao_Estoque;

    public Movimentacao_EstoqueDAO(Movimentacao_Estoque[] listaMovimentacao_Estoque){
        this.listaMovimentacao_Estoque = listaMovimentacao_Estoque;
    }
    
    public void inserirMovimentacao_Estoque(Movimentacao_Estoque movimentacao_estoque){
        for(int i = 0; i<this.listaMovimentacao_Estoque.length; i++){
            if(this.listaMovimentacao_Estoque[i] == null){
                this.listaMovimentacao_Estoque[i] = movimentacao_estoque;
                i = this.listaMovimentacao_Estoque.length;
            }
        }
    }
    
    @Override
    public String toString() {
        String string = "Movimentações de estoque registrados no Sistema:\n\n";
        int cont = 0;
        
        for (Movimentacao_Estoque index : listaMovimentacao_Estoque) {
            if(index == null)
                cont++;
        }
           
        if(cont != this.listaMovimentacao_Estoque.length){
            for (Movimentacao_Estoque index : listaMovimentacao_Estoque) {
                if(index != null)
                    string += index + "\n\n"; 
            }
        }
        else
            string += "Não há movimentações de estoque registrados no sistema!";
        
        return string;
    }
    
    public void removerMovimentacao_Estoque(int ID){
        for(int i = 0; i<this.listaMovimentacao_Estoque.length; i++){
            if(this.listaMovimentacao_Estoque[i] != null && this.listaMovimentacao_Estoque[i].getId() == ID){
                this.listaMovimentacao_Estoque[i] = null;
                i = this.listaMovimentacao_Estoque.length;
            }
        }
    }
}
