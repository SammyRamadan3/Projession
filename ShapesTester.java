/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Shapes;

/*
Sammy Ramadan
CIT 130
Tester for graphics system
10/3/2024
*/
public class ShapesTester {
    public static void main(String[] args) {
        Figure[] figures = new Figure[3];
        figures[0] = new Rectangle("r1", 25, 100, 10, 15);
        figures[1] = new Circle("c1", 5, 10, 3);
        figures[2] = new Rectangle("r2", 22, 45, 20, 30);

        for (int i = 0; i < Figure.getNumberOfShapes(); i++) {
            figures[i].draw();
        }
    }
}

