import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class testCafeteria {

    @Test
    void agregarTrabajadorTest() {
        ArrayList<Trabajador> listaTrabajadores = new ArrayList<>();
        Cafeteria cafeteria = new Cafeteria("", "", null, listaTrabajadores, null, null, null);
        Trabajador trabajador1 = new Trabajador("Juan", "Barista");
        cafeteria.agregarTrabajador(trabajador1);
        String esperado = String.valueOf(trabajador1);
        String resultado = String.valueOf(cafeteria.listaTrabajadores.get(0));
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
        ArrayList<Cliente> listaClientes =new ArrayList<>();
        ArrayList<Cafe> listaCafes = new ArrayList<>();
        Cafeteria cafeteria = new Cafeteria("", "", listaClientes, null, listaCafes, null, null);
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
        ArrayList<Cliente> listaClientes =new ArrayList<>();
        ArrayList<Alfajor> listaAlfajores = new ArrayList<>();
        Cafeteria cafeteria = new Cafeteria("", "", listaClientes, null,null, listaAlfajores, null);
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
        ArrayList<Cliente> listaClientes =new ArrayList<>();
        ArrayList<Te> listaTes = new ArrayList<>();
        Cafeteria cafeteria = new Cafeteria("", "", listaClientes, null,null, null, listaTes);
        Te te = new Te("ingles", 990, "bebestibles");
        Cliente client = new Cliente("Juan", 500);

        cafeteria.asociarCliente(client);
        cafeteria.agregarTe(te);
        cafeteria.elegirClientePorNombre("juan");
        boolean evaluar = cafeteria.venderTe(cafeteria.elegirClientePorNombre("juan") , cafeteria.elegirTePorNombre("INGLES"));
        // assertion false ya que no deberia alcanzarle
        Assertions.assertFalse(evaluar);
    }

}
