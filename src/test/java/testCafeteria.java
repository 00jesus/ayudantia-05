import data.GestorArchivos;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.time.LocalDate;
import java.util.ArrayList;

public class testCafeteria {
    private ArrayList<Trabajador> listaTrabajadores;
    private ArrayList<Cafe> listaCafes;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Alfajor> listaAlfajores;
    private ArrayList<Te> listaTes;
    private ArrayList<Venta> listaVentas;
    private Cafeteria cafeteria;
    private String direccionRepo;
    @BeforeEach
    void iniciarListas () {
        listaTrabajadores = new ArrayList<>();
        listaCafes = new ArrayList<>();
        listaClientes =new ArrayList<>();
        listaAlfajores = new ArrayList<>();
        listaTes = new ArrayList<>();
        listaVentas = new ArrayList<>();
        cafeteria = new Cafeteria("", "", listaClientes, listaTrabajadores,listaCafes, listaAlfajores, listaTes, listaVentas);
        direccionRepo = "src/main/java/data/ventas";
    }

    @Test
    void agregarTrabajadorTest() {
        //ArrayList<Trabajador> listaTrabajadores = new ArrayList<>();
        Trabajador trabajador1 = new Trabajador("Juan", "Barista");
        cafeteria.agregarTrabajador(trabajador1);
        String esperado = String.valueOf(trabajador1);
        String resultado = String.valueOf(cafeteria.getListaTrabajadores().get(0));
        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    void iniciarBilleteraCliente() {
        Cliente cliente1 = new Cliente("Juan", 0);
        int resultado = cliente1.getBilletera();
        cliente1.iniciarBilleteraRandom();
        int esperado = cliente1.getBilletera();
        Assertions.assertNotEquals(esperado, resultado);
    }

    @Test
    void venderCafeTest() {
        Cafe cafe = new Cafe("sueco", 2990, "bebestibles");
        Cliente client = new Cliente("juan", 4000);

        cafeteria.asociarCliente(client);
        cafeteria.agregarCafe(cafe);
        cafeteria.elegirClientePorNombre("juan");
        boolean evaluar = cafeteria.venderCafe(cafeteria.elegirClientePorNombre("juan") , cafeteria.elegirCafePorNombre("sueco"));
        Assertions.assertTrue(evaluar);
    }
    @Test
    void venderAlfajorTest () {
        Alfajor alfajor = new Alfajor("CHOcolate", 2190, "comestibles");
        Cliente client = new Cliente("juan", 4000);

        cafeteria.asociarCliente(client);
        cafeteria.agregarAlfajor(alfajor);
        cafeteria.elegirClientePorNombre("juan");
        boolean evaluar = cafeteria.venderAlfajor(cafeteria.elegirClientePorNombre("juan") , cafeteria.elegirAlfajorPorNombre("chocolate"));
        Assertions.assertTrue(evaluar);
    }

    @Test
    void venderTeTest () {
        Te te = new Te("ingles", 990, "bebestibles");
        Cliente client = new Cliente("Juan", 500);

        cafeteria.asociarCliente(client);
        cafeteria.agregarTe(te);
        cafeteria.elegirClientePorNombre("juan");
        boolean evaluar = cafeteria.venderTe(cafeteria.elegirClientePorNombre("juan") , cafeteria.elegirTePorNombre("INGLES"));
        // assertion false ya que no deberia alcanzarle
        Assertions.assertFalse(evaluar);
    }

    @Test
    void testVentaCafe () {
        String ventaEsperada = String.valueOf(new Venta("juan", "cafe moca", "2990"));

        Cliente cliente1 = new Cliente("juan", 5000);
        Cafe cafe1 = new Cafe("cafe moca", 2990, "Cafe");
        String ventaActual = String.valueOf(cafeteria.crearVentaCafe(cliente1, cafe1));
        Assertions.assertEquals(ventaEsperada, ventaActual);
    }
    @Test
    void testVentaAlfajor () {
        String ventaEsperado = String.valueOf(new Venta("jose", "cacao", "1000"));

        Cliente cliente1 = new Cliente("jose", 10000);
        Alfajor alfajor1 = new Alfajor("cacao", 1000, "Alfajor");
        String ventaActual = String.valueOf(cafeteria.crearVentaAlfajor(cliente1, alfajor1));
        Assertions.assertEquals(ventaEsperado, ventaActual);
    }

    @Test
    void testRegistrarVenta () {
        GestorArchivos gestor = new GestorArchivos();
        Venta venta1 = new Venta("carlo", "cafe", "2000");
        Venta venta2 = new Venta("jose", "alfajor", "4500");
        gestor.registrarDatoPorDia(venta1, direccionRepo);
        gestor.registrarDatoPorDia(venta2, direccionRepo);

    }

    @Test
    void crearUnaVenta () {
        GestorArchivos gestor = new GestorArchivos();
        Cliente cliente = new Cliente("dania", 5000);
        Cafe cafe = new Cafe("Arabigo", 4000, "Cafe");

        gestor.registrarDatoPorDia(cafeteria.crearVentaCafe(cliente, cafe), direccionRepo);
    }
    @Test
    void testLeerVenta () {
        GestorArchivos gestor = new GestorArchivos();
        LocalDate fecha = LocalDate.now();

        gestor.leerArchivoVentas(cafeteria, direccionRepo+"-"+fecha+".txt");
        System.out.println(cafeteria.getListaVentas());
    }
}
