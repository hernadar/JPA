/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria1.servicios;

import java.util.Scanner;
import libreria1.entidades.Libro;
import libreria1.persistencia.LibroDAO;

/**
 *
 * @author dario
 */
public class LibroServicio {
       Scanner leer = new Scanner(System.in).useDelimiter("\n");
       LibroDAO ldao = new LibroDAO();
    public void crearModificarElimnar(){
    int r = 0;
        do{
        System.out.println("Elija una opción del menú");
        System.out.println("1- Crear un Libro.");
        System.out.println("2- Modificar un Libro.");
        System.out.println("3- Eliminar un Libro.");
        System.out.println("4- Listar Libros.");
        System.out.println("5- Salir");
        r=leer.nextInt();
        switch (r){
            case 1:
                crearLibro();
                
                break;
            case 2:
                modificarLibro();
                break;
            case 3:
                eliminarLibro();
                break;
            case 4:
                ldao.listarLibros();
                break;
        }
                
        
        
        
        } while (r !=5);    
 }
    public void crearLibro(){
    try {
        
        Libro libro = new Libro();
        System.out.println("Ingrese el ISBN del Libro");
        libro.setIsbn(leer.nextLong());
        System.out.println("Ingrese el Titulo del Libro");
        libro.setTitulo(leer.next());
        System.out.println("Ingrese el año del Libro");
        libro.setAnio(leer.nextInt());
        System.out.println("Ingrese la cantidad de ejemplares del Libro");
        libro.setEjemplares(leer.nextInt());
        System.out.println("Ingrese la cantidad de ejemplares prestados del Libro");
        libro.setEjemplaresPrestados(leer.nextInt());
        libro.setEjemplaresRestantes(libro.getEjemplares()-libro.getEjemplaresPrestados());
        libro.setAlta(true);
        ldao.crearLibro(libro);
    } catch (Exception e){
        throw e;
    }
    }
        
    
    public void modificarLibro(){
    try{    
        ldao.listarLibros();
        System.out.println("Ingrese el ISBN del Libro a modificar");
        int id = leer.nextInt();
        Libro libro = ldao.buscarLibro(id);
        System.out.println("Ingrese el titulo");
        libro.setTitulo(leer.next());
        System.out.println("Ingrese el estado de Alta");
        libro.setAlta(leer.nextBoolean());
        ldao.modificarLibro(libro);
    } catch(Exception e){
        throw e;
    }    
    }
    public void eliminarLibro(){
        ldao.listarLibros();
        System.out.println("Ingrese el ISBN del Libro a eliminar");
        int id = leer.nextInt();
        Libro libro = ldao.buscarLibro(id);
        libro.setAlta(false);
        ldao.modificarLibro(libro);
    }
    public void buscarLibroPorTitulo(){
        System.out.println("Ingrese el Titulo del Libro a buscar");
        String nombre = leer.next();
        ldao.buscarLibroPorTitulo(nombre);
        
    }
    public void buscarLibroPorISBN(){
        System.out.println("Ingrese el ISBN del Libro a buscar");
        long id = leer.nextLong();
        ldao.buscarLibro(id);
        
    }
     public void buscarLibrosPorNombreAutor(){
        System.out.println("Ingrese el Nombre del Autor de los libros a buscar");
        String nombre = leer.next();
        ldao.buscarLibrosPorNombreAutor(nombre);
        
    }
    public void buscarLibrosPorNombreEditorial(){
        System.out.println("Ingrese el Nombre de la Editorial de los libros a buscar");
        String nombre = leer.next();
        ldao.buscarLibrosPorNombreEditorial(nombre);
        
    }
}
