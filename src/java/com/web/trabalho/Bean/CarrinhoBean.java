/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.trabalho.Bean;

import com.web.trabalho.Dao.PedidoDao;
import com.web.trabalho.Entidade.Carrinho;
import com.web.trabalho.Entidade.Item;
import com.web.trabalho.Entidade.Pedido;
import com.web.trabalho.Entidade.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author UNOPAR
 */
@ManagedBean
@SessionScoped
@RequestScoped
public class CarrinhoBean {
    List<Item> cart;
    Carrinho carrinho = new Carrinho();
    

        
        
    

    public CarrinhoBean() {
        this.cart = new ArrayList<Item>();
    }
    
   
    public void addItem(Produto product){
        carrinho.addItem(product);
        listar();
    }
    
    public void listar(){
        this.cart = carrinho.getItems();
    }

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
    
    
}

