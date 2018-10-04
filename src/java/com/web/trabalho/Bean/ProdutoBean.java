/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.trabalho.Bean;

import com.web.trabalho.Dao.ProdutoDao;
import com.web.trabalho.Entidade.Produto;
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
public class ProdutoBean {

    private List<Produto> produtos = new ArrayList<Produto>();
    private Produto produto = null;

    public ProdutoBean() {
        produto = new Produto();
    }

    public void salvar() {
        ProdutoDao produtoDao = new ProdutoDao();
        this.produto = produtoDao.addProduto(this.produto);
        this.listar();
    }

    public void BuscarPorId() {
        ProdutoDao produtoDao = new ProdutoDao();
        this.produto = produtoDao.buscarPorId(this.produto.getCodProd());

    }

    public void deletar() {
        ProdutoDao ProdutoDao = new ProdutoDao();
        ProdutoDao.deleteProduto(produto.getCodProd());
        this.listar();
    }

    public void alterar() {
        ProdutoDao ProdutoDao = new ProdutoDao();
        ProdutoDao.updateProduto(produto);
        this.listar();
    }

    public void listar() {
        ProdutoDao ProdutoDao = new ProdutoDao();
        this.produtos = ProdutoDao.listProduto();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
