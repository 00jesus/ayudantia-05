package principal;

import data.GestorArchivos;
import model.Cafeteria;
import model.Venta;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        inicializar();
// pequeñas pruebas, para ver donde se iba a crear el archivo txt.
// tambien hay pruebas unitarias
    }
    public static void inicializar() {
        GestorArchivos gestorArchivos = new GestorArchivos();
        ArrayList<Venta> listaVentas = new ArrayList<>();
        Cafeteria cafeteria = new Cafeteria("","",null,null,null,null,null, listaVentas);
        Venta venta1 = new Venta("juan", "cafe", "5000");
        System.out.println(cafeteria.getListaVentas());
        //gestorArchivos.registrarDato(venta1, "data.txt");
        gestorArchivos.leerArchivoVentas(cafeteria, "data.txt");
        //gestorArchivos.leerArchivoVehiculos(cafeteria, "data.txt");
        System.out.println(cafeteria.getListaVentas());
    }


}

