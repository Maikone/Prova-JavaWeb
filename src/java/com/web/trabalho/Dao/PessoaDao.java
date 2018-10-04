/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.trabalho.Dao;

import com.web.trabalho.Entidade.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author michael
 */
public class PessoaDao {

    public Pessoa addPessoa(Pessoa pessoa) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(pessoa);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return pessoa;
    }

    public List<Pessoa> listPessoa() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Pessoa p");
            List pessoas = query.list();
            if (pessoas != null && pessoas.isEmpty()) {
                return null;
            } else {
                return (List<Pessoa>) pessoas;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Pessoa>();
        } finally {
            session.close();
        }
    }

    public Pessoa buscarPorId(int id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Pessoa p where p.id = :id");
            query.setParameter("id", id);
            List pessoas = query.list();
            if (pessoas != null && pessoas.isEmpty()) {
                return null;
            } else {
                return (Pessoa) pessoas.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public void updatePessoa(Pessoa pessoa) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.saveOrUpdate(pessoa);
            session.flush();
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }

    public void deletePessoa(int id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction beginTransaction = session.beginTransaction();
            Query query = session.createQuery("delete from Pessoa p where p.idPessoa = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            beginTransaction.commit();
        } catch (Exception e) {
        } finally {

            session.close();
        }
    }
    private Session session;

    public Pessoa BuscaLogin(Pessoa pessoa) {
        Pessoa us = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = "from Pessoa where nome = '" + pessoa.getNome()
                    + "' and senha = '" + pessoa.getSenha() + "'";
            Query query = session.createQuery(hql);
            if (!query.list().isEmpty()) {
                us = (Pessoa) query.list().get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return us;
    }
}

