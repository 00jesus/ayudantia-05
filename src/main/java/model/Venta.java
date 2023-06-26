package model;

public class Venta {
    private String nombreCliente;
    private String detalle;
    private String monto;

    public Venta(String nombreCliente, String detalle, String monto) {
        this.nombreCliente = nombreCliente;
        this.detalle = detalle;
        this.monto = monto;
    }
    public Venta (){}

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", detalle='" + detalle + '\'' +
                ", monto='" + monto + '\'' +
                '}';
    }
}
