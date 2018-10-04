/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.trabalho.Bean;

import com.web.trabalho.Dao.PessoaDao;
import com.web.trabalho.Entidade.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author michael
 */
@ManagedBean
@SessionScoped

@ViewScoped
public class PessoaBean {

    private List<Pessoa> pessoas = new ArrayList<Pessoa>();
    private Pessoa pessoa = null;

    public PessoaBean() {
        pessoa = new Pessoa();
    }

    public void salvar() {
        PessoaDao pessoaDao = new PessoaDao();
        this.pessoa = pessoaDao.addPessoa(this.pessoa);
        this.listar();
    }

    public void BuscarPorId() {
        PessoaDao pessoaDAO = new PessoaDao();
        this.pessoa = pessoaDAO.buscarPorId(this.pessoa.getId());

    }

    public void deletar() {
        PessoaDao pessoaDAO = new PessoaDao();
        pessoaDAO.deletePessoa(pessoa.getId());
        this.listar();
    }

    public void alterar() {
        PessoaDao pessoaDAO = new PessoaDao();
        pessoaDAO.updatePessoa(pessoa);
        this.listar();
    }

    public void listar() {
        PessoaDao pessoaDao = new PessoaDao();
        this.pessoas = pessoaDao.listPessoa();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    private PessoaDao pessoaDao = new PessoaDao();
    
   
    public String envia() {
        PessoaDao usuDao = new PessoaDao();
        Pessoa us;
        String resultado;
        try{
            us= usuDao.BuscaLogin(this.pessoa);
            if(us != null){
                FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().put("usuario", us);
                resultado = "listarProduto.xhtml";
            }else{
                resultado = "index.xhtml";
                
            }
        }catch (Exception e){
        throw e;
        }
        return resultado;
    }

}
