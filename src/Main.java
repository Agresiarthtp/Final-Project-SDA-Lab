import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Mahasiswa {
    String nim;
    String nama;
    float ipk;

    public Mahasiswa(String nim, String nama, float ipk){
        this.nim = nim;
        this.nama = nama;
        this.ipk = ipk;
    }

    @Override
    public String toString() {
        return "Mahasiswa{nim='" + this.nim +
                "', nama='" + this.nama +
                "', ipk=" + this.ipk + "}";
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Mahasiswa> dataMahasiswa = new HashMap<>(); //Menggunakan built in bawaan java

        // Menambahkan data awal
        System.out.println("Menambahkan data mahasiswa ke database....");
        dataMahasiswa.put("202411001", new Mahasiswa("202411001", "Putu Bagus", 3.85f));
        dataMahasiswa.put("202411002", new Mahasiswa("202411002", "Indra Dermawan", 3.92f));
        dataMahasiswa.put("202411003", new Mahasiswa("202411003", "Agresia Retha", 3.50f));
        dataMahasiswa.put("202411004", new Mahasiswa("202411004", "Fadli Kurniawan", 3.75f));
        dataMahasiswa.put("202411005", new Mahasiswa("202411005", "Lutfi Zaelani", 3.20f));
        dataMahasiswa.put("202411006", new Mahasiswa("202411006", "Retha Agresia", 3.98f));
        dataMahasiswa.put("202411007", new Mahasiswa("202411007", "Zaelani Lutfi", 2.90f));
        dataMahasiswa.put("202411008", new Mahasiswa("202411008", "Fadli Dermawan", 3.45f));
        dataMahasiswa.put("202411009", new Mahasiswa("202411009", "Putu Tria", 3.60f));
        dataMahasiswa.put("202411010", new Mahasiswa("202411010", "Bagus Indra", 3.15f));


        while (true) {
            System.out.println("\n===== MENU DATABASE MAHASISWA =====");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Cari Mahasiswa Berdasarkan NIM");
            System.out.println("3. Hapus Data Mahasiswa");
            System.out.println("4. Tampilkan Semua Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer scanner

            switch (pilihan) {
                case 1:
                    // Logika untuk menambah data
                    System.out.print("Masukkan NIM: ");
                    String nimBaru = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String namaBaru = scanner.nextLine();
                    System.out.print("Masukkan IPK: (gunakan ',' ");
                    float ipkBaru = scanner.nextFloat();
                    scanner.nextLine(); // Membersihkan buffer

                    dataMahasiswa.put(nimBaru, new Mahasiswa(nimBaru, namaBaru, ipkBaru));
                    System.out.println("Data mahasiswa baru berhasil ditambahkan!");
                    break;

                case 2:
                    // Logika untuk mencari data
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimDicari = scanner.nextLine();
                    Mahasiswa hasil = dataMahasiswa.get(nimDicari);
                    if (hasil != null) {
                        System.out.println("Data Ditemukan!");
                        System.out.println("  -> Nama : " + hasil.nama);
                        System.out.println("  -> NIM  : " + hasil.nim);
                        System.out.println("  -> IPK  : " + hasil.ipk);
                    } else {
                        System.out.println("Data untuk NIM " + nimDicari + " tidak ditemukan.");
                    }
                    break;

                case 3:
                    // Logika untuk menghapus data
                    System.out.print("Masukkan NIM yang akan dihapus: ");
                    String nimHapus = scanner.nextLine();
                    if (dataMahasiswa.remove(nimHapus) != null) {
                        System.out.println("Data untuk NIM " + nimHapus + " berhasil dihapus.");
                    } else {
                        System.out.println("Data untuk NIM " + nimHapus + " tidak ditemukan, tidak ada yang dihapus.");
                    }
                    break;

                case 4:
                    // Logika untuk menampilkan semua data
                    System.out.println("\n--- Daftar Semua Mahasiswa ---");
                    if (dataMahasiswa.isEmpty()) {
                        System.out.println("Database kosong.");
                    } else {
                        for (Map.Entry<String, Mahasiswa> entry : dataMahasiswa.entrySet()) {
                            System.out.println(entry.getValue());
                        }
                    }
                    System.out.println("------------------------------");
                    break;

                case 5:
                    // Keluar dari program
                    System.out.println("Terima kasih! Program selesai.");
                    scanner.close(); // Menutup scanner sebelum keluar
                    return;

                default:
                    System.out.println("Pilihan tidak valid. Silakan masukkan angka 1-5.");

            }
        }
    }
}
