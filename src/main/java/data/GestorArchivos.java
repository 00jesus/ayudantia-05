package data;


import model.Cafeteria;
import model.Venta;
import java.io.*;
import java.time.LocalDate;


public class GestorArchivos {

    public Cafeteria leerArchivoVentas(Cafeteria cafeteria, String direccionArchivo) {
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(",");
                cafeteria.getListaVentas().add(new Venta(data[0], data[1],data[2]) );
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
        return cafeteria;
    }

    //Código genérico para almacenar un objeto, OJO es necesario implementar métodos toString
    public boolean registrarDatoPorDia(Venta venta, String direccionArchivo) {
        boolean lineaVacia = false;
        LocalDate fecha = LocalDate.now();
        try {
            File file = new File(direccionArchivo+"-"+fecha+".txt");
            if (!file.exists()) {
                file.createNewFile();
                lineaVacia = true;
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (lineaVacia == false) {
                bw.newLine();
            }

            bw.write(venta.getNombreCliente()+", "+venta.getDetalle()+", "+venta.getMonto());
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error inesperado");
            return false;
        }
    }

}
