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
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class ItemVendaDAO {

       private static ItemVendaDAO instance;
       protected EntityManager entityManager;

       public static ItemVendaDAO getInstance(){
         if (instance == null){
            instance = new ItemVendaDAO();
         }

         return instance;
       }

       private ItemVendaDAO() {
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

       public ItemVenda getById(final Long id) {
         return entityManager.find(ItemVenda.class, id);
       }

//       @SuppressWarnings("unchecked")
//       public List<Funcionarios> findAll() {
//         return entityManager.createQuery("FROM " +
//         Funcionarios.class.getName()).getResultList();
//       }
       
       @SuppressWarnings("unchecked")
       public List<ItemVenda> findAll() {
           String sql = "SELECT DISTINCT v FROM ItemVenda v "
                        + " WHERE 1 = 1";
//           sql += " ORDER BY v.dataVenda DESC";
          
          Query q = entityManager.createQuery(sql, ItemVenda.class);
          List<ItemVenda> lista = q.getResultList().stream().distinct().toList();
         
         return lista;
       }
       
       @SuppressWarnings("unchecked")
       public List<ItemVenda> findBy(Long id) {
           String sql = "SELECT DISTINCT iv FROM ItemVenda iv" +
                        " LEFT JOIN FETCH iv.produto p" +
                        " LEFT JOIN FETCH iv.venda v" +
                         " WHERE 1 = 1";
           
           if(id != null){
               sql += " AND iv.venda.id = :id";
           }
           
           sql += " ORDER BY v.dataVenda DESC";
           
          TypedQuery<ItemVenda> q = entityManager.createQuery(sql, ItemVenda.class);
          if(id != null){
              q.setParameter("id", id);
          }

          List<ItemVenda> lista = q.getResultList().stream().distinct().collect(Collectors.toList());
         
          return lista;
       }
       
       public void persist(ItemVenda itemVenda) {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(itemVenda);
            entityManager.getTransaction().commit();
           // JOptionPane.showMessageDialog(null, "itemVenda cadastrada com sucesso!");
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void merge(ItemVenda itemVenda) {
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(itemVenda);
            entityManager.getTransaction().commit();
            //JOptionPane.showMessageDialog(null, "Venda atualizada com sucesso!");
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void remove(ItemVenda itemVenda) {
         try {
            entityManager.getTransaction().begin();
            itemVenda = entityManager.find(ItemVenda.class, itemVenda.getId());
            entityManager.remove(itemVenda);
            entityManager.getTransaction().commit();
            //JOptionPane.showMessageDialog(null, "Venda excluida com sucesso!");
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void removeById(final Long id) {
         try {
            ItemVenda itemVenda = getById(id);
            remove(itemVenda);
         } catch (Exception ex) {
            ex.printStackTrace();
         }
       }
}