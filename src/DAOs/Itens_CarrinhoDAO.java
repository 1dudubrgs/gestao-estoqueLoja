/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Classes.Itens_Carrinho;
import Classes.Itens_Pedido;
import Classes.Movimentacao_Estoque;
import java.time.LocalDate;

/**
 *
 * @author Felipe
 */
public class Itens_CarrinhoDAO {
    private Itens_Carrinho[] listaItens_Carrinho;

    public Itens_CarrinhoDAO(Itens_Carrinho[] listaItens_Carrinho) {
        this.listaItens_Carrinho = listaItens_Carrinho;
    }
    
    public void adicionarItens_Carrinho(Itens_Carrinho itens_carrinho){
        for(int i = 0; i < this.listaItens_Carrinho.length; i++){
            if(this.listaItens_Carrinho[i] == null){
                this.listaItens_Carrinho[i] = itens_carrinho;
                i = this.listaItens_Carrinho.length;
            }
        }
    }
    
    public String toString(int num, int id_carrinho) {
        String string = "Itens do carrinho registrados no Sistema:\n\n";
        int cont = 0;
        int aux = 0;
        
        for (Itens_Carrinho index : listaItens_Carrinho) {
            if(index == null)
                cont++;
            if(index != null && index.getId_carrinho() == id_carrinho){
                aux = 1;
            }
        }
           
        if(cont != this.listaItens_Carrinho.length && aux == 1){
            for (Itens_Carrinho index : listaItens_Carrinho) {
                if(index != null && index.getId_carrinho() == id_carrinho)
                    string += index.toString(num) + "\n\n"; 
            }
        }
        else
            string += "Não há itens no carrinho!";
        
        return string;
    }
    
    public boolean jaExiste(int id_produto, int id_carrinho){
        for (Itens_Carrinho index : this.listaItens_Carrinho) {
            if (index != null && index.getId_produto()== id_produto && index.getId_carrinho() == id_carrinho) {
                return true;
            }
        }
        return false;
    }
    
    public double subTotal(int id_carrinho){
        double subtotal = 0;
        for (Itens_Carrinho index : this.listaItens_Carrinho) {
            if (index != null && index.getId_carrinho() == id_carrinho) {
               subtotal += index.getPreco_unitario() * index.getQuantidade();
            }
        }
        return subtotal;
    }
    
    public void criarItens_PedidoEmovimentar_Estoque(int id_pedido, int id_carrinho, Itens_PedidoDAO bancoItens_Pedido, LocalDate data_criacao, Movimentacao_EstoqueDAO bancoMovimentacao_Estoque){
        for (Itens_Carrinho index : this.listaItens_Carrinho) {
            if (index != null && index.getId_carrinho() == id_carrinho) {
                Itens_Pedido novoItens_Pedido = new Itens_Pedido(id_pedido, index.getId_produto(), index.getQuantidade(), index.getPreco_unitario(), data_criacao, bancoItens_Pedido);
                Movimentacao_Estoque novoMovimentacao_Estoque = new Movimentacao_Estoque(index.getId_produto(), index.getQuantidade(), index.getPreco_unitario(), "Saída", data_criacao, bancoMovimentacao_Estoque);
            }
        }
    }
    
    public Itens_Carrinho pesquisarItens_Carrinho(int id_produto, int id_carrinho){
        for(int i = 0; i < this.listaItens_Carrinho.length; i++){
            if(this.listaItens_Carrinho[i] != null && this.listaItens_Carrinho[i].getId_produto() == id_produto && this.listaItens_Carrinho[i].getId_carrinho() == id_carrinho)
                return this.listaItens_Carrinho[i];
        }
        return null;
    }
    
    public Itens_Carrinho pesquisarTodosItens_Carrinho(int id_produto){
        for(int i = 0; i < this.listaItens_Carrinho.length; i++){
            if(this.listaItens_Carrinho[i] != null && this.listaItens_Carrinho[i].getId_produto() == id_produto)
                return this.listaItens_Carrinho[i];
        }
        return null;
    }
    
    public void removerItens_Carrinho(int ID){
        for(int i = 0; i < this.listaItens_Carrinho.length; i++){
            if(this.listaItens_Carrinho[i].getId() == ID){
                this.listaItens_Carrinho[i] = null;
                i = this.listaItens_Carrinho.length;
            }
        }
    }
    
    public boolean estaVazio(int id_carrinho){
        int cont = 0;
        int aux = 0;
        for(int i = 0; i < this.listaItens_Carrinho.length; i++){
            if(this.listaItens_Carrinho[i] == null)
                cont++;
            if(this.listaItens_Carrinho[i] != null && this.listaItens_Carrinho[i].getId_carrinho()== id_carrinho){
                aux = 1;
            }
        }
        
        if(cont == this.listaItens_Carrinho.length || aux == 0)
            return true;
        
        return false;
    }
}
