/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistema;

import java.time.LocalDate;

/**
 *
 * @author eduardobp
 */
public class Calendario{
    private LocalDate dataHoje;

    public Calendario() {
        setDataHoje(LocalDate.now());
    }

    public LocalDate getDataHoje() {
        return dataHoje;
    }

    public void setDataHoje(LocalDate dataHoje) {
        this.dataHoje = dataHoje;
    }
}
