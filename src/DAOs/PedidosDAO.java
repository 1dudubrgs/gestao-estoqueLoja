/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Classes.Pedido;

/**
 *
 * @author Felipe
 */
public class PedidosDAO {
    private Pedido[] listaPedidos;

    public PedidosDAO(Pedido[] listaPedidos){
        this.listaPedidos = listaPedidos;
    }
    
    public void inserirPedido(Pedido pedidos){
        for(int i = 0; i<this.listaPedidos.length; i++){
            if(this.listaPedidos[i] == null){
                this.listaPedidos[i] = pedidos;
                i = this.listaPedidos.length;
            }
        }
    }
    
    public String toString(int num, int id_usuario) {
        String string = "Pedidos registrados no Sistema:\n\n";
        int cont = 0;
        int aux = 0;
        
        for (Pedido index : listaPedidos) {
            if(index == null)
                cont++;
            if(index != null && index.getId_usuario() == id_usuario){
                aux = 1;
            }
        }
           
        if(cont != this.listaPedidos.length && aux == 1){
            for (Pedido index : listaPedidos) {
                if(index != null && index.getId_usuario() == id_usuario)
                    string += index.toString(num) + "\n\n"; 
            }
        }
        else
            string += "Não há pedidos feitos!";
        
        return string;
    }
}
