/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package towersofhanoi;

/*

Name Sammy Ramadan

CIT130

Date 10/19/24

Purpose of file Main tester class that allocates disks to towers.

*/
import java.util.Scanner;

public class TowersOfHanoi {
    private Tower source;
    private Tower auxiliary;
    private Tower destination;

    public TowersOfHanoi(int numDisks) {
        source = new Tower("Source");
        auxiliary = new Tower("Auxiliary");
        destination = new Tower("Destination");

        // Initialize the source tower with disks
        for (int i = numDisks; i >= 1; i--) {
            source.addDisk(new Disk(i));
        }
    }

    public void solve() {
        System.out.println("Initial State:");
        displayTowers();
        moveDisks(source, destination, auxiliary, source.getDiskCount());
        System.out.println("Final State:");
        displayTowers();
    }
//recursive method for allocation between towers
    private void moveDisks(Tower source, Tower destination, Tower auxiliary, int n) {
        if (n == 1) {
            Disk disk = source.removeDisk();
            destination.addDisk(disk);
            displayTowers();
        } else {
            moveDisks(source, auxiliary, destination, n - 1);
            moveDisks(source, destination, auxiliary, 1);
            moveDisks(auxiliary, destination, source, n - 1);
        }
    }

    public void displayTowers() {
        source.display();
        auxiliary.display();
        destination.display();
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int numDisks = scanner.nextInt();

        TowersOfHanoi hanoi = new TowersOfHanoi(numDisks);
        hanoi.solve();

        scanner.close();
    }
}
