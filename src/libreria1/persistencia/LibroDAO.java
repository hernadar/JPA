/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria1.persistencia;

import java.util.List;
import libreria1.entidades.Libro;

/**
 *
 * @author dario
 */
public class LibroDAO extends DAO{
         public void crearLibro(Libro a){
       super.guardarDatos(a);
    }
    public void modificarLibro(Libro a){
        super.modificarDatos(a);
    }
    public void eliminarEditorial(Libro a){
       super.eliminarDatos(a);
    }
    public Libro buscarLibro(long id){
        System.out.println(id);
        Libro libro = em.find(Libro.class, id);
        System.out.println(libro);
    return libro;
    }
    public void listarLibros(){
        try {
            conectar();
            List<Libro> libros = em.createQuery("SELECT a FROM Libro a").getResultList();
            System.out.println("Lista de Libros");
            for (Libro libro : libros) {
                System.out.println(libro.getIsbn() + " - " + libro.getTitulo() + " - " + libro.isAlta());
            
            }
    } catch(Exception e){
        throw e;
    } finally {
            //desconectar();
        }
    }
    public void buscarLibroPorTitulo(String titulo){
        try {
            conectar();
            List<Libro> libros = em.createQuery("SELECT a FROM Libro a WHERE a.titulo LIKE :titulo").setParameter("titulo", titulo).getResultList() ;
            System.out.println("Lista de Libros");
            if (libros.isEmpty()){
                System.out.println("El libro buscado no existe");
            } else {
            for (Libro libro : libros) {
                System.out.println(libro.getIsbn() + " - " + libro.getTitulo() + " - " + libro.isAlta());
            
            }
            }
    } catch(Exception e){
        throw e;
    } finally {
            //desconectar();
        }
    }
    public void buscarLibrosPorNombreAutor(String nombre){
        try {
            conectar();
            List<Libro> libros = em.createQuery("SELECT a FROM Libro a WHERE a.autor.nombre LIKE : dario").getResultList() ;
            System.out.println("Lista de Libros");
            if (libros.isEmpty()){
                System.out.println("Los libros buscados no existen");
            } else {
            for (Libro libro : libros) {
                System.out.println(libro.getIsbn() + " - " + libro.getTitulo() + " - " + libro.isAlta());
            
            }
            }
    } catch(Exception e){
        throw e;
    } finally {
            //desconectar();
        }
    }
     public void buscarLibrosPorNombreEditorial(String nombre){
        try {
            conectar();
            List<Libro> libros = em.createQuery("SELECT a FROM Libro a JOIN Editorial WHERE a.autor.nombre LIKE :nombre").setParameter("nombre", nombre).getResultList() ;
            System.out.println("Lista de Libros");
            if (libros.isEmpty()){
                System.out.println("Los libros buscados no existen");
            } else{
            for (Libro libro : libros) {
                System.out.println(libro.getIsbn() + " - " + libro.getTitulo() + " - " + libro.isAlta());
            
            } 
            }
    } catch(Exception e){
        throw e;
    } finally {
            //desconectar();
        }
    }
}
