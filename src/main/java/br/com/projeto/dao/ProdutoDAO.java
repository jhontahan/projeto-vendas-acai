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
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class ProdutoDAO {

       private static ProdutoDAO instance;
       protected EntityManager entityManager;

       public static ProdutoDAO getInstance(){
         if (instance == null){
            instance = new ProdutoDAO();
         }

         return instance;
       }

       private ProdutoDAO() {
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

       public Produto getById(final Long id) {
         return entityManager.find(Produto.class, id);
       }

//       @SuppressWarnings("unchecked")
//       public List<Funcionarios> findAll() {
//         return entityManager.createQuery("FROM " +
//         Funcionarios.class.getName()).getResultList();
//       }
       
       @SuppressWarnings("unchecked")
       public List<Produto> findAll() {
           String sql = "SELECT DISTINCT p FROM Produto p "
                        + " WHERE 1 = 1";
           sql += " ORDER BY p.descricao ASC";
          
          Query q = entityManager.createQuery(sql, Produto.class);
          List<Produto> lista = q.getResultList().stream().distinct().toList();
         
         return lista;
       }
       
       @SuppressWarnings("unchecked")
       public List<Produto> findBy(String descricao) {
           String sql = "SELECT DISTINCT p FROM Produto p "
                        + " WHERE 1 = 1";
           
           if(descricao != null){
               sql += " AND p.descricao LIKE :descricao";
           }
                  
           sql += " ORDER BY p.descricao ASC";
          
          Query q = entityManager.createQuery(sql, Produto.class);
          if(descricao != null){
              q.setParameter("descricao", "%" + descricao + "%");
          }
   
          List<Produto> lista = q.getResultList().stream().distinct().toList();
         
          return lista;
       }
       
       @SuppressWarnings("unchecked")
       public Produto findByDescricao(String descricao) {
           String sql = "SELECT DISTINCT p FROM Produto p "
                        + " WHERE 1 = 1";
           
           if(descricao != null){
               sql += " AND p.descricao LIKE :descricao";
           }
                  
//           sql += " ORDER BY f.nome ASC";
          
          Query q = entityManager.createQuery(sql, Produto.class);
          if(descricao != null){
              q.setParameter("descricao", descricao);
          }
            Produto produto = null;
           try {
                produto = (Produto) q.getSingleResult();

           } catch (Exception e) {
               produto = null;
               return produto;
           }
         
          return produto;
       }
       
       public void persist(Produto produto) {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(produto);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void merge(Produto produto) {
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(produto);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void remove(Produto produto) {
         try {
            entityManager.getTransaction().begin();
            produto = entityManager.find(Produto.class, produto.getId());
            entityManager.remove(produto);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void removeById(final Long id) {
         try {
            Produto cliente = getById(id);
            remove(cliente);
         } catch (Exception ex) {
            ex.printStackTrace();
         }
       }
}