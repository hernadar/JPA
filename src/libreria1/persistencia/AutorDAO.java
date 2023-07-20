/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria1.persistencia;

import java.util.List;
import libreria1.entidades.Autor;

/**
 *
 * @author dario
 */
public class AutorDAO extends DAO{
    
    public void crearAutor(Autor a){
       super.guardarDatos(a);
    }
    public void modificarAutor(Autor a){
        super.modificarDatos(a);
    }
    public void eliminarAutor(Autor a){
       super.eliminarDatos(a);
    }
    public Autor buscarAutor(int id){
        System.out.println(id);
       Autor autor = em.find(Autor.class, id);
        System.out.println(autor);
    return autor;
    }
    public void listarAutores(){
        try {
            conectar();
            List<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
            System.out.println("Lista de Autores");
            for (Autor autor : autores) {
                System.out.println(autor.getId() + " - " + autor.getNombre() + " - " + autor.isAlta());
            
            }
    } catch(Exception e){
        throw e;
    } finally {
            //desconectar();
        }
    }
    public void buscarAutorPorNombre(String nombre){
        try {
            conectar();
            List<Autor> autores = em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre").setParameter("nombre", nombre).getResultList() ;
            System.out.println("Lista de Autores");
            for (Autor autor : autores) {
                System.out.println(autor.getId() + " - " + autor.getNombre() + " - " + autor.isAlta());
            
            }
    } catch(Exception e){
        throw e;
    } finally {
            //desconectar();
        }
    }
    
}
