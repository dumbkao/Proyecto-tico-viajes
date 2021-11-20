package ticoviaje.Objetos;

import java.util.Random;

public class Chofer {

    private String nombre, licencia;
    private int edad;

    public Chofer() {
        this.nombre = "";
        this.licencia = licenciaAleatoria();
        this.edad = edadAleatoria();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLicencia() {
        return licencia;
    }

    public static String licenciaAleatoria() {
        char[] chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWYZ".toCharArray();

        int charsLength = chars.length;

        Random random = new Random();

        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            buffer.append(chars[random.nextInt(charsLength)]);
        }

        return ("C2 " + buffer.toString());
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public int getEdad() {
        return edad;
    }

    public static int edadAleatoria() {
        return (int) Math.floor(Math.random() * (40 - 18 + 1) + 18);
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
