import java.util.Scanner;

public class Hotel {
    String namaPengunjung;
    int tipeKamar;
    int hargaKamar;
    int lamaMenginap;
    int totalBayar;

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner s = new Scanner(System.in);

        System.out.println("---------------------------");
        System.out.println("PROGRAM PENGINAPAN KAMAR HOTEL Khoerul Anam");

        System.out.print("Masukan Nama Anda: ");
        hotel.namaPengunjung = s.nextLine();

        System.out.println();
        tampilTipeKamar();
        System.out.print("Masukan Pilihan Anda: ");
        hotel.tipeKamar = s.nextInt();

        if (hotel.tipeKamar == 1) {
            hotel.hargaKamar = 400000;
        } else if (hotel.tipeKamar == 2) {
            hotel.hargaKamar = 500000;
        } else if (hotel.tipeKamar == 3) {
            hotel.hargaKamar = 650000;
        } else if (hotel.tipeKamar == 4) {
            hotel.hargaKamar = 750000;
        } else {
            s.close();
            throw new Error("Invalid Input");
        }

        System.out.print("Berapa Lama Anda Akan Menginap: ");
        hotel.lamaMenginap = s.nextInt();

        hotel.hitungBiaya();

        System.out.println();
        System.out.println("---------------------------");
        System.out.println("-----INVOICE TRANSAKSI-----");

        System.out.println("Nama Pengunjung: " + hotel.namaPengunjung);
        System.out.println("Tipe Kamar: " + hotel.tipeKamar);
        System.out.println("Harga Kamar: " + hotel.hargaKamar);
        System.out.println("Lama Menginap: " + hotel.lamaMenginap);
        System.out.println();
        System.out.println("Total Bayar: " + hotel.totalBayar);

        s.close();
    }

    public void hitungBiaya() {
        this.totalBayar = this.lamaMenginap * this.hargaKamar;
    }

    static public void tampilTipeKamar() {
        System.out.println("Tipe Kamar yang Tersedia");
        System.out.println("---------------------------");
        System.out.println("1. Standard Room\tRp 400.000");
        System.out.println("2. Superior Room\tRp 500.000");
        System.out.println("3. Deluxe Room\t\tRp 650.000");
        System.out.println("4. Suite Room\t\tRp 750.000");
    }

}
