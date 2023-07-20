/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria1.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author dario
 * @param <T>
 */
public abstract class DAO <T> {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria1PU");
    EntityManager em = emf.createEntityManager();
     
    protected void conectar(){
         if(!em.isOpen()){
             EntityManager em =emf.createEntityManager();
         }
     }
    protected void desconectar(){
         if(em.isOpen()){
             em.close();
         }
     }
    protected void guardarDatos(T t){
        try {
            conectar();
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch(Exception e){
            throw e;
        } finally {
            //desconectar();
        }
    }
    protected void modificarDatos(T t){
        try {
            conectar();
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch(Exception e){
            throw e;
        } finally {
            //desconectar();
        }
    }
   protected void eliminarDatos(T t){
        try {
            conectar();
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch(Exception e){
            throw e;
        } finally {
            //desconectar();
        }
    }
 
}
