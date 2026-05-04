/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Classes.Produto;
import java.util.Arrays;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Arrays.deepHashCode(this.listaProdutos);
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
        final ProdutosDAO other = (ProdutosDAO) obj;
        return Arrays.deepEquals(this.listaProdutos, other.listaProdutos);
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
                if(this.listaProdutos[i].equals(pesquisarProduto(id))){
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
}
