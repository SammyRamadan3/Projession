/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Shapes;
/*
Sammy Ramadan
CIT 130
Design console simulated graphic system
10/3/2024
*/

public abstract class Figure {
    private int X, Y; // the center of the object
    private String name;
    private static int numberOfShapes = 0;

    public Figure() {
        this.X = 0;
        this.Y = 0;
        this.name = "none";
        numberOfShapes++;
    }

    public Figure(int a, int b, String n) {
        this.setX(a);
        this.setY(b);
        this.setName(n);
        numberOfShapes++;
    }

    public void setX(int a) { X = a; }
    public void setY(int b) { Y = b; }
    public void setName(String n) { name = n; }
    public int getX() { return X; }
    public int getY() { return Y; }
    public String getName() { return name; }
    public static int getNumberOfShapes() { return numberOfShapes; }
    
    public abstract void erase();
    public abstract void draw();

    public void center() {
        System.out.println("\nIn Figure. Centering at (" + getX() + "," + getY() + ")");
    }
}
