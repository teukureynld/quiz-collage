import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class DataWarga {
    protected String nama;
    protected String nik;
    protected String alamat;
    protected String nomorTelepon;

    // Method overloading untuk input data warga
    public void inputDataWarga(List<String> dataWarga) {
        this.nama = dataWarga.get(0);
        this.nik = dataWarga.get(1);
        this.alamat = dataWarga.get(2);
        this.nomorTelepon = dataWarga.get(3);
    }
}

class DataPekerjaan {
    protected String pekerjaan;
    protected String alamatKantor;

    // Method overloading untuk input data pekerjaan
    public void inputDataPekerjaan(List<String> dataPekerjaan) {
        this.pekerjaan = dataPekerjaan.get(0);
        this.alamatKantor = dataPekerjaan.get(1);
    }
    public void iuranDataPekerjaan(List<String> dataPekerjaan){
        
    }
}

class DataStatus {
    protected String status;
    protected String namaPasangan;
    protected int jumlahAnak;

    // Method overloading untuk input data status
    public void inputDataStatus(List<String> dataStatus) {
        this.status = dataStatus.get(0);
        this.namaPasangan = dataStatus.get(1);
        this.jumlahAnak = Integer.parseInt(dataStatus.get(2));
    }
}

class DataIuran extends DataWarga {
    private int iuranPokok;
    private int iuranSampah;
    private int iuranKeamanan;
    private int iuranSumbangan;

    // Method overloading untuk input data iuran
    public void inputDataIuran(int iuranSampah, int iuranKeamanan, int iuranSumbangan) {
        this.iuranSampah = iuranSampah;
        this.iuranKeamanan = iuranKeamanan;
        this.iuranSumbangan = iuranSumbangan;
        this.iuranPokok = iuranSampah + iuranKeamanan;
    }

    // Method overriding untuk menghitung total iuran
    public int hitungTotalIuran() {
        return iuranPokok + iuranSumbangan;
    }

    @Override
    public String toString() {
        return "NIK: " + nik + "\nTotal Iuran: " + hitungTotalIuran();
    }
}

public class no1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pendataan dan Pembayaran Iuran Warga");
        System.out.println("===================================");

        // Input data warga
        List<String> dataWarga = new ArrayList<>();
        System.out.print("Nama: ");
        dataWarga.add(scanner.nextLine());
        System.out.print("NIK: ");
        dataWarga.add(scanner.nextLine());
        System.out.print("Alamat: ");
        dataWarga.add(scanner.nextLine());
        System.out.print("Nomor Telepon: ");
        dataWarga.add(scanner.nextLine());

        // Input data pekerjaan
        List<String> dataPekerjaan = new ArrayList<>();
        System.out.print("Pekerjaan: ");
        dataPekerjaan.add(scanner.nextLine());
        System.out.print("Alamat Kantor: ");
        dataPekerjaan.add(scanner.nextLine());

        // Input data status
        List<String> dataStatus = new ArrayList<>();
        System.out.print("Status (Menikah/Belum Menikah): ");
        dataStatus.add(scanner.nextLine());
        if ("Menikah".equalsIgnoreCase(dataStatus.get(0))) {
            System.out.print("Nama Pasangan: ");
            dataStatus.add(scanner.nextLine());
            System.out.print("Jumlah Anak: ");
            dataStatus.add(scanner.nextLine());
        } else {
            dataStatus.add("");
            dataStatus.add("0");
        }

        // Input data iuran
        System.out.print("Iuran Sampah: ");
        int iuranSampah = scanner.nextInt();
        System.out.print("Iuran Keamanan: ");
        int iuranKeamanan = scanner.nextInt();
        System.out.print("Iuran Sumbangan: ");
        int iuranSumbangan = scanner.nextInt();

        // Membuat objek DataIuran
        DataIuran dataIuran = new DataIuran();
        dataIuran.inputDataWarga(dataWarga);
        dataIuran.inputDataPekerjaan(dataPekerjaan);
        dataIuran.inputDataStatus(dataStatus);
        dataIuran.inputDataIuran(iuranSampah, iuranKeamanan, iuranSumbangan);
         
        // Menampilkan NIK dan Total Iuran Warga
        System.out.println("\nData Warga dan Total Iuran");
        System.out.println("==========================");
        System.out.println(dataIuran.toString());

        scanner.close();
    }
}
