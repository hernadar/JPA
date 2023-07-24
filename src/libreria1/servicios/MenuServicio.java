/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria1.servicios;

import java.util.Scanner;

/**
 *
 * @author dario
 */
public class MenuServicio {
       public void menu() throws Exception{
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        AutorServicio as = new AutorServicio();
        EditorialServicio es = new EditorialServicio();
        LibroServicio ls = new LibroServicio();
        ClienteServicio cs = new ClienteServicio();
        PrestamoServicio ps = new PrestamoServicio();
    int r = 0;
        do{
        System.out.println("Elija una opción del menú");
        System.out.println("1- Crear/Modificar/Eliminar un Autor.");
        System.out.println("2- Crear/Modificar/Eliminar una Editorial.");
        System.out.println("3- Crear/Modificar/Eliminar un Libro.");
        System.out.println("4- Crear/Modificar/Eliminar un Cliente.");
        System.out.println("5- Búsqueda de un Autor por nombre.");
        System.out.println("6- Búsqueda de un libro por ISBN.");
        System.out.println("7- Búsqueda de un libro por Título.");
        System.out.println("8- Búsqueda de un libro/s por nombre de Autor.");
        System.out.println("9- Búsqueda de un libro/s por nombre de Editorial.");
        System.out.println("10- Crear Prestamo");
        System.out.println("11- Crear Devolución");
        System.out.println("12- Listar todos los préstamos.");
        System.out.println("13- Búsqueda de todos los préstamos de un Cliente.");
        
        System.out.println("14- Salir");
        r=leer.nextInt();
        switch (r){
            case 1:
                as.crearModificarElimnar();
                
                break;
            case 2:
                es.crearModificarElimnar();
                break;
            case 3:
                ls.crearModificarElimnar();
                break;
            case 4:
                cs.crearModificarElimnar();                
                break;
            case 5:
                as.buscarAutorPorNombre();
                break;
            case 6:
                ls.buscarLibroPorISBN();
                break;  
            case 7:
                ls.buscarLibroPorTitulo();
                break;
            case 8:
                ls.buscarLibrosPorNombreAutor();
                break;
            case 9:
                ls.buscarLibrosPorNombreEditorial();
                break;
            case 10:
                ps.crearPrestamo();
                break;
            case 11:
                ps.crearDevolucion();
                break;
            case 12:
                ps.buscarPrestamo();
                break; 
            case 13:
                ps.buscarPrestamoPorNombre();
                break; 
        }
                
        
        
        
        } while (r !=14);    
}
}
