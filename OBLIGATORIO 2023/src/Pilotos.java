public class Pilotos {
    private String nombre;
    private int ocurrencias;
    public Pilotos(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public int getOcurrencias() {
        return ocurrencias;
    }
    public void aumentarOcurrencias(){
        this.ocurrencias++;
    }
    public void resetearOcurrencias(){
        this.ocurrencias = 0;
    }
}
