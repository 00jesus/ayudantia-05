public class Trabajador {
    private String nombre;
    private String profesion;


    public Trabajador(String nombre, String profesion) {
        this.nombre = nombre;
        this.profesion = profesion;
    }

    public Trabajador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "nombre='" + nombre + '\'' +
                ", profesion='" + profesion + '\'' +
                '}';
    }
}