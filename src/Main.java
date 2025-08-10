import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        BinarySearchTree bst = new BinarySearchTree();
        GraphRelasiMahasiswa graph = new GraphRelasiMahasiswa();

        Scanner sc = new Scanner(System.in);

        System.out.println("Menambahkan data awal ke database...");
        Mahasiswa[] daftarAwal = {
                new Mahasiswa("202411001", "Putu Bagus", 3.85),
                new Mahasiswa("202411002", "Indra Dermawan", 3.92),
                new Mahasiswa("202411003", "Agresia Retha", 3.50),
                new Mahasiswa("202411004", "Fadli Kurniawan", 3.75),
                new Mahasiswa("202411005", "Lutfi Zaelani", 3.20),
                new Mahasiswa("202411006", "Retha Agresia", 3.98),
                new Mahasiswa("202411007", "Zaelani Lutfi", 2.90),
                new Mahasiswa("202411008", "Fadli Dermawan", 3.45),
                new Mahasiswa("202411009", "Putu Tria", 3.60),
                new Mahasiswa("202411010", "Bagus Indra", 3.15)
        };

        for (Mahasiswa mhs : daftarAwal) {
            hashTable.tambahMahasiswa(mhs);
            bst.insert(mhs);
            graph.tambahMahasiswa(mhs.getNim());
        }

        int pilihan;

        do {
            System.out.println("\n=== MENU SISTEM INFORMASI MAHASISWA ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Cari Mahasiswa (NIM)");
            System.out.println("3. Cari Mahasiswa (Nama via BST)");
            System.out.println("4. Tambah Relasi Mahasiswa (Graph)");
            System.out.println("5. Tampilkan Semua Mahasiswa");
            System.out.println("6. Tampilkan Inorder BST (Nama)");
            System.out.println("7. Tampilkan Relasi Mahasiswa (Graph)");
            System.out.println("8. BFS Traversal");
            System.out.println("9. DFS Traversal");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("NIM: ");
                    String nim = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("IPK: ");
                    double ipk = sc.nextDouble();
                    sc.nextLine();
                    Mahasiswa mhs = new Mahasiswa(nim, nama, ipk);

                    // Time Test
                    long startTime = System.nanoTime();
                    hashTable.tambahMahasiswa(mhs);
                    bst.insert(mhs);
                    graph.tambahMahasiswa(nim);
                    long endTime = System.nanoTime();
                    double duration = (endTime - startTime) / 1_000_000.0;

                    System.out.println("Mahasiswa berhasil ditambahkan.");
                    System.out.printf("Waktu eksekusi penambahan: %.4f milidetik.\n", duration);
                    break;
                case 2:
                    System.out.print("Masukkan NIM: ");
                    String cariNim = sc.nextLine();

                    //Time test
                    long startTimeHash = System.nanoTime();
                    Mahasiswa hasil = hashTable.cariMahasiswa(cariNim);
                    long endTimeHash = System.nanoTime();
                    double durationHash = (endTimeHash - startTimeHash) / 1_000_000.0;

                    System.out.println((hasil != null) ? hasil : "Tidak ditemukan.");
                    System.out.printf("Waktu eksekusi pencarian (HashTable): %.4f milidetik.\n", durationHash);
                    break;
                case 3:
                    System.out.print("Masukkan Nama: ");
                    String cariNama = sc.nextLine();

                    // Time test
                    long startTimeBst = System.nanoTime();
                    Mahasiswa hasilNama = bst.searchByNama(cariNama);
                    long endTimeBst = System.nanoTime();
                    double durationBst = (endTimeBst - startTimeBst) / 1_000_000.0;

                    System.out.println((hasilNama != null) ? hasilNama : "Tidak ditemukan.");
                    System.out.printf("Waktu eksekusi pencarian (BST): %.4f milidetik.\n", durationBst);
                    break;
                case 4:
                    System.out.print("NIM Mahasiswa 1: ");
                    String n1 = sc.nextLine();
                    System.out.print("NIM Mahasiswa 2: ");
                    String n2 = sc.nextLine();
                    if (hashTable.ada(n1) && hashTable.ada(n2)) {
                        graph.tambahRelasi(n1, n2);
                        System.out.println("Relasi berhasil ditambahkan.");
                    } else {
                        System.out.println("Salah satu NIM tidak ditemukan.");
                    }
                    break;
                case 5:
                    hashTable.tampilkanSemua();
                    break;
                case 6:
                    // Time test
                    long startTimeTraversal = System.nanoTime();
                    bst.inorderTraversal();
                    long endTimeTraversal = System.nanoTime();
                    double durationTraversal = (endTimeTraversal - startTimeTraversal) / 1_000_000.0;

                    System.out.printf("\nWaktu eksekusi inorder traversal (BST): %.4f milidetik.\n", durationTraversal);
                    break;
                case 7:
                    graph.tampilkanRelasi();
                    break;
                case 8:
                    System.out.print("NIM Awal BFS: ");
                    graph.bfs(sc.nextLine());
                    break;
                case 9:
                    System.out.print("NIM Awal DFS: ");
                    graph.dfs(sc.nextLine());
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        sc.close();
    }
}
