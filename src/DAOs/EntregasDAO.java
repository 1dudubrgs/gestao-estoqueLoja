/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Classes.Entregas;

/**
 *
 * @author eduardobp
 */
public class EntregasDAO {
    private Entregas[] listaEntregas;

    public EntregasDAO(Entregas[] listaEntregas) {
        this.listaEntregas = listaEntregas;
    }
    
    public void adicionarEntrega(Entregas entrega){
        for(int i = 0; i<this.listaEntregas.length; i++){
            if(this.listaEntregas[i] == null){
                this.listaEntregas[i] = entrega;
                i = this.listaEntregas.length;
            }
        }
    }
    
    public void removerEntrega(int ID){
        for(int i = 0; i<this.listaEntregas.length; i++){
            if(this.listaEntregas[i] != null && this.listaEntregas[i].getId() == ID){
                this.listaEntregas[i] = null;
                i = this.listaEntregas.length;
            }
        }
    }
    
    public boolean estaVazio(){
        int cont = 0;
        for(int i = 0; i<this.listaEntregas.length; i++){
            if(this.listaEntregas[i] == null){
                cont++;
            }
        }
        
        if(cont == this.listaEntregas.length){
            return true;
        }
        
        return false;
    }
    
    public Entregas procurarEntregaID(int ID){
        for(int i = 0; i<this.listaEntregas.length; i++){
            if(this.listaEntregas[i] != null && this.listaEntregas[i].getId() == ID){
                return this.listaEntregas[i];
            }
        }
        
        return null;
    }
    
    public Entregas procurarEntregaPedidoID(int ID){
        for(int i = 0; i<this.listaEntregas.length; i++){
            if(this.listaEntregas[i] != null && this.listaEntregas[i].getId_pedido() == ID){
                return this.listaEntregas[i];
            }
        }
        
        return null;
    }
    
    @Override
    public String toString() {
        String retornar = "";
        
        if(this.estaVazio()){
            return "Não há entregas para listar!";
        }
        
        for (Entregas index : listaEntregas) {
            if(index != null)
                retornar += index + "\n\n"; 
        }
        
        return "Entregas encontradas no sistema:\n\n" + retornar;
    }
}
