import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        BinarySearchTree bst = new BinarySearchTree();
        GraphRelasiMahasiswa graph = new GraphRelasiMahasiswa();

        Scanner sc = new Scanner(System.in);
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
                    hashTable.tambahMahasiswa(mhs);
                    bst.insert(mhs);
                    graph.tambahMahasiswa(nim);
                    System.out.println("Mahasiswa berhasil ditambahkan.");
                    break;
                case 2:
                    System.out.print("Masukkan NIM: ");
                    String cariNim = sc.nextLine();
                    Mahasiswa hasil = hashTable.cariMahasiswa(cariNim);
                    System.out.println((hasil != null) ? hasil : "Tidak ditemukan.");
                    break;
                case 3:
                    System.out.print("Masukkan Nama: ");
                    String cariNama = sc.nextLine();
                    Mahasiswa hasilNama = bst.searchByNama(cariNama);
                    System.out.println((hasilNama != null) ? hasilNama : "Tidak ditemukan.");
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
                    bst.inorderTraversal();
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
