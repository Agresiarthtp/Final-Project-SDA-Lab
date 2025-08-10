import java.util.HashMap;

public class HashTable {
    private HashMap<String, Mahasiswa> mahasiswaMap = new HashMap<>();

    public void tambahMahasiswa(Mahasiswa mhs) {
        mahasiswaMap.put(mhs.getNim(), mhs);
    }

    public Mahasiswa cariMahasiswa(String nim) {
        return mahasiswaMap.get(nim);
    }

    public boolean hapusMahasiswa(String nim) {
        return mahasiswaMap.remove(nim) != null;
    }

    public void tampilkanSemua() {
        if (mahasiswaMap.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.");
        } else {
            mahasiswaMap.values().forEach(System.out::println);
        }
    }

    public boolean ada(String nim) {
        return mahasiswaMap.containsKey(nim);
    }
}
