/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Classes.Itens_Pedido;

/**
 *
 * @author Felipe
 */
public class Itens_PedidoDAO {
    private Itens_Pedido[] listaItens_Pedido;

    public Itens_PedidoDAO(Itens_Pedido[] listaItens_Pedido){
        this.listaItens_Pedido = listaItens_Pedido;
    }
    
    public void inserirItens_Pedido(Itens_Pedido itens_pedido){
        for(int i = 0; i<this.listaItens_Pedido.length; i++){
            if(this.listaItens_Pedido[i] == null){
                this.listaItens_Pedido[i] = itens_pedido;
                i = this.listaItens_Pedido.length;
            }
        }
    }
    
    public String toString(int num, int id_pedido) {
        String string = "Itens do pedido registrados no Sistema:\n\n";
        int cont = 0;
        int aux = 0;
        
        for (Itens_Pedido index : listaItens_Pedido) {
            if(index == null)
                cont++;
            if(index != null && index.getId_pedido() == id_pedido){
                aux = 1;
            }
        }
           
        if(cont != this.listaItens_Pedido.length && aux == 1){
            for (Itens_Pedido index : listaItens_Pedido) {
                if(index != null && index.getId_pedido() == id_pedido)
                    string += index.toString(num) + "\n\n"; 
            }
        }
        else
            string += "Não há itens no pedido!";
        
        return string;
    }
}
