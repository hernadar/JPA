/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria1.servicios;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import libreria1.entidades.Cliente;
import libreria1.entidades.Libro;
import libreria1.entidades.Prestamo;
import libreria1.persistencia.ClienteDAO;
import libreria1.persistencia.LibroDAO;
import libreria1.persistencia.PrestamoDAO;

/**
 *
 * @author dario
 */
public class PrestamoServicio {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    PrestamoDAO pdao = new PrestamoDAO();
    LibroDAO ldao = new LibroDAO();
    ClienteDAO cdao = new ClienteDAO();
    
    public void crearPrestamo() throws Exception{
    try {
        
        Prestamo prestamo = new Prestamo();
        DateFormat formateador= new SimpleDateFormat("dd/M/yy");
        System.out.println("Ingrese la fecha del Prestamo (dd/mm/yyyy)");
        Date fecha= formateador.parse(leer.next());
        Date fechaActual = new Date();
        
        if (fecha.before(fechaActual)){
            System.out.println("Te compraste el De Lorian, Martin Mc Fly?");
        } else {
            prestamo.setFechaPrestamo(fecha);
            ldao.listarLibros();
            System.out.println("Seleccion un ISBN de libro para ser prestado");
            Libro libro = ldao.buscarLibro(leer.nextLong());
            prestamo.setLibro(libro);
            cdao.listarClientes();
            System.out.println("Seleccion el Id de Cliente a quien se le presta el libro");
            Cliente cliente = cdao.buscarCliente(leer.nextInt());
            prestamo.setCliente(cliente);
            pdao.crearPrestamo(prestamo);
        }
    } catch (Exception e){
        throw e;
    }
    }
     public void crearDevolucion() throws Exception{
    try {
        
        Prestamo prestamo = new Prestamo();
        DateFormat formateador= new SimpleDateFormat("dd/M/yy");
        
        pdao.listarPrestamos();
        System.out.println("Ingrese el Id de prestamo a devolver");
        pdao.buscarPrestamo(leer.nextInt());
        System.out.println("Ingrese la fecha de Devolución (dd/mm/yyyy)");
        Date fechaDevolucion= formateador.parse(leer.next());
        // creamos un calendario
        Calendar calendario= new GregorianCalendar();
            //hacemos calculos sobre el calendario
        calendario.setTime(prestamo.getFechaPrestamo());
            //movemos el ccalendario
        calendario.add(Calendar.DATE,14);
            //usamos el formateador y volvemos a mostrar la fecha
        Date fechaTeoricaDeDevolucion = calendario.getTime();
        
        if (fechaDevolucion.before(fechaTeoricaDeDevolucion)){
            System.out.println("Esta devolviendo el Libro a tiempo");
            prestamo.setFechaDevolucion(fechaDevolucion);
        } else {
            System.out.println("Estas devolviendo el Libro con retraso, se te cobrará una multa");
            prestamo.setFechaDevolucion(fechaDevolucion);
            pdao.crearPrestamo(prestamo);
        }
    } catch (Exception e){
        throw e;
    }
    }

    
    
    public void modificarPrestamo(){
    try{    
        pdao.listarPrestamos();
        System.out.println("Ingrese el id del Prestamo a modificar");
        int id = leer.nextInt();
        Prestamo prestamo = pdao.buscarPrestamo(id);
        if(prestamo == null){
            System.out.println("El Prestamo no existe");
        }else {
           // System.out.println("Ingrese el nombre");
           // prestamo.setNombre(leer.next());
           // System.out.println("Ingrese el estado de Alta");
           // cliente.setAlta(leer.nextBoolean());
            pdao.modificarPrestamo(prestamo);
        }
    } catch(Exception e){
        throw e;
    }    
    }
    public void eliminarPrestamo(){
        pdao.listarPrestamos();
        System.out.println("Ingrese el id del Prestamo a eliminar");
        int id = leer.nextInt();
        Prestamo prestamo = pdao.buscarPrestamo(id);
      // cliente.setAlta(false);
        pdao.eliminarPrestamo(prestamo);
    }
    public void buscarPrestamoPorNombre(){
        System.out.println("Ingrese el documento del cliente a buscar");
        long documento = leer.nextLong();
        pdao.buscarPrestamoPorCliente(documento);
        
    }      
    
    
    
}    

