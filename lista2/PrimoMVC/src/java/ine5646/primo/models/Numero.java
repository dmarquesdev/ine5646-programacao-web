/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5646.primo.models;

/**
 *
 * @author diego
 */
public class Numero {

    private long valor;
    private boolean primo;

    public Numero(long valor) {
        this.valor = valor;
    }

    public long getValor() {
        return valor;
    }

    public boolean isPrimo() {
        return primo;
    }

    public void processarValor() {
        primo = verificaPrimo();
    }

    private boolean verificaPrimo() {
        for (int i = 2; i < valor; i++) {
            if (valor % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + valor;
    }
}
