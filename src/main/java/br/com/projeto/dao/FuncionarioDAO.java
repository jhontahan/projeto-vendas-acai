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
import br.com.projeto.view.Frmmenu;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class FuncionarioDAO {

       private static FuncionarioDAO instance;
       protected EntityManager entityManager;

       public static FuncionarioDAO getInstance(){
         if (instance == null){
            instance = new FuncionarioDAO();
         }

         return instance;
       }

       private FuncionarioDAO() {
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

       public Funcionarios getById(final Long id) {
         return entityManager.find(Funcionarios.class, id);
       }

//       @SuppressWarnings("unchecked")
//       public List<Funcionarios> findAll() {
//         return entityManager.createQuery("FROM " +
//         Funcionarios.class.getName()).getResultList();
//       }
       
       @SuppressWarnings("unchecked")
       public List<Funcionarios> findAll() {
           String sql = "SELECT DISTINCT f FROM Funcionarios f "
                        + " WHERE 1 = 1";
           sql += " ORDER BY f.nome ASC";
          
          Query q = entityManager.createQuery(sql, Funcionarios.class);
          List<Funcionarios> lista = q.getResultList().stream().distinct().toList();
         
         return lista;
       }
       
       @SuppressWarnings("unchecked")
       public List<Funcionarios> findBy(String nome) {
           String sql = "SELECT DISTINCT f FROM Funcionarios f "
                        + " WHERE 1 = 1";
           
           if(nome != null){
               sql += " AND f.nome LIKE :nome";
           }
                  
           sql += " ORDER BY f.nome ASC";
          
          Query q = entityManager.createQuery(sql, Funcionarios.class);
          if(nome != null){
              q.setParameter("nome", "%" + nome + "%");
          }
   
          List<Funcionarios> lista = q.getResultList().stream().distinct().toList();
         
          return lista;
       }

       public void persist(Funcionarios cliente) {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void merge(Funcionarios cliente) {
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void remove(Funcionarios cliente) {
         try {
            entityManager.getTransaction().begin();
            cliente = entityManager.find(Funcionarios.class, cliente.getId());
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Funcionário excluido com sucesso!");
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }

       public void removeById(final Long id) {
         try {
            Funcionarios cliente = getById(id);
            remove(cliente);
         } catch (Exception ex) {
            ex.printStackTrace();
         }
       }
       
       //Método efetua login
       
       public void efetuarLogin(String email, String senha) throws Exception{
           try {
               String sql = "SELECT DISTINCT f FROM Funcionarios f "
                        + " WHERE 1 = 1";
           
                if(email != null){
                    sql += " AND f.email LIKE :email";
                }
                
                if(senha != null){
                    sql += " AND f.senha LIKE :senha";
                }

//                sql += " ORDER BY f.nome ASC";

               Query q = entityManager.createQuery(sql, Funcionarios.class);
               if(email != null){
                   q.setParameter("email", email);
               }
               if(senha != null){
                   q.setParameter("senha", senha);
               }

               Funcionarios funcionario = (Funcionarios) q.getSingleResult();
               
               if(funcionario != null){
                   JOptionPane.showMessageDialog(null, "Seja bem vindo ao sistema!");
                   Frmmenu menu = new Frmmenu();
                   menu.setVisible(true);
               }
               
           } catch (Exception e) {
             throw new Exception(e);
                
           }
       }

}