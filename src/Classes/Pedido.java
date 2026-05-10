/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import DAOs.PedidosDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author eduardobp
 */
public class Pedido {
    private int id;
    private int id_usuario;
    private int id_cupom;
    private String status; //CRIADO, PAGO, ENVIADO, ENTREGUE, CANCELADO
    private double valor_total;
    private String forma_pagamento;
    private LocalDate data_criacao;
    private LocalDate data_modificacao;
    
    private static int cont = 1;
    
    public Pedido(int id_usuario, int id_cupom, double valor_total, String forma_pagamento, LocalDate data_criacao, PedidosDAO bancoPedidos) {
        this.id = cont++;
        this.id_usuario = id_usuario;
        this.id_cupom = id_cupom;
        this.status = "Criado";
        this.valor_total = valor_total;
        this.forma_pagamento = forma_pagamento;
        this.data_criacao = data_criacao;
        this.data_modificacao = data_criacao;
        bancoPedidos.inserirPedido(this);
    }

    public int getId() {
        return id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public int getId_cupom() {
        return id_cupom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValor_total() {
        return valor_total;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public LocalDate getData_criacao() {
        return data_criacao;
    }

    public LocalDate getData_modificacao() {
        return data_modificacao;
    }

    public void setData_modificacao(LocalDate data_modificacao) {
        this.data_modificacao = data_modificacao;
    }
    
    public String toString(int num) {
        DateTimeFormatter FormaData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String CriacaoFormatada = data_criacao.format(FormaData);
        String ModificacaoFormatada = data_modificacao.format(FormaData);
        
        if(num == 0)
            return "ID = " + id + "\nID do Usuário(a) = " + id_usuario + "\nID do Cupom = " + id_cupom + "\n Status = " + status + "\nValor Total = " + valor_total + "\nForma de Pagamento = " + forma_pagamento + "\nData de Criação = " + CriacaoFormatada + "\nData de Modificação = " + ModificacaoFormatada;
        else
            return "ID = " + id + "\nStatus = " + status + "\nValor Total = " + valor_total + "\nForma de Pagamento = " + forma_pagamento + "\nData de Criação = " + CriacaoFormatada;
    }
}
