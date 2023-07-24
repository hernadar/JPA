/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria1.persistencia;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import libreria1.entidades.Prestamo;

/**
 *
 * @author dario
 */
public class PrestamoDAO extends DAO{
    
    public void crearPrestamo(Prestamo a){
       super.guardarDatos(a);
    }
    public void modificarPrestamo(Prestamo a){
        super.modificarDatos(a);
    }
    public void eliminarPrestamo(Prestamo a){
       super.eliminarDatos(a);
    }
    public Prestamo buscarPrestamo(int id){
        System.out.println(id);
       Prestamo prestamo = em.find(Prestamo.class, id);
        System.out.println(prestamo);
    return prestamo;
    }
    public void listarPrestamos(){
        try {
            DateFormat formateador= new SimpleDateFormat("dd/M/yy");
            conectar();
            List<Prestamo> prestamos = em.createQuery("SELECT a FROM Prestamo a").getResultList();
            System.out.println("Lista de Prestamos");
            
            for (Prestamo prestamo : prestamos) {
                String fechaDevolucion = null;
                if (prestamo.getFechaDevolucion()!=null) {
                    fechaDevolucion = formateador.format(prestamo.getFechaDevolucion());
                } 
                System.out.println(prestamo.getId() + " - " + formateador.format(prestamo.getFechaPrestamo()) + " - " + fechaDevolucion+ " - " + prestamo.getLibro().getTitulo()+ " - " + prestamo.getCliente().getNombre()+ " - " + prestamo.getCliente().getApellido());
            
            }
    } catch(Exception e){
        throw e;
    } finally {
            //desconectar();
        }
    }
    public void buscarPrestamoPorCliente(long documento){
        try {
            DateFormat formateador= new SimpleDateFormat("dd/M/yy");
            conectar();
            List<Prestamo> prestamos = em.createQuery("SELECT a FROM Prestamo a WHERE a.cliente.documento LIKE :documento").setParameter("documento", documento).getResultList();
            
           
            System.out.println("Lista de Prestamos");
            
            if (prestamos.isEmpty()) {
                System.out.println("El Cliente buscado no tiene prestamos de libros");
            } else{
            for (Prestamo prestamo : prestamos) {
                String fechaDevolucion = null;
                 if (prestamo.getFechaDevolucion()!=null) {
                    fechaDevolucion = formateador.format(prestamo.getFechaDevolucion());
                }
                System.out.println(prestamo.getId() + " - " + formateador.format(prestamo.getFechaPrestamo()) + " - " + fechaDevolucion+ " - " + prestamo.getLibro().getTitulo()+ " - " + prestamo.getCliente().getNombre()+ " - " + prestamo.getCliente().getApellido());
            
            }
            }
    } catch(Exception e){
        throw e;
    } finally {
            //desconectar();
        }
    }        
}
