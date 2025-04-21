public class MataKuliah {
    String kodeMK, namaMK, Dosen;
    int sks;

    public MataKuliah(String kodeMK, String namaMK, int sks, String Dosen) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sks = sks;
        this.Dosen= Dosen;
    }

    public void tampilMatakuliah() {
        System.out.println("Kode MK: " + kodeMK + " | Nama: " + namaMK + " | SKS: " + sks + " | Dosen: " + Dosen);
    }
}
