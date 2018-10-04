/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.trabalho.Entidade;

import com.web.trabalho.Dao.PedidoDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author michael
 */
@ManagedBean
@SessionScoped
public class Carrinho {

    List<Item> items;
    int numberOfItems;
    public double somaCarrinho;
    
    

    public Carrinho() {
        items = new ArrayList<Item>();
        numberOfItems = 0;
        somaCarrinho = 0;
    }

    public void addItem(Produto product) {
        Item scItem = new Item(product);
        items.add(scItem);
        somaCarrinho = somaCarrinho + scItem.getProd().getPreco();
        System.out.println("teste add + uhu__________");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getProd().getNome() + " n: " + i);
        }
    }
    
    public List<Item> getItems() {
        return items;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public double getSomaCarrinho() {
        return somaCarrinho;
    }

    public void setSomaCarrinho(double somaCarrinho) {
        this.somaCarrinho = somaCarrinho;
    }
    
    public void clear() {
        somaCarrinho = 0.0;
        items.removeAll(items);
        System.out.println("Apagooo");
    }
}

