package model;

import java.util.ArrayList;
import java.util.Locale;

public class Cafeteria {
    private String nombre;
    private String direccion;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Trabajador> listaTrabajadores;
    private ArrayList<Cafe> listaCafes;
    private ArrayList<Alfajor> listaAlfajores;
    private ArrayList<Te> listaTes;
    private ArrayList<Venta> listaVentas;


    public Cafeteria(String nombre, String direccion, ArrayList<Cliente> clientes, ArrayList<Trabajador> trabajadores, ArrayList<Cafe> cafes, ArrayList<Alfajor> alfajores, ArrayList<Te> tes, ArrayList<Venta> ventas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaClientes = clientes;
        this.listaTrabajadores = trabajadores;
        this.listaCafes = cafes;
        this.listaAlfajores = alfajores;
        this.listaTes = tes;
        this.listaVentas = ventas;
    }
    public Cafeteria (){
    }

    public void agregarTrabajador(Trabajador trab) {
        listaTrabajadores.add(trab);
    }
    public void agregarCafe(Cafe caf) {
        listaCafes.add(caf);
    }
    public void agregarAlfajor (Alfajor alf) {
        listaAlfajores.add(alf);
    }
    public void agregarTe (Te te) {
        listaTes.add(te);
    }

    public void asociarCliente(Cliente client) {
        listaClientes.add(client);
    }

    public Cafe buscarCafe (String nombreCafe) {
        for (Cafe caf : listaCafes) {
            if (caf.getNombre().toLowerCase(Locale.ROOT).equals(nombreCafe.toLowerCase(Locale.ROOT))) {
                return caf;
            }
        }
        System.out.println("no esta ese cafe");
        return null;
    }

    public Venta crearVentaCafe (Cliente cliente, Cafe cafe) {
        Venta venta = null;
        if (venderCafe(cliente, cafe)) {
            venta = new Venta(cliente.getNombre(), cafe.getNombre(), String.valueOf(cafe.getPrecio()));
        }
        return venta;
    }
    public boolean venderCafe (Cliente client, Cafe caf) {
        int disponible = client.getBilletera();
        int costo = caf.getPrecio();
        int diferencia = disponible - costo;
        if (diferencia < 0) {
            System.out.println("Le faltan: "+ (diferencia*-1) + " pesos chilenos");
            System.out.println("no le alcanza");
            return false;
        }else {
            System.out.println("Usted tenia: "+ disponible + " y gasto: "+costo+" pesos. Le quedan: "+ diferencia);
            return true;
        }
    }
    public Venta crearVentaAlfajor (Cliente cliente, Alfajor alfajor) {
        Venta venta = null;
        if (venderAlfajor(cliente, alfajor)) {
            venta = new Venta(cliente.getNombre(), alfajor.getNombre(), String.valueOf(alfajor.getPrecio()) );
        }
        return venta;
    }
    public boolean venderAlfajor(Cliente client, Alfajor alfajor) {
        int disponible = client.getBilletera();
        int costo = alfajor.getPrecio();
        int diferencia = disponible - costo;
        if (diferencia < 0) {
            System.out.println("Le faltan: "+ (diferencia*-1) + " pesos chilenos");
            System.out.println("no le alcanza");
            return false;
        }else {
            System.out.println("Usted tenia: "+ disponible + " y gasto: "+costo+" pesos. Le quedan: "+ diferencia);
            return true;
        }
    }
    public Venta crearVentaTe (Cliente cliente, Te te) {
        Venta venta = null;
        if (venderTe(cliente, te)) {
            venta = new Venta(cliente.getNombre(), te.getNombre(), String.valueOf(te.getPrecio()) );
        }
        return venta;
    }
    public boolean venderTe(Cliente client, Te te) {
        int disponible = client.getBilletera();
        int costo = te.getPrecio();
        int diferencia = disponible - costo;
        if (diferencia < 0) {
            System.out.println("Le faltan: "+ (diferencia*-1) + " pesos chilenos");
            return false;
        }else {
            System.out.println("Usted tenia: "+ disponible + " y gasto: "+costo+" pesos. Le quedan: "+ (diferencia));
            return true;
        }
    }
    public Cliente elegirClientePorNombre(String nombre) {
        for (Cliente cli: listaClientes) {
            if (cli.getNombre().toLowerCase(Locale.ROOT).equals(nombre.toLowerCase(Locale.ROOT))) {
                return cli;
            }else {
                System.out.println("no se encontro cliente");
            }
        }
        return null;
    }
    public Cafe elegirCafePorNombre(String nombre) {
        for (Cafe cafe: listaCafes) {
            if (cafe.getNombre().toLowerCase(Locale.ROOT).equals(nombre.toLowerCase(Locale.ROOT))) {
                return cafe;
            }else {
                System.out.println("no se encoontro cafe");
            }
        }
        return null;
    }
    public Alfajor elegirAlfajorPorNombre(String nombre) {
        for (Alfajor alf: listaAlfajores) {
            if (alf.getNombre().toLowerCase(Locale.ROOT).equals(nombre.toLowerCase(Locale.ROOT))) {
                return alf;
            }else {
                System.out.println("no se encoontro alf");
            }
        }
        return null;
    }

    public Te elegirTePorNombre(String nombre) {
        for (Te te: listaTes) {
            if (te.getNombre().toLowerCase(Locale.ROOT).equals(nombre.toLowerCase(Locale.ROOT))) {
                return te;
            }else {
                System.out.println("no se encoontro cafe");
            }
        }
        return null;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(ArrayList<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public ArrayList<Cafe> getListaCafes() {
        return listaCafes;
    }

    public void setListaCafes(ArrayList<Cafe> listaCafes) {
        this.listaCafes = listaCafes;
    }

    public ArrayList<Alfajor> getListaAlfajores() {
        return listaAlfajores;
    }

    public void setListaAlfajores(ArrayList<Alfajor> listaAlfajores) {
        this.listaAlfajores = listaAlfajores;
    }

    public ArrayList<Te> getListaTes() {
        return listaTes;
    }

    public void setListaTes(ArrayList<Te> listaTes) {
        this.listaTes = listaTes;
    }

    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    @Override
    public String toString() {
        return "model.Cafeteria{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", listaClientes=" + listaClientes +
                ", listaTrabajadores=" + listaTrabajadores +
                ", listaCafes=" + listaCafes +
                ", listaAlfajores=" + listaAlfajores +
                ", listaTes=" + listaTes +
                '}';
    }
}