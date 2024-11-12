package Cosechas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Cultivo {
    private String nombre;
    private int tiempoGerminacion; // en semanas
    private int tiempoCrecimiento; // en semanas
    private int tiempoCosecha; // en semanas
    private int tiempoReplantacion; // en semanas

    public Cultivo(String nombre, int tiempoGerminacion, int tiempoCrecimiento, int tiempoCosecha, int tiempoReplantacion) {
        this.nombre = nombre;
        this.tiempoGerminacion = tiempoGerminacion;
        this.tiempoCrecimiento = tiempoCrecimiento;
        this.tiempoCosecha = tiempoCosecha;
        this.tiempoReplantacion = tiempoReplantacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempoGerminacion() {
        return tiempoGerminacion;
    }

    public int getTiempoCosecha() {
        return tiempoCosecha;
    }

    public int getTiempoReplantacion() {
        return tiempoReplantacion;
    }
}