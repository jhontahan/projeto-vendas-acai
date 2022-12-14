/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

/**
 *
 * @author jhona
 */
import br.com.projeto.model.ItemVenda;
import br.com.projeto.model.Vendas;
import br.com.projeto.util.CalendarUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class VendasDAO {

       private static VendasDAO instance;
       protected EntityManager entityManager;

       public static VendasDAO getInstance(){
         if (instance == null){
            instance = new VendasDAO();
         }

         return instance;
       }

       private VendasDAO() {
         entityManager = getEntityManager();
       }

       private EntityManager getEntityManager() {
        EntityManagerFactory factory =
        Persistence.createEntityManagerFactory("conexaoBanco");
        if (entityManager == null) {
          entityManager = factory.createEntityManager();
        }

        return entityManager;
       }

       public Vendas getById(final Long id) {
         return entityManager.find(Vendas.class, id);
       }

//       @SuppressWarnings("unchecked")
//       public List<Funcionarios> findAll() {
//         return entityManager.createQuery("FROM " +
//         Funcionarios.class.getName()).getResultList();
//       }
       
       @SuppressWarnings("unchecked")
       public List<Vendas> findAll() {
           String sql = "SELECT DISTINCT v FROM Vendas v "
                        + " WHERE 1 = 1";
           sql += " ORDER BY v.dataVenda DESC";
          
          Query q = entityManager.createQuery(sql, Vendas.class);
          List<Vendas> lista = q.getResultList().stream().distinct().toList();
         
         return lista;
       }
       
       @SuppressWarnings("unchecked")
       public List<Vendas> findBy(Date dataInicio, Date dataFim, String status, String tipoVenda) {
           String sql = "SELECT DISTINCT v FROM Vendas v" +
                        " LEFT JOIN FETCH v.itensVenda iv" +
                         " WHERE 1 = 1";
           
           if(dataInicio != null){
               sql += " AND v.dataVenda >= :dataInicio";
           }
           
           if (dataFim != null){
               sql += " AND v.dataVenda < :dataFim";
           }
           
           if(status != null){
               sql += " AND v.status LIKE :status";
           }
           
           if(tipoVenda != null){
               sql += " AND v.tipoVenda LIKE :tipo";
           }
                  
           sql += " ORDER BY v.dataVenda asc, v.status desc";
           
          TypedQuery<Vendas> q = entityManager.createQuery(sql, Vendas.class);
          if(dataInicio != null){
              q.setParameter("dataInicio", dataInicio);
          }
          if(dataFim != null){
            Calendar calendar = CalendarUtil.getDateOnly(dataFim);
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            q.setParameter("dataFim", calendar.getTime());
          }
          if(status != null){
              q.setParameter("status", status);
          }
          if(tipoVenda != null){
              q.setParameter("tipo", tipoVenda);
          }
   
          List<Vendas> lista = q.getResultList().stream().distinct().collect(Collectors.toList());
         
          return lista;
       }
       
        @SuppressWarnings("unchecked")
       public Vendas carregaLazzy(Long id) {
           String sql = "SELECT DISTINCT v FROM Vendas v" +
                        " LEFT JOIN FETCH v.itensVenda iv" +
                        " LEFT JOIN FETCH iv.venda v1" +
                        " LEFT JOIN FETCH iv.produto p" +
                         " WHERE 1 = 1";
           
           if(id != null){
               sql += " AND v.id = :id";
           }
           
           sql += " ORDER BY v.dataVenda DESC, v.tipoVenda ASC";
           
          TypedQuery<Vendas> q = entityManager.createQuery(sql, Vendas.class);
          if(id != null){
              q.setParameter("id", id);
          }
   
          Vendas v = q.getSingleResult();
         
          return v;
       }
       
       @SuppressWarnings("unchecked")
       public List<ItemVenda> getItensVenda(Long id) {
           String sql = "SELECT DISTINCT i FROM ItemVenda i" +
                        " LEFT JOIN FETCH i.venda v" +
                        " LEFT JOIN FETCH i.produto p" +
                         " WHERE 1 = 1";
           
           if(id != null){
               sql += " AND i.venda.id = :id";
           }
           
           sql += " ORDER BY v.dataVenda DESC, v.tipoVenda ASC";
           
          TypedQuery<ItemVenda> q = entityManager.createQuery(sql, ItemVenda.class);
          if(id != null){
              q.setParameter("id", id);
          }
   
          List<ItemVenda> lista = q.getResultList().stream().distinct().collect(Collectors.toList());
         
          return lista;
       }
       
       public Long ultimaVenda(){
           String sql = "select max(v.id) from Vendas as v";
           
           //Query q = entityManager.createQuery(sql, Vendas.class);
           
           Query q = entityManager.createQuery(sql, Long.class);
           
           return (Long) q.getSingleResult();
       }
       
       public void persist(Vendas venda) {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(venda);
            entityManager.getTransaction().commit();
            //JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void merge(Vendas vendas) {
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(vendas);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Venda atualizada com sucesso!");
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void remove(Vendas venda) {
         try {
            entityManager.getTransaction().begin();
            venda = entityManager.find(Vendas.class, venda.getId());
            entityManager.remove(venda);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Venda excluida com sucesso!");
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void removeById(final Long id) {
         try {
            Vendas venda = getById(id);
            remove(venda);
         } catch (Exception ex) {
            ex.printStackTrace();
         }
       }
}