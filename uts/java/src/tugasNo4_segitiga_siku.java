import java.util.Scanner;

public class tugasNo4_segitiga_siku {

    private int axis_alas;
    private int axis_tinggi;
    private Scanner input;

    // Constructor
    public tugasNo4_segitiga_siku() {
        this.input = new Scanner(System.in);
    }

    public void execution() {
        System.out.print("Masukkan nilai alas : ");
        axis_alas = input.nextInt();

        System.out.print("Masukkan nilai tinggi : ");
        axis_tinggi = input.nextInt();
    }

    public int calculatedExecution() {
        int result = (axis_alas * axis_tinggi) / 2;
        return result;
    }

    public static void main(String[] args) {
        tugasNo4_segitiga_siku triangle = new tugasNo4_segitiga_siku();

        System.out.println("Java is Running!\n");

        triangle.execution();
        int result = triangle.calculatedExecution();

        System.out.println("Hasil dari perhitungan input : " + result);
    }
}
