/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria1.persistencia;

import java.util.List;
import libreria1.entidades.Cliente;

/**
 *
 * @author dario
 */
public class ClienteDAO extends DAO{
    public void crearCliente(Cliente a){
       super.guardarDatos(a);
    }
    public void modificarCliente(Cliente a){
        super.modificarDatos(a);
    }
    public void eliminarCliente(Cliente a){
        try {
            conectar();
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
        } catch(Exception e){
            throw e;
        } finally {
            //desconectar();
        }
    }
    public Cliente buscarCliente(int id){
        System.out.println(id);
       Cliente autor = em.find(Cliente.class, id);
        System.out.println(autor);
    return autor;
    }
    public void listarClientes(){
        try {
            conectar();
            List<Cliente> clientes = em.createQuery("SELECT a FROM Cliente a").getResultList();
            System.out.println("Lista de Clientes");
            for (Cliente cliente : clientes) {
                System.out.println(cliente.getId() + " - " + cliente.getDocumento() + " - " + cliente.getNombre()+ " - " + cliente.getApellido()+ " - " + cliente.getTelefono());
            
            }
    } catch(Exception e){
        throw e;
    } finally {
            //desconectar();
        }
    }
    public void buscarClientePorApellido(String apellido){
        try {
            conectar();
            List<Cliente> clientes = em.createQuery("SELECT a FROM Cliente a WHERE a.apellido LIKE :apellido").setParameter("apellido", apellido).getResultList();
            
           
            System.out.println("Lista de Clientes");
            if (clientes.isEmpty()) {
                System.out.println("El Cliente buscado no existe");
            } else{
            for (Cliente cliente : clientes) {
                System.out.println(cliente.getId() + " - " + cliente.getDocumento() + " - " + cliente.getNombre()+ " - " + cliente.getApellido()+ " - " + cliente.getTelefono());
            
            }
            }
    } catch(Exception e){
        throw e;
    } finally {
            //desconectar();
        }
    }    
}
