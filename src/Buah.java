// package TugasQUiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Buah {
    String nama;
    String noTelp;

    public static void main(String[] args) {
        Buah buah = new Buah();
        Jeruk jeruk = new Jeruk();
        Mangga mangga = new Mangga();

        Scanner s = new Scanner(System.in);

        System.out.println("=====SELAMAT DATANG di TOKO BUAH HOTARU=====");
        System.out.println("--------------------");

        System.out.print("Masukan Nama Pelanggan: ");
        buah.nama = s.nextLine();

        System.out.print("Masukan No Telp: ");
        buah.noTelp = s.nextLine();

        System.out.println("Jenis buah yang ingin dibeli: ");
        System.out.println("1. Jeruk");
        System.out.println("2. Mangga");
        
        System.out.print("Pilihan: ");
        int pilihan = s.nextInt();
        if (pilihan == 1) {
            jeruk.jenisBuah();

            int pilihanJenis = -1;
            while (true) {
                System.out.print("Pilihan Anda: ");
                pilihanJenis = s.nextInt();

                if (pilihanJenis == 9) {
                    break;
                } else if (!(pilihanJenis == 1 || pilihanJenis == 2 || pilihanJenis == 3)) {
                    continue;
                }

                System.out.print("Banyaknya buah yang dibeli: ");
                int banyakBuahDibeli = s.nextInt();

                if (pilihanJenis == 1) {
                    jeruk.mapBuah.put("Jeruk Nipis", jeruk.mapBuah.get("Jeruk Nipis") + banyakBuahDibeli);
                } else if (pilihanJenis == 2) {
                    jeruk.mapBuah.put("Jeruk Manis", jeruk.mapBuah.get("Jeruk Manis") + banyakBuahDibeli);
                } else if (pilihanJenis == 3) {
                    jeruk.mapBuah.put("Jeruk Bali", jeruk.mapBuah.get("Jeruk Bali") + banyakBuahDibeli);
                }
                System.out.println("Berhasil ditambahkan");
            }
            System.out.println("---------------------------");
            System.out.println("------Struk Pembelian------");
            System.out.println("\tYang Dibeli");
            System.out.println("\tBuah\t\tbanyak buah");

            int i = 1;
            for (var entry : jeruk.mapBuah.entrySet()) {
                if (entry.getValue() != 0) {
                    System.out.println(i + "\t" + entry.getKey() + "\t" + entry.getValue()+ " Kg");
                    i++;
                }
            }

            int totalHarga = jeruk.totalHarga();
            System.out.println();
            System.out.println("Total yang harus dibayar: Rp " + totalHarga);
        } else if (pilihan == 2) {

            mangga.jenisBuah();

            int pilihanJenis = -1;
            while (true) {
                System.out.print("Pilihan Anda: ");
                pilihanJenis = s.nextInt();

                if (pilihanJenis == 9) {
                    break;
                } else if (!(pilihanJenis == 1 || pilihanJenis == 2 || pilihanJenis == 3)) {
                    continue;
                }

                System.out.print("Banyaknya buah yang dibeli: ");
                int banyakBuahDibeli = s.nextInt();

                if (pilihanJenis == 1) {
                    mangga.mapBuah.put("Mangga Harum Manis",
                            mangga.mapBuah.get("Mangga Harum Manis") + banyakBuahDibeli);
                } else if (pilihanJenis == 2) {
                    mangga.mapBuah.put("Mangga Indramayu", mangga.mapBuah.get("Mangga Indramayu") + banyakBuahDibeli);
                } else if (pilihanJenis == 3) {
                    mangga.mapBuah.put("Mangga Simanalagi", mangga.mapBuah.get("Mangga Simanalagi") + banyakBuahDibeli);
                }
                System.out.println("Berhasil ditambahkan");
            }

            System.out.println("---------------------------");
            System.out.println("------Struk Pembelian------");
            System.out.println("\tYang Dibeli");
            System.out.println("\tBuah\t\tbanyak buah");

            int i = 1;
            for (var entry : mangga.mapBuah.entrySet()) {
                if (entry.getValue() != 0) {
                    System.out.println(i + "\t" + entry.getKey() + "\t" + entry.getValue()+ " Kg");
                    i++;
                }
            }

            int totalHarga = mangga.totalHarga();
            System.out.println();
            System.out.println("Total yang harus dibayar: Rp " + totalHarga);
        } else {
            s.close();
            throw new Error("Invalid Input");
        }

        System.out.println("-----------------------");
        System.out.println("Terima Kasih Telah Berbelanja " + buah.nama);
        System.out.println("\tJangan Lupa Datang Kembali");

        s.close();
    }
}

class Jeruk {
    Map<String, Integer> mapBuah = new HashMap<>();

    Jeruk() {
        mapBuah.put("Jeruk Nipis", 0);
        mapBuah.put("Jeruk Manis", 0);
        mapBuah.put("Jeruk Bali", 0);
    }

    public void jenisBuah() {
        System.out.println("\t Jenis Buah Jeruk");
        System.out.println("-----------------------");
        System.out.println("1. Jeruk Nipis\tRp 5.000");
        System.out.println("2. Jeruk Manis\tRp 10.000");
        System.out.println("3. Jeruk Bali\tRp 50.000");
        System.out.println("9. Check Out");
    }

    public int totalHarga() {
        int totalHarga = 0;
        for (var entry : mapBuah.entrySet()) {
            int harga = 0;
            if (entry.getKey() == "Jeruk Nipis") {
                harga = 5000;
            } else if (entry.getKey() == "Jeruk Manis") {
                harga = 10000;
            } else {
                harga = 50000;
            }
            totalHarga += entry.getValue() * harga;
        }
        return totalHarga;
    }
}

class Mangga {
    Map<String, Integer> mapBuah = new HashMap<>();

    Mangga() {
        mapBuah.put("Mangga Harum Manis", 0);
        mapBuah.put("Mangga Indramayu", 0);
        mapBuah.put("Mangga Simanalagi", 0);
    }

    public void jenisBuah() {
        System.out.println("\t Jenis Buah Mangga");
        System.out.println("-----------------------");
        System.out.println("1. Mangga Harum Manis\tRp 15.000");
        System.out.println("2. Mangga Indramayu\tRp 20.000");
        System.out.println("3. Mangga Simanalagi\tRp 30.000");
        System.out.println("9. Check Out");
    }

    public int totalHarga() {
        int totalHarga = 0;
        for (var entry : mapBuah.entrySet()) {
            int harga = 0;
            if (entry.getKey() == "Mangga Harum Manis") {
                harga = 15000;
            } else if (entry.getKey() == "Mangga Indramayu") {
                harga = 20000;
            } else {
                harga = 30000;
            }
            totalHarga += entry.getValue() * harga;
        }
        return totalHarga;
    }
}
