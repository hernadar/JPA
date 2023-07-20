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
import libreria1.entidades.Editorial;
import libreria1.persistencia.EditorialDAO;

/**
 *
 * @author dario
 */
public class EditorialServicio {
       Scanner leer = new Scanner(System.in).useDelimiter("\n");
       EditorialDAO edao = new EditorialDAO();
    public void crearModificarElimnar(){
    int r = 0;
        do{
        System.out.println("Elija una opción del menú");
        System.out.println("1- Crear una Editorial.");
        System.out.println("2- Modificar una Editorial.");
        System.out.println("3- Eliminar una Editorial.");
        System.out.println("4- Listar Editoriales.");
        System.out.println("5- Salir");
        r=leer.nextInt();
        switch (r){
            case 1:
                crearEditorial();
                
                break;
            case 2:
                modificarEditorial();
                break;
            case 3:
                eliminarEditorial();
                break;
            case 4:
                edao.listarEditoriales();
                break;
        }
                
        
        
        
        } while (r !=5);    
 }
    public void crearEditorial(){
    try {
        
        Editorial editorial = new Editorial();
        System.out.println("Ingrese el nombre de la Editorial");
        editorial.setNombre(leer.next());
        editorial.setAlta(true);
        edao.crearEditorial(editorial);
    } catch (Exception e){
        throw e;
    }
    }
        
    
    public void modificarEditorial(){
    try{    
        edao.listarEditoriales();
        System.out.println("Ingrese el id de la Editorial a modificar");
        int id = leer.nextInt();
        Editorial editorial = edao.buscarEditorial(id);
        System.out.println("Ingrese el nombre");
        editorial.setNombre(leer.next());
        System.out.println("Ingrese el estado de Alta");
        editorial.setAlta(leer.nextBoolean());
        edao.modificarEditorial(editorial);
    } catch(Exception e){
        throw e;
    }    
    }
    public void eliminarEditorial(){
        edao.listarEditoriales();
        System.out.println("Ingrese el id de la Editorial a eliminar");
        int id = leer.nextInt();
        Editorial editorial = edao.buscarEditorial(id);
        editorial.setAlta(false);
        edao.modificarEditorial(editorial);
    }
    public void buscarEditorialPorNombre(){
        System.out.println("Ingrese el nombre de la editorial a buscar");
        String nombre = leer.next();
        edao.buscarEditorialPorNombre(nombre);
        
    }   
}
