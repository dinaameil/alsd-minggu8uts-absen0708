import java.util.Scanner;

public class MainSIAKAD {
    static Mahasiswa[] listMhs = {
        new Mahasiswa("22001", "Ali Rahman", "Informatika"),
        new Mahasiswa("22002", "Budi Santoso", "Informatika"),
        new Mahasiswa("22003", "Citra Dewi", "Sistem Informasi Bisnis"),
        new Mahasiswa("22004", "Dina Mei", "Sistem Informasi Bisnis"),
        new Mahasiswa("22005", "Dea Marsel", "Desain Web")
    };

    static MataKuliah[] listMK = {
        new MataKuliah("MK001", "Struktur Data", 3, "Alexander S.Pd"),
        new MataKuliah("MK002", "Basis Data", 3, "Putra Abdullah S.Kom"),
        new MataKuliah("MK003", "Desain Web", 3, "Fadhil Jaidi S.Kom")
    };

    static Penilaian[] listPenilaian = {
        new Penilaian(listMhs[0], listMK[0], 80, 85, 90), // Ali - Struktur Data
        new Penilaian(listMhs[0], listMK[1], 60, 70, 75), // Ali - Basis Data
        new Penilaian(listMhs[1], listMK[0], 70, 76, 80), // Budi - Struktur Data
        new Penilaian(listMhs[2], listMK[1], 85, 90, 95), // Citra - Basis Data
        new Penilaian(listMhs[2], listMK[2], 70, 75, 80),  // Citra - Desain Web
        new Penilaian(listMhs[3], listMK[1], 90, 90, 95), // Dina - Basis Data
        new Penilaian(listMhs[4], listMK[2], 90, 85, 80)  // Dea - Desain Web
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
                    System.out.println("keluar dari program. terimakasih");
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
        Scanner input = new Scanner(System.in);
        System.out.println("Pilih metode pengurutan:");
        System.out.println("1. Bubble Sort - Descending");
        System.out.println("2. Selection Sort- Ascending");
        System.out.print("Pilihan: ");
        int metode = input.nextInt();

        switch (metode) {
            case 1:
                bubbleSort();
                break;
            case 2:
                selectionSort();
                break;
            default:
                System.out.println("Metode tidak valid.");
                return;
        }

        System.out.println("Mahasiswa setelah diurutkan berdasarkan Nilai Akhir:");
        tampilDataPenilaian();
    }

    public static void cariMahasiswa(Scanner input) {
        System.out.print("Masukkan NIM mahasiswa yang dicari: ");
        String nim = input.nextLine();

        Mahasiswa found = null;
        for (Mahasiswa mhs : listMhs) {
            if (mhs.NIM.equals(nim)) {
                found = mhs;
                break;
            }
        }

        if (found != null) {
            System.out.println("Mahasiswa Ditemukan: ");
            System.out.println("NIM: " + found.NIM + " | Nama: " + found.nama + " | Prodi: " + found.prodi);
        } else {
            System.out.println("Mahasiswa tidak ditemukan.");
        }
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

    public static void selectionSort() {
        for (int i = 0; i < listPenilaian.length - 1; i++) {
            int idxMin = i;
            for (int j = i + 1; j < listPenilaian.length; j++) {
                if (listPenilaian[j].nilaiAkhir < listPenilaian[idxMin].nilaiAkhir) {
                    idxMin = j;
                }
            }
            Penilaian tmp = listPenilaian[idxMin];
            listPenilaian[idxMin] = listPenilaian[i];
            listPenilaian[i] = tmp;
        }
    }
    
}