/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.trabalho.Bean;

import com.web.trabalho.Dao.PedidoDao;
import com.web.trabalho.Entidade.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author michael
 */
@ManagedBean
@SessionScoped

@ViewScoped
public class PedidoBean {
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    private Pedido pedido = null;

    public PedidoBean() {
        pedido = new Pedido();
    }

    public void salvar() {
        PedidoDao pedidoDao = new PedidoDao();
        this.pedido = pedidoDao.addPedido(this.pedido);
        
    }

    public void BuscarPorId() {
        PedidoDao pedidoDAO = new PedidoDao();
        this.pedido = pedidoDAO.buscarPorId(this.pedido.getCod());

    }

    public void deletar() {
        PedidoDao pedidoDAO = new PedidoDao();
        pedidoDAO.deletePedido(pedido.getCod());
        
    }

    

   

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    private PedidoDao pedidoDao = new PedidoDao();
    
   
    
    
}
