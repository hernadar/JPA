/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria1.persistencia;

import java.util.List;
import libreria1.entidades.Editorial;

/**
 *
 * @author dario
 */
public class EditorialDAO extends DAO {
     public void crearEditorial(Editorial a){
       super.guardarDatos(a);
    }
    public void modificarEditorial(Editorial a){
        super.modificarDatos(a);
    }
    public void eliminarEditorial(Editorial a){
       super.eliminarDatos(a);
    }
    public Editorial buscarEditorial(int id){
        System.out.println(id);
        Editorial editorial = em.find(Editorial.class, id);
        System.out.println(editorial);
    return editorial;
    }
    public void listarEditoriales(){
        try {
            conectar();
            List<Editorial> editoriales = em.createQuery("SELECT a FROM Editorial a").getResultList();
            System.out.println("Lista de Editoriales");
            for (Editorial editorial : editoriales) {
                System.out.println(editorial.getId() + " - " + editorial.getNombre() + " - " + editorial.isAlta());
            
            }
    } catch(Exception e){
        throw e;
    } finally {
            //desconectar();
        }
    }
    public void buscarEditorialPorNombre(String nombre){
        try {
            conectar();
            List<Editorial> editoriales = em.createQuery("SELECT a FROM Editorial a WHERE a.nombre LIKE :nombre").setParameter("nombre", nombre).getResultList() ;
            System.out.println("Lista de Editoriales");
            for (Editorial editorial : editoriales) {
                System.out.println(editorial.getId() + " - " + editorial.getNombre() + " - " + editorial.isAlta());
            
            }
    } catch(Exception e){
        throw e;
    } finally {
            //desconectar();
        }
    }
}
