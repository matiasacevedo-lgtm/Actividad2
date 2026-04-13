/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author HP
 */


import Modelo.Rectangulo;

public class ControladorRectangulo {

    private Rectangulo rectangulo;

    public void crearRectangulo(int x1, int y1, int x2, int y2) {
        rectangulo = new Rectangulo(x1, y1, x2, y2);
    }

    public int calcularArea() {
        return rectangulo.calcularArea();
    }

public void moverRectangulo(int dx, int dy) {
    if (rectangulo != null) {
        rectangulo.mover(dx, dy);
    }
}
public void moverHorizontal(int desplazamientoX) {
    if (rectangulo != null) {
        rectangulo.mover(desplazamientoX);
    }
}
}