/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Classes.Cupom;

/**
 *
 * @author eduardobp
 */
public class CuponsDAO {
    private Cupom listaCupons[];

    public CuponsDAO(Cupom[] listaCupons) {
        this.listaCupons = listaCupons;
    }
    
    public void adicionarCupon(Cupom cupon){
        for(int i = 0; i<this.listaCupons.length; i++){
            if(this.listaCupons[i] == null){
                this.listaCupons[i] = cupon;
                i = this.listaCupons.length;
            }
        }
    }
    
    public void removerCupom(int ID){
        for(int i = 0; i<this.listaCupons.length; i++){
            if(this.listaCupons[i] != null && this.listaCupons[i].getId() == ID){
                this.listaCupons[i] = null;
                i = this.listaCupons.length;
            }
        }
    }
    
    public Cupom procurarCupomID(int ID){
        for(int i = 0; i<this.listaCupons.length; i++){
            if(this.listaCupons[i] != null && this.listaCupons[i].getId() == ID){
                return this.listaCupons[i];
            }
        }
        
        return null;
    }
    
    public Cupom procurarCupomCODIGO(String codigo){
        for(int i = 0; i<this.listaCupons.length; i++){
            if(this.listaCupons[i] != null && this.listaCupons[i].getCodigo().equals(codigo)){
                return this.listaCupons[i];
            }
        }
        
        return null;
    }

    public boolean estaVazio(){
        int cont = 0;
        for(int i = 0; i<this.listaCupons.length; i++){
            if(this.listaCupons[i] == null)
                cont++;
        }
        
        if(cont == this.listaCupons.length)
            return true;
        
        return false;
    }
    
    @Override
    public String toString() {
        String cupons = "Cupons Registrados no Sistema:\n\n";
        
        if(estaVazio()){
            return "Não há cupons registrados no sistema!";
        }
        
        for (Cupom cupom : listaCupons) {
            if(cupom != null){
                cupons += cupom + "\n\n";
            }
        }
        
        return cupons;
    }   
}