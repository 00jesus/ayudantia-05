import java.util.ArrayList;
import java.util.Locale;

public class Cafeteria {
    private String nombre;
    private String direccion;
    public ArrayList<Cliente> listaClientes;
    public ArrayList<Trabajador> listaTrabajadores;
    public ArrayList<Cafe> listaCafes;
    public ArrayList<Alfajor> listaAlfajores;
    public ArrayList<Te> listaTes;


    public Cafeteria(String nombre, String direccion, ArrayList<Cliente> clientes, ArrayList<Trabajador> trabajadores, ArrayList<Cafe> cafes, ArrayList<Alfajor> alfajores, ArrayList<Te> tes) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaClientes = clientes;
        this.listaTrabajadores = trabajadores;
        this.listaCafes = cafes;
        this.listaAlfajores = alfajores;
        this.listaTes = tes;
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
                System.out.println("no se encoontro cliente");
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

    @Override
    public String toString() {
        return "Cafeteria{" +
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