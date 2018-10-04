/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.trabalho.Dao;

import com.web.trabalho.Entidade.Pedido;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author UNOPAR
 */
public class PedidoDao {
    public Pedido addPedido(Pedido pedido) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(pedido);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return pedido;
    }

    public List<Pedido> listPedido() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Produto p");
            List pedidos = query.list();
            if (pedidos != null && pedidos.isEmpty()) {
                return null;
            } else {
                return (List<Pedido>) pedidos;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Pedido>();
        } finally {
            session.close();
        }
    }

    public Pedido buscarPorId(int id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Pedido p where p.cod_prod = :id");
            query.setParameter("id", id);
            List pedidos = query.list();
            if (pedidos != null && pedidos.isEmpty()) {
                return null;
            } else {
                return (Pedido) pedidos.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public void updatePedido(Pedido pedido) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.saveOrUpdate(pedido);
            session.flush();
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }

    public void deletePedido(int id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction beginTransaction = session.beginTransaction();
            Query query = session.createQuery("delete from Pedido p where p.cod_prod = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            beginTransaction.commit();
        } catch (Exception e) {
        } finally {
                
            session.close();
        }
    }
}
