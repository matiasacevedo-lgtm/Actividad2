/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Rectangulo {
    private int x1, y1, x2, y2;

    public Rectangulo(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int calcularArea() {
        return Math.abs((x2 - x1) * (y2 - y1));
    }

    public void mover(int dx) {
        x1 += dx;
        x2 += dx;
    }

    public void mover(int dx, int dy) {
        x1 += dx;
        x2 += dx;
        y1 += dy;
        y2 += dy;
    }

    public String toString() {
        return "Area: " + calcularArea();
    }
}