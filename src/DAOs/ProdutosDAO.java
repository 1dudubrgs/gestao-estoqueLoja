/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Classes.Movimentacao_Estoque;
import Classes.Produto;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author eduardobp
 */
public class ProdutosDAO {
    private Produto[] listaProdutos;

    public ProdutosDAO(Produto[] listaProdutos){
        this.listaProdutos = listaProdutos;
    }
    
    public String toString(int num) {
        String string = "";
        
        boolean vazio = this.estaVazio();
           
        if(!vazio){
            if(num == 0){
                string = "Produtos registrados no Sistema:\n\n";
                for (Produto index : listaProdutos) {
                    if(index != null)
                        string += index.toString(num) + "\n\n"; 
                }
            }
            else{
                string = "Produtos à venda no Sistema:\n\n";
                for (Produto index : listaProdutos) {
                    if(index != null && index.isAtivo())
                        string += index.toString(num) + "\n\n"; 
                }
            }
        }
        else
            string += "Não há produtos registrados no sistema!";
        
        return string;
    }

    public void inserirProduto(Produto produto){
        for(int i = 0; i<this.listaProdutos.length; i++){
            if(this.listaProdutos[i] == null){
                this.listaProdutos[i] = produto;
                i = this.listaProdutos.length;
            }
        }
    }
    
    public Produto pesquisarProduto(int id){
        for(int i = 0; i < this.listaProdutos.length; i++){
            if(this.listaProdutos[i] != null && this.listaProdutos[i].getId() == id)
                return this.listaProdutos[i];
        }
        return null;
    }
    
    public boolean removerProduto(int id){
        if(pesquisarProduto(id) != null){
            for(int i = 0; i < this.listaProdutos.length; i++){
                if(this.listaProdutos[i] != null &&  this.listaProdutos[i].equals(pesquisarProduto(id))){
                    this.listaProdutos[i] = null;
                    JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                    return true;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "ID nao encontrado, tente novamente");
        return false;
    }
    
    public boolean estaVazio(){
        int cont = 0;
        for(int i = 0; i < this.listaProdutos.length; i++){
            if(this.listaProdutos[i] == null)
                cont++;
        }
        
        if(cont == this.listaProdutos.length)
            return true;
        
        return false;
    }
    
    public void retornarProdutosdoCarrinho(CarrinhoDAO bancoCarrinhos, Itens_CarrinhoDAO bancoItens_Carrinho, int id_usuario, LocalDate data_criacao, Movimentacao_EstoqueDAO bancoMovimentacao_Estoque){
        for (Produto listaProduto : this.listaProdutos) {
            if (listaProduto != null && bancoCarrinhos.pesquisarCarrinho(id_usuario) != null && bancoItens_Carrinho.jaExiste(listaProduto.getId(), bancoCarrinhos.pesquisarCarrinho(id_usuario).getId())) {
                this.pesquisarProduto(listaProduto.getId()).setQuantidade(this.pesquisarProduto(listaProduto.getId()).getQuantidade() + bancoItens_Carrinho.pesquisarItens_Carrinho(listaProduto.getId(), bancoCarrinhos.pesquisarCarrinho(id_usuario).getId()).getQuantidade());
                Movimentacao_Estoque novoMovimentacao_Estoque = new Movimentacao_Estoque(listaProduto.getId(), bancoItens_Carrinho.pesquisarItens_Carrinho(listaProduto.getId(), bancoCarrinhos.pesquisarCarrinho(id_usuario).getId()).getQuantidade(), listaProduto.getPreco_venda(), "Entrada", data_criacao, bancoMovimentacao_Estoque);
            }
        }
    }
    
    public void retornarProdutosdoPedido(PedidosDAO bancoPedidos, Itens_PedidoDAO bancoItens_Pedido, LocalDate data_criacao, Movimentacao_EstoqueDAO bancoMovimentacao_Estoque, int id_pedido){
        for (Produto listaProduto : this.listaProdutos) {
            if (listaProduto != null && bancoItens_Pedido.jaExiste(listaProduto.getId(), id_pedido)) {
                this.pesquisarProduto(listaProduto.getId()).setQuantidade(this.pesquisarProduto(listaProduto.getId()).getQuantidade() + bancoItens_Pedido.pesquisarItens_Pedido(listaProduto.getId(), id_pedido).getQuantidade());
                Movimentacao_Estoque novoMovimentacao_Estoque = new Movimentacao_Estoque(listaProduto.getId(), bancoItens_Pedido.pesquisarItens_Pedido(listaProduto.getId(), id_pedido).getQuantidade(), listaProduto.getPreco_venda(), "Entrada", data_criacao, bancoMovimentacao_Estoque);
            }
        }
    }
    
    public void retornarProduto(int id_produto, CarrinhoDAO bancoCarrinhos, Itens_CarrinhoDAO bancoItens_Carrinho, int id_usuario, int quantidade){
        
        this.pesquisarProduto(id_produto).setQuantidade(this.pesquisarProduto(id_produto).getQuantidade() + quantidade);
        this.pesquisarProduto(id_produto).setAtivo(true);
}
}
