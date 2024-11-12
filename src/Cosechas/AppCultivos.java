package Cosechas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AppCultivos extends JFrame {
    private JComboBox<String> comboCultivos;
    private JTextArea resultadosArea;
    private JButton calcularButton;

    public AppCultivos() {
        setTitle("Cultivos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear componentes
        String[] cultivos = {"Papa", "Zanahoria"};
        comboCultivos = new JComboBox<>(cultivos);
        resultadosArea = new JTextArea(10, 30);
        resultadosArea.setEditable(false);
        calcularButton = new JButton("Calcular Fechas");

        // Agregar componentes a la ventana
        add(new JLabel("Seleccione un cultivo:"));
        add(comboCultivos);
        add(calcularButton);
        add(new JScrollPane(resultadosArea));

        // Acción del botón
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularFechas();
            }
        });
    }

    private void calcularFechas() {
        Cultivo cultivoSeleccionado;
        if (comboCultivos.getSelectedItem().equals("Papa")) {
            cultivoSeleccionado = new Papa();
        } else {
            cultivoSeleccionado = new Zanahoria();
        }

        LocalDate fechaInicio = LocalDate.now();
        StringBuilder resultados = new StringBuilder();
        resultados.append("Cultivo: ").append(cultivoSeleccionado.getNombre()).append("\n");
        resultados.append("Fecha de inicio: ").append(fechaInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");

        // Calcular fechas
        LocalDate fechaGerminacion = fechaInicio.plusWeeks(cultivoSeleccionado.getTiempoGerminacion());
        LocalDate fechaCosecha = fechaInicio.plusWeeks(cultivoSeleccionado.getTiempoCosecha());
        
        // La replantación ocurre después de la cosecha
        LocalDate fechaReplantacion = fechaCosecha.plusWeeks(cultivoSeleccionado.getTiempoReplantacion());
        
        resultados.append("Fechas teóricas:\n");
        resultados.append(" - Germinación: ").append(fechaGerminacion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
        resultados.append(" - Cosecha: ").append(fechaCosecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
        resultados.append(" - Replantación: ").append(fechaReplantacion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");

        resultadosArea.setText(resultados.toString());
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppCultivos ventana = new AppCultivos();
            ventana.setVisible(true);
        });
    }
}
