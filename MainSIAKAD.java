import java.util.Scanner;

public class MainSIAKAD {
    static Mahasiswa[] listMhs = {
        new Mahasiswa("22001", "Ali Rahman", "Informatika"),
        new Mahasiswa("22002", "Budi Santoso", "Informatika"),
        new Mahasiswa("22003", "Citra Dewi", "Sistem Informasi Bisnis")
    };

    static MataKuliah[] listMK = {
        new MataKuliah("MK001", "Struktur Data", 3),
        new MataKuliah("MK002", "Basis Data", 3),
        new MataKuliah("MK003", "Desain Web", 3)
    };

    static Penilaian[] listPenilaian = {
        new Penilaian(listMhs[0], listMK[0], 80, 85, 90), // Ali - Struktur Data
        new Penilaian(listMhs[0], listMK[1], 60, 70, 75), // Ali - Basis Data
        new Penilaian(listMhs[1], listMK[0], 70, 76, 80), // Budi - Struktur Data
        new Penilaian(listMhs[2], listMK[1], 85, 90, 95), // Citra - Basis Data
        new Penilaian(listMhs[2], listMK[2], 70, 75, 80)  // Citra - Desain Web
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n== MENU SISTEM AKADEMIK ==");
            System.out.println("1. Tampilkan Daftar Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mata Kuliah");
            System.out.println("3. Tampilkan Data Penilaian");
            System.out.println("4. Urutkan Mahasiswa Berdasarkan Nilai Akhir");
            System.out.println("5. Cari Mahasiswa Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    tampilMahasiswa();
                    break;
                case 2:
                    tampilMatakuliah();
                    break;
                case 3:
                    tampilDataPenilaian();
                    break;
                case 4:
                    urutkanMahasiswa();
                    break;
                case 5:
                    cariMahasiswa(sc);
                    break;
                case 0:
                    System.out.println("keluar dari program. terimakasih (๑ᵔ⤙ᵔ๑)");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }

    public static void tampilMahasiswa() {
        System.out.println("Daftar Mahasiswa:");
        for (Mahasiswa m : listMhs) {
            m.tampilMahasiswa();
        }
    }

    public static void tampilMatakuliah() {
        System.out.println("Daftar Mata Kuliah:");
        for (MataKuliah mk : listMK) {
            mk.tampilMatakuliah();
        }
    }

    public static void tampilDataPenilaian() {
        System.out.println("Data Penilaian:");
        for (Penilaian p : listPenilaian) {
            p.tampilPenilaian();
        }
    }

    public static void urutkanMahasiswa() {
        bubbleSort();
        tampilDataPenilaian();
    }

    public static void bubbleSort() {
        for (int i = 0; i < listPenilaian.length - 1; i++) {
            for (int j = 1; j < listPenilaian.length - i; j++) {
                if (listPenilaian[j].nilaiAkhir > listPenilaian[j - 1].nilaiAkhir) {
                    Penilaian tmp = listPenilaian[j];
                    listPenilaian[j] = listPenilaian[j - 1];
                    listPenilaian[j - 1] = tmp;
                }
            }
        }
    }

    public static void cariMahasiswa(Scanner sc) {
        System.out.print("Masukkan NIM mahasiswa yang dicari: ");
        String cariNIM = sc.nextLine();
        boolean ditemukan = false;

        for (Mahasiswa m : listMhs) {
            if (m.NIM.equals(cariNIM)) {
                System.out.println("Mahasiswa Ditemukan:");
                m.tampilMahasiswa();
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Mahasiswa dengan NIM " + cariNIM + " tidak ditemukan.");
        }
    }
}
