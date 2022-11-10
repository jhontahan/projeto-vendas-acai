/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

/**
 *
 * @author jhona
 */
import br.com.projeto.model.Funcionarios;
import br.com.projeto.model.Produto;
import static br.com.projeto.model.Produto_.descricao;
import br.com.projeto.model.Vendas;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
           String sql = "SELECT DISTINCT v FROM Venda v "
                        + " WHERE 1 = 1";
           sql += " ORDER BY v.dataVenda DESC";
          
          Query q = entityManager.createQuery(sql, Vendas.class);
          List<Vendas> lista = q.getResultList().stream().distinct().toList();
         
         return lista;
       }
       
       @SuppressWarnings("unchecked")
       public List<Vendas> findBy(Date dataVenda) {
           String sql = "SELECT DISTINCT v FROM Vendas v "
                        + " WHERE 1 = 1";
           
           if(dataVenda != null){
               sql += " AND v.dataVenda >= :dataVenda AND v.dataVenda < :dataVenda";
           }
                  
           sql += " ORDER BY v.dataVenda DESC";
          
          Query q = entityManager.createQuery(sql, Vendas.class);
          if(descricao != null){
              q.setParameter("dataVenda", dataVenda);
          }
   
          List<Vendas> lista = q.getResultList().stream().distinct().toList();
         
          return lista;
       }
       
       public void persist(Vendas venda) {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(venda);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
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