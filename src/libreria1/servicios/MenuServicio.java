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
    int r = 0;
        do{
        System.out.println("Elija una opción del menú");
        System.out.println("1- Crear/Modificar/Eliminar un Autor.");
        System.out.println("2- Crear/Modificar/Eliminar una Editorial.");
        System.out.println("3- Crear/Modificar/Eliminar un Libro.");
        System.out.println("4- Búsqueda de un Autor por nombre.");
        System.out.println("5- Búsqueda de un libro por ISBN.");
        System.out.println("6- Búsqueda de un libro por Título.");
        System.out.println("7- Búsqueda de un libro/s por nombre de Autor.");
        System.out.println("8- Búsqueda de un libro/s por nombre de Editorial.");
        System.out.println("9- Salir");
        r=leer.nextInt();
        switch (r){
            case 1:
                as.crearModificarElimnar();
                
                break;
            case 2:
                es.crearModificarElimnar();
                break;
            case 3:
                
                break;
            case 4:
                as.buscarAutorPorNombre();
                
                break;
            case 5:
              
                break;
            case 6:
           
                break;  
            case 7:
              
                break;
            case 8:
             
                break;   
        }
                
        
        
        
        } while (r !=9);    
}
}
