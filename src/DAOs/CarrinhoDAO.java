/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Classes.Carrinho;
import Sistema.Calendario;
import java.time.LocalDate;

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
    
    public boolean estaVazio(int id_usuario){
        int cont = 0;
        int aux = 0;
        for(int i = 0; i < this.listaCarrinhos.length; i++){
            if(this.listaCarrinhos[i] == null)
                cont++;
            if(this.listaCarrinhos[i] != null && this.listaCarrinhos[i].getId_usuario() == id_usuario && this.listaCarrinhos[i].getStatus() == "Aberto"){
                aux = 1;
            }
        }
        
        if(cont == this.listaCarrinhos.length || aux == 0)
            return true;
        
        return false;
    }
    
    public boolean estaTodosVazio(){
        int cont = 0;
        int aux = 0;
        for(int i = 0; i < this.listaCarrinhos.length; i++){
            if(this.listaCarrinhos[i] == null)
                cont++;
            if(this.listaCarrinhos[i] != null && this.listaCarrinhos[i].getStatus() == "Aberto"){
                aux = 1;
            }
        }
        
        if(cont == this.listaCarrinhos.length || aux == 0)
            return true;
        
        return false;
    }
    
    public Carrinho pesquisarCarrinho(int id_usuario){
        for (Carrinho listaCarrinho : this.listaCarrinhos) {
            if (listaCarrinho != null && listaCarrinho.getId_usuario() == id_usuario && listaCarrinho.getStatus().equals("Aberto")) {
                return listaCarrinho;
            }
        }
        return null;
    }
    
    public boolean jaExiste(int id_usuario){
        for (Carrinho listaCarrinho : this.listaCarrinhos) {
            if (listaCarrinho != null && listaCarrinho.getId_usuario() == id_usuario && listaCarrinho.getStatus().equals("Aberto")) {
                return true;
            }
        }
        return false;
    }
    
    public void removerCarrinho(int ID){
        for(int i = 0; i < this.listaCarrinhos.length; i++){
            if(this.listaCarrinhos[i].getId() == ID){
                this.listaCarrinhos[i] = null;
                i = this.listaCarrinhos.length;
            }
        }
    }
    
    public void expirarCarrinhos(LocalDate dataSistema, ProdutosDAO bancoProdutos, Itens_CarrinhoDAO bancoItens_Carrinho, Movimentacao_EstoqueDAO bancoMovientacao_Estoque){
        for(int i = 0; i<this.listaCarrinhos.length; i++){
            if(this.listaCarrinhos[i] != null && this.listaCarrinhos[i].getStatus().equals("Aberto") && this.listaCarrinhos[i].getData_criacao().isBefore(dataSistema)){
                bancoProdutos.retornarProdutosdoCarrinho(this, bancoItens_Carrinho, this.listaCarrinhos[i].getId_usuario(), dataSistema, bancoMovientacao_Estoque);
                this.listaCarrinhos[i].setStatus("Expirado");
                this.listaCarrinhos[i].setData_modificacao(dataSistema);
            }
        }
    }
}
