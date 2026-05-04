/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Classes.Carrinho;

/**
 *
 * @author Felipe
 */
public class CarrinhoDAO {
    private Carrinho[] listaCarrinhos;

    public CarrinhoDAO(Carrinho[] listaCarrinhos) {
        this.listaCarrinhos = listaCarrinhos;
    }
    
    public void adicionarCarrinho(Carrinho carrinho){
        for(int i = 0; i < this.listaCarrinhos.length; i++){
            if(this.listaCarrinhos[i] == null){
                this.listaCarrinhos[i] = carrinho;
                i = this.listaCarrinhos.length;
            }
        }
    }
    
    @Override
    public String toString() {
        String string = "Carrinhos registrados no Sistema:\n\n";
        int cont = 0;
        
        for (Carrinho index : listaCarrinhos) {
            if(index == null)
                cont++;
        }
           
        if(cont != this.listaCarrinhos.length){
            for (Carrinho index : listaCarrinhos) {
                if(index != null)
                    string += index + "\n\n"; 
            }
        }
        else
            string += "Não há carrinhos registrados no sistema!";
        
        return string;
    }
    
    public boolean estaVazio(){
        int cont = 0;
        for(int i = 0; i < this.listaCarrinhos.length; i++){
            if(this.listaCarrinhos[i] == null)
                cont++;
        }
        
        if(cont == this.listaCarrinhos.length)
            return true;
        
        return false;
    }
    
    public boolean jaExiste(int id_usuario){
        for (Carrinho listaCarrinho : this.listaCarrinhos) {
            if (listaCarrinho != null && listaCarrinho.getId_usuario() == id_usuario) {
                return true;
            }
        }
        return false;
    }
}
