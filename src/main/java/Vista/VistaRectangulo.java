/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author HP
 */

import Controlador.ControladorRectangulo;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VistaRectangulo extends JFrame {

    private ControladorRectangulo controlador;

    private JTextField campoX1;
    private JTextField campoY1;
    private JTextField campoX2;
    private JTextField campoY2;
    private JTextField campoMoverX;
    private JTextField campoMoverY;

    private JTextArea areaTexto;

    private JButton botonCrear;
    private JButton botonArea;
    private JButton botonMoverHorizontal;
    private JButton botonMoverAmbos;

    public VistaRectangulo() {
        controlador = new ControladorRectangulo();

        setTitle("Sistema Rectangulo");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        iniciarComponentes();
        asignarEventos();
    }

    private void iniciarComponentes() {
        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new GridLayout(6, 2, 5, 5));

        campoX1 = new JTextField();
        campoY1 = new JTextField();
        campoX2 = new JTextField();
        campoY2 = new JTextField();
        campoMoverX = new JTextField();
        campoMoverY = new JTextField();

        panelDatos.add(new JLabel("X1"));
        panelDatos.add(campoX1);
        panelDatos.add(new JLabel("Y1"));
        panelDatos.add(campoY1);
        panelDatos.add(new JLabel("X2"));
        panelDatos.add(campoX2);
        panelDatos.add(new JLabel("Y2"));
        panelDatos.add(campoY2);
        panelDatos.add(new JLabel("Mover X"));
        panelDatos.add(campoMoverX);
        panelDatos.add(new JLabel("Mover Y"));
        panelDatos.add(campoMoverY);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 4, 5, 5));

        botonCrear = new JButton("Crear");
        botonArea = new JButton("Area");
        botonMoverHorizontal = new JButton("Mover X");
        botonMoverAmbos = new JButton("Mover XY");

        panelBotones.add(botonCrear);
        panelBotones.add(botonArea);
        panelBotones.add(botonMoverHorizontal);
        panelBotones.add(botonMoverAmbos);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);

        add(panelDatos, BorderLayout.NORTH);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void asignarEventos() {
        botonCrear.addActionListener(e -> {
            int x1 = leerEntero(campoX1, "Ingrese X1");
            int y1 = leerEntero(campoY1, "Ingrese Y1");
            int x2 = leerEntero(campoX2, "Ingrese X2");
            int y2 = leerEntero(campoY2, "Ingrese Y2");

            controlador.crearRectangulo(x1, y1, x2, y2);
            areaTexto.setText("Rectangulo creado correctamente");
        });

        botonArea.addActionListener(e -> {
            int area = controlador.calcularArea();
            areaTexto.setText("Area del rectangulo: " + area);
        });

        botonMoverHorizontal.addActionListener(e -> {
            int desplazamientoX = leerEntero(campoMoverX, "Ingrese desplazamiento horizontal");
            controlador.moverHorizontal(desplazamientoX);;
            
            areaTexto.setText("Rectangulo movido horizontalmente");
        });

        botonMoverAmbos.addActionListener(e -> {
            int desplazamientoX = leerEntero(campoMoverX, "Ingrese desplazamiento en X");
            int desplazamientoY = leerEntero(campoMoverY, "Ingrese desplazamiento en Y");

            controlador.moverRectangulo(desplazamientoX, desplazamientoY);
            areaTexto.setText("Rectangulo movido en X y Y");
        });
    }

    private boolean esNumeroEntero(String texto) {
        if (texto == null || texto.isEmpty()) {
            return false;
        }

        int i = 0;

        if (texto.charAt(0) == '-') {
            if (texto.length() == 1) {
                return false;
            }
            i = 1;
        }

        while (i < texto.length()) {
            if (!Character.isDigit(texto.charAt(i))) {
                return false;
            }
            i++;
        }

        return true;
    }

    private int leerEntero(JTextField campo, String mensaje) {
        String texto = campo.getText().trim();

        while (!esNumeroEntero(texto)) {
            texto = JOptionPane.showInputDialog(this, mensaje);
            if (texto == null) {
                texto = "";
            }
            texto = texto.trim();
        }

        campo.setText(texto);
        return Integer.parseInt(texto);
    }
}