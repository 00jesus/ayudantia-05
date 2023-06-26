package model;

public class Cliente {
    private String nombre;
    private int billetera;

    public Cliente(String nombre, int billetera) {
        this.nombre = nombre;
        this.billetera = billetera;
    }
    public Cliente() {
    }
    public void iniciarBilleteraRandom() {
        this.billetera = (int)(Math.random()*10001);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBilletera() {
        return billetera;
    }

    public void setBilletera(int billetera) {
        this.billetera = billetera;
    }

    @Override
    public String toString() {
        return "model.Cliente{" +
                "nombre='" + nombre + '\'' +
                ", billetera=" + billetera +
                '}';
    }
}