/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Classes.Pedido;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

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
    
    public String toString(int num, int id_usuario, int num2) {
        String string = "Pedidos registrados no Sistema:\n\n";
        int cont = 0;
        int aux = 0;
        int aux2 = 0;
        int aux3 = 0;
        
        for (Pedido index : listaPedidos) {
            if(index == null)
                cont++;
            if(index != null && index.getId_usuario() == id_usuario){
                aux = 1;
            }
            if(index != null && index.getId_usuario() == id_usuario && ("Criado".equals(index.getStatus()) || "Pago".equals(index.getStatus()))){
                aux2 = 1;
            }
            if(index != null && "Criado".equals(index.getStatus()) && num2 == 10){
                aux3 = 1;
            }
            if(index != null && "Pago".equals(index.getStatus()) && num2 == 20){
                aux3 = 2;
            }
            if(index != null && "Cancelado".equals(index.getStatus()) && num2 == 30){
                aux3 = 3;
            }
        }
        if(id_usuario == 0){
            
            if(cont != this.listaPedidos.length && aux3 == 1){
                for (Pedido index : listaPedidos) {
                    if(index != null && "Criado".equals(index.getStatus()))
                        string += index.toString(num) + "\n\n";
                }
            }
            else if(cont != this.listaPedidos.length && aux3 == 2){
                for (Pedido index : listaPedidos) {
                    if(index != null && "Pago".equals(index.getStatus()))
                        string += index.toString(num) + "\n\n";
                }
            }
            else if(cont != this.listaPedidos.length && aux3 == 3){
                for (Pedido index : listaPedidos) {
                    if(index != null && "Cancelado".equals(index.getStatus()))
                        string += index.toString(num) + "\n\n";
                }
            }
            else if(cont != this.listaPedidos.length && num2 == 0){
                for (Pedido index : listaPedidos) {
                    if(index != null)
                        string += index.toString(num) + "\n\n"; 
                }
            }
            else{
                string += "Não há pedidos feitos!";
            }
        }
        else if(num2 == 0){
            if(cont != this.listaPedidos.length && aux == 1){
                for (Pedido index : listaPedidos) {
                    if(index != null && index.getId_usuario() == id_usuario)
                        string += index.toString(num) + "\n\n"; 
                }
            }
            else{
                string += "Não há pedidos feitos!";
            }
            } else{
            if(cont != this.listaPedidos.length && aux == 1 && aux2 == 1){
                for (Pedido index : listaPedidos) {
                    if(index != null && index.getId_usuario() == id_usuario && ("Criado".equals(index.getStatus()) || "Pago".equals(index.getStatus())))
                        string += index.toString(num) + "\n\n";
                }
            }
            else{
                string += "Não há pedidos criados!";
            }
        }
        
        return string;
    }
    
    public boolean estaVazio(int id_usuario){
        int cont = 0;
        int aux = 0;
        for (Pedido listaPedido : this.listaPedidos) {
            if (listaPedido == null) {
                cont++;
            }
            if (listaPedido != null && listaPedido.getId_usuario() == id_usuario && "Criado".equals(listaPedido.getStatus())) {
                aux = 1;
            }
        }
        
        if(cont != this.listaPedidos.length && id_usuario == 0)
            return false;
        
        if(cont == this.listaPedidos.length || aux == 0)
            return true;
        
        return false;
    }
    
    public Pedido pesquisarPedido(int id_pedido){
        for (Pedido listaPedidos : this.listaPedidos) {
            if (listaPedidos != null && listaPedidos.getId() == id_pedido) {
                return listaPedidos;
            }
        }
        return null;
    }
    
    public void statusEnviadoOuEntregue(LocalDate dataSistema, EntregasDAO bancoEntregas){
        for(int i = 0; i<this.listaPedidos.length; i++){
            if(this.listaPedidos[i] != null && this.listaPedidos[i].getStatus().equals("Pago") && this.listaPedidos[i].getData_criacao().isBefore(dataSistema)){
                this.listaPedidos[i].setStatus("Enviado");
                this.listaPedidos[i].setData_modificacao(dataSistema);
                bancoEntregas.procurarEntregaPedidoID(this.listaPedidos[i].getId()).setData_envio(dataSistema);
                bancoEntregas.procurarEntregaPedidoID(this.listaPedidos[i].getId()).setData_modificacao(dataSistema);
                bancoEntregas.procurarEntregaPedidoID(this.listaPedidos[i].getId()).setStatus("Enviado");
            }
            else if(this.listaPedidos[i] != null && this.listaPedidos[i].getStatus().equals("Enviado") && this.listaPedidos[i].getData_criacao().isBefore(dataSistema)){
                this.listaPedidos[i].setStatus("Entregue");
                this.listaPedidos[i].setData_modificacao(dataSistema);
                bancoEntregas.procurarEntregaPedidoID(this.listaPedidos[i].getId()).setData_entrega(dataSistema);
                bancoEntregas.procurarEntregaPedidoID(this.listaPedidos[i].getId()).setData_modificacao(dataSistema);
                bancoEntregas.procurarEntregaPedidoID(this.listaPedidos[i].getId()).setStatus("Entregue");
            }
        }
    }
    
    public boolean estaVazio(){
        int cont = 0;
        for(int i = 0; i<this.listaPedidos.length; i++){
            if(this.listaPedidos[i] == null){
                cont++;
            }
        }
        
        if(cont == this.listaPedidos.length)
            return true;
        
        return false;
    }
    
    public String faturamentoAnual(){
        String relatorio = "";
        double soma = 0.0;
        int contAnosUsados = 0;
        int[] anosUsados = new int[100];
        boolean jaFoiContado = false;
        
        for(int i = 0; i<this.listaPedidos.length; i++){
            if(this.listaPedidos[i] != null && (this.listaPedidos[i].getStatus().equals("Enviado") || this.listaPedidos[i].getStatus().equals("Entregue"))){
                
                for(int i2 = 0; i2<contAnosUsados; i2++){
                    if(this.listaPedidos[i].getData_modificacao().getYear() == anosUsados[i2]){
                        jaFoiContado = true;
                    }
                }
                
                if(!jaFoiContado){
                    soma += this.listaPedidos[i].getValor_total();
                    for(int i3 = 0; i3<this.listaPedidos.length; i3++){
                        if(this.listaPedidos[i3] != null 
                           && (this.listaPedidos[i3].getStatus().equals("Enviado") || this.listaPedidos[i3].getStatus().equals("Entregue")) 
                           && !(this.listaPedidos[i3].equals(this.listaPedidos[i]))
                           && this.listaPedidos[i3].getData_modificacao().getYear() == this.listaPedidos[i].getData_modificacao().getYear())
                        {
                            soma += this.listaPedidos[i3].getValor_total();
                        }
                    }
                    relatorio += this.listaPedidos[i].getData_modificacao().getYear() + "\nR$: " + soma + "\n\n";
                    soma = 0.0;
                    anosUsados[contAnosUsados++] = this.listaPedidos[i].getData_modificacao().getYear();
                }
            }
            jaFoiContado = false;
        }
        return relatorio;
    }
    
    public String faturamentoMensal(){
        String relatorio = "";
        double soma = 0.0;
        int contMesesUsados = 0;
        int[] mesesUsados = new int[100];
        boolean jaFoiContado = false;
        
        for(int i = 0; i<this.listaPedidos.length; i++){
            if(this.listaPedidos[i] != null && (this.listaPedidos[i].getStatus().equals("Enviado") || this.listaPedidos[i].getStatus().equals("Entregue"))){
                
                for(int i2 = 0; i2<contMesesUsados; i2++){
                    if(this.listaPedidos[i].getData_modificacao().getMonthValue()== mesesUsados[i2]){
                        jaFoiContado = true;
                    }
                }
                
                if(!jaFoiContado){
                    soma += this.listaPedidos[i].getValor_total();
                    for(int i3 = 0; i3<this.listaPedidos.length; i3++){
                        if(this.listaPedidos[i3] != null 
                           && (this.listaPedidos[i3].getStatus().equals("Enviado") || this.listaPedidos[i3].getStatus().equals("Entregue")) 
                           && !(this.listaPedidos[i3].equals(this.listaPedidos[i]))
                           && this.listaPedidos[i3].getData_modificacao().getMonthValue() == this.listaPedidos[i].getData_modificacao().getMonthValue())
                        {
                            soma += this.listaPedidos[i3].getValor_total();
                        }
                    }
                    relatorio += "Mês " + this.listaPedidos[i].getData_modificacao().getMonthValue() + ":\nR$: " + soma + "\n\n";
                    soma = 0.0;
                    mesesUsados[contMesesUsados++] = this.listaPedidos[i].getData_modificacao().getMonthValue();
                }
            }
            jaFoiContado = false;
        }
        return relatorio;
    }
    
    public String faturamentoDiario(){
        DateTimeFormatter dma = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String relatorio = "";
        double soma = 0.0;
        int contDiasUsados = 0;
        LocalDate[] diasUsados = new LocalDate[100];
        boolean jaFoiContado = false;
        
        for(int i = 0; i<this.listaPedidos.length; i++){
            if(this.listaPedidos[i] != null && (this.listaPedidos[i].getStatus().equals("Enviado") || this.listaPedidos[i].getStatus().equals("Entregue"))){
                
                for(int i2 = 0; i2<contDiasUsados; i2++){
                    if(this.listaPedidos[i].getData_modificacao()== diasUsados[i2]){
                        jaFoiContado = true;
                    }
                }
                
                if(!jaFoiContado){
                    soma += this.listaPedidos[i].getValor_total();
                    for(int i3 = 0; i3<this.listaPedidos.length; i3++){
                        if(this.listaPedidos[i3] != null 
                           && (this.listaPedidos[i3].getStatus().equals("Enviado") || this.listaPedidos[i3].getStatus().equals("Entregue")) 
                           && !(this.listaPedidos[i3].equals(this.listaPedidos[i]))
                           && this.listaPedidos[i3].getData_modificacao() == this.listaPedidos[i].getData_modificacao())
                        {
                            soma += this.listaPedidos[i3].getValor_total();
                        }
                    }
                    relatorio += this.listaPedidos[i].getData_modificacao().format(dma) + "\nR$: " + soma + "\n\n";
                    soma = 0.0;
                    diasUsados[contDiasUsados++] = this.listaPedidos[i].getData_modificacao();
                }
            }
            jaFoiContado = false;
        }
        return relatorio;
    }
    
    public int vendasPeriodo(LocalDate inicio, LocalDate fim){
        int quantasVendas = 0;
        
        for(int i = 0; i<this.listaPedidos.length; i++){
            if(this.listaPedidos[i] != null && (this.listaPedidos[i].getStatus().equals("Enviado") || this.listaPedidos[i].getStatus().equals("Entregue") || this.listaPedidos[i].getStatus().equals("Pago"))){
                if(this.listaPedidos[i].getData_modificacao().isAfter(inicio) && this.listaPedidos[i].getData_modificacao().isBefore(fim)){
                    quantasVendas++;
                }
            }
        }
        return quantasVendas;
    }

    public String vendasCliente(){
        String vendas = "";
        int quantasVendas = 0;
        int contClientesContados = 0;
        int[] clientesContadosID = new int[100];
        boolean jaFoiContado = false;
        
        for(int i = 0; i<this.listaPedidos.length; i++){
            if(this.listaPedidos[i] != null && (this.listaPedidos[i].getStatus().equals("Enviado") || this.listaPedidos[i].getStatus().equals("Entregue") || this.listaPedidos[i].getStatus().equals("Pago"))){
                
                for(int i2 = 0; i2<contClientesContados; i2++){
                    if(this.listaPedidos[i].getId_usuario() == clientesContadosID[i2]){
                        jaFoiContado = true;
                    }
                }
                
                if(!jaFoiContado){
                    quantasVendas++;
                    for(int i3 = 0; i3<this.listaPedidos.length; i3++){
                        if(this.listaPedidos[i3] != null 
                        && (this.listaPedidos[i3].getStatus().equals("Enviado") || this.listaPedidos[i3].getStatus().equals("Entregue") || this.listaPedidos[i].getStatus().equals("Pago")) 
                        && !(this.listaPedidos[i3].equals(this.listaPedidos[i]))
                        && this.listaPedidos[i3].getId_usuario()== this.listaPedidos[i].getId_usuario())
                        {
                            quantasVendas++;
                        }
                    }
                    vendas += "ID do Usuário (Cliente): " + this.listaPedidos[i].getId_usuario() + "\n" + quantasVendas + "\n\n";
                    quantasVendas = 0;
                    clientesContadosID[contClientesContados++] = this.listaPedidos[i].getId_usuario();
                }
            }
            jaFoiContado = false;
        }
        return vendas;
    }

    public String vendasStatus(){
        String vendas = "";
        int quantasVendas = 0;
        int contClientesContados = 0;
        String[] clientesContadosSTATUS = new String[100];
        boolean jaFoiContado = false;
        
        for(int i = 0; i<this.listaPedidos.length; i++){
            if(this.listaPedidos[i] != null && (this.listaPedidos[i].getStatus().equals("Enviado") || this.listaPedidos[i].getStatus().equals("Entregue") || this.listaPedidos[i].getStatus().equals("Pago"))){
                
                for(int i2 = 0; i2<contClientesContados; i2++){
                    if(this.listaPedidos[i].getStatus().equals(clientesContadosSTATUS[i2])){
                        jaFoiContado = true;
                    }
                }
                
                if(!jaFoiContado){
                    quantasVendas++;
                    for(int i3 = 0; i3<this.listaPedidos.length; i3++){
                        if(this.listaPedidos[i3] != null 
                        && (this.listaPedidos[i3].getStatus().equals("Enviado") || this.listaPedidos[i3].getStatus().equals("Entregue") || this.listaPedidos[i].getStatus().equals("Pago")) 
                        && !(this.listaPedidos[i3].equals(this.listaPedidos[i]))
                        && this.listaPedidos[i3].getStatus().equals(this.listaPedidos[i].getStatus()))
                        {
                            quantasVendas++;
                        }
                    }
                    vendas += this.listaPedidos[i].getStatus() + ":\n" + quantasVendas + "\n\n";
                    quantasVendas = 0;
                    clientesContadosSTATUS[contClientesContados++] = this.listaPedidos[i].getStatus();
                }
            }
            jaFoiContado = false;
        }
        return vendas;
    }
}
