/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.trabalho.Dao;

import com.web.trabalho.Entidade.Produto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author michael
 */
public class ProdutoDao {
    
    

    public Produto addProduto(Produto produto) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(produto);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return produto;
    }

    public List<Produto> listProduto() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Produto p");
            List produtos = query.list();
            if (produtos != null && produtos.isEmpty()) {
                return null;
            } else {
                return (List<Produto>) produtos;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Produto>();
        } finally {
            session.close();
        }
    }

    public Produto buscarPorId(int id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Produto p where p.cod_prod = :id");
            query.setParameter("id", id);
            List produtos = query.list();
            if (produtos != null && produtos.isEmpty()) {
                return null;
            } else {
                return (Produto) produtos.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public void updateProduto(Produto produto) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.saveOrUpdate(produto);
            session.flush();
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }

    public void deleteProduto(int id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction beginTransaction = session.beginTransaction();
            Query query = session.createQuery("delete from Produto p where p.cod_prod = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            beginTransaction.commit();
        } catch (Exception e) {
        } finally {
                
            session.close();
        }
    }
    
}
