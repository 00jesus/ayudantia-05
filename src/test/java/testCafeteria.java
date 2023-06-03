import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class testCafeteria {

    @Test
    void agregarTrabajadorTest () {
        ArrayList<Trabajador> listaTrabajadores = new ArrayList<>();
        Cafeteria cafeteria = new Cafeteria("","",null,listaTrabajadores, null, null, null);
        Trabajador trabajador1 = new Trabajador("Juan", "Barista");
        cafeteria.agregarTrabajador(trabajador1);
        String esperado = String.valueOf(trabajador1);
        String resultado = String.valueOf(cafeteria.listaTrabajadores.get(0));
        Assertions.assertEquals(esperado, resultado);
    }
    @Test
    void iniciarBilleteraCliente () {
        Cliente cliente1 = new Cliente("Juan", 0);
        int resultado = cliente1.getBilletera();
        cliente1.iniciarBilleteraRandom();
        int esperado = cliente1.getBilletera();
        Assertions.assertNotEquals(esperado, resultado);
    }
    @Test
    void test3 (){

    }
}
