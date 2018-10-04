/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.trabalho.Entidade;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author michael
 */
@ManagedBean
@SessionScoped
public class Item {
    Produto prod;
    short quantity;
    
    public void incrementQtd() {
        quantity++;
    }

    public void decrementQtd() {
        quantity--;
    }
    
    public Item(Produto product) {
        this.prod = product;
        quantity = 1;
    }

    public Produto getProd() {
        return prod;
    }

    public void setProd(Produto prod) {
        this.prod = prod;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    double getValor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

