/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria1.servicios;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria1.entidades.Autor;
import libreria1.persistencia.AutorDAO;

/**
 *
 * @author dario
 */
public class AutorServicio {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    AutorDAO adao = new AutorDAO();
    public void crearModificarElimnar(){
    int r = 0;
        do{
        System.out.println("Elija una opción del menú");
        System.out.println("1- Crear un Autor.");
        System.out.println("2- Modificar un Autor.");
        System.out.println("3- Eliminar un Autor.");
        System.out.println("4- Listar Autores.");
        System.out.println("5- Salir");
        r=leer.nextInt();
        switch (r){
            case 1:
                crearAutor();
                
                break;
            case 2:
                modificarAutor();
                break;
            case 3:
                eliminarAutor();
                break;
            case 4:
                adao.listarAutores();;
                break;
           
        }
                
        
        
        
        } while (r !=5);    
 }
    public void crearAutor(){
    try {
        
        Autor autor = new Autor();
        System.out.println("Ingrese el nombre del Autor");
        autor.setNombre(leer.next());
        autor.setAlta(true);
        adao.crearAutor(autor);
    } catch (Exception e){
        throw e;
    }
    }
    

    
    
    public void modificarAutor(){
    try{    
        adao.listarAutores();
        System.out.println("Ingrese el id del Autor a modificar");
        int id = leer.nextInt();
        Autor autor = adao.buscarAutor(id);
        if(autor == null){
            System.out.println("El Autor no existe");
        }else {
            System.out.println("Ingrese el nombre");
            autor.setNombre(leer.next());
            System.out.println("Ingrese el estado de Alta");
            autor.setAlta(leer.nextBoolean());
            adao.modificarAutor(autor);
        }
    } catch(Exception e){
        throw e;
    }    
    }
    public void eliminarAutor(){
        adao.listarAutores();
        System.out.println("Ingrese el id del Autor a eliminar");
        int id = leer.nextInt();
        Autor autor = adao.buscarAutor(id);
        autor.setAlta(false);
        adao.eliminarAutor(autor);
    }
    public void buscarAutorPorNombre(){
        System.out.println("Ingrese el nombre del autor a buscar");
        String nombre = leer.next();
        adao.buscarAutorPorNombre(nombre);
        
    }   
}
