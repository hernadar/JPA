/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria1.servicios;

import java.util.Scanner;
import libreria1.entidades.Cliente;
import libreria1.persistencia.ClienteDAO;

/**
 *
 * @author dario
 */
public class ClienteServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ClienteDAO cdao = new ClienteDAO();

    public void crearModificarElimnar() {
        int r = 0;
        do {
            System.out.println("Elija una opción del menú");
            System.out.println("1- Crear un Cliente.");
            System.out.println("2- Modificar un Cliente.");
            System.out.println("3- Eliminar un Cliente.");
            System.out.println("4- Listar Clientes.");
            System.out.println("5- Salir");
            r = leer.nextInt();
            switch (r) {
                case 1:
                    crearCliente();

                    break;
                case 2:
                    modificarCliente();
                    break;
                case 3:
                    eliminarCliente();
                    break;
                case 4:
                    cdao.listarClientes();
                    ;
                    break;

            }

        } while (r != 5);
    }

    public void crearCliente() {
        try {

            Cliente cliente = new Cliente();
            System.out.println("Ingrese el documento del Cliente");
            cliente.setDocumento(leer.nextLong());
            System.out.println("Ingrese el Nombre del Cliente");
            cliente.setNombre(leer.next());
            System.out.println("Ingrese el Apellido del Cliente");
            cliente.setApellido(leer.next());
            System.out.println("Ingrese el Telefono del Cliente");
            cliente.setTelefono(leer.next());
            cdao.crearCliente(cliente);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarCliente() {
        try {
            cdao.listarClientes();
            System.out.println("Ingrese el id del Cliente a modificar");
            int id = leer.nextInt();
            Cliente cliente = cdao.buscarCliente(id);
            if (cliente == null) {
                System.out.println("El Cliente no existe");
            } else {
                System.out.println("Ingrese el documento del Cliente");
                cliente.setDocumento(leer.nextLong());
                System.out.println("Ingrese el Nombre del Cliente");
                cliente.setNombre(leer.next());
                System.out.println("Ingrese el Apellido del Cliente");
                cliente.setApellido(leer.next());
                System.out.println("Ingrese el Telefono del Cliente");
                cliente.setTelefono(leer.next());
                cdao.modificarCliente(cliente);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarCliente() {
        cdao.listarClientes();
        System.out.println("Ingrese el id del Autor a eliminar");
        int id = leer.nextInt();
        Cliente cliente = cdao.buscarCliente(id);
        // cliente.setAlta(false);
        cdao.eliminarCliente(cliente);
    }

    public void buscarClientePorNombre() {
        System.out.println("Ingrese el apellido del cliente a buscar");
        String apellido = leer.next();
        cdao.buscarClientePorApellido(apellido);

    }
}
