package com.mycompany.tugasindividu_pbo;

// ============================================================================
// SUB CLASS 3: Omnivora
// ============================================================================

public class Omnivora extends Dinosaurus{
    //ATRIBUT KHUSUS
    private String makananCampuran;
    
    public Omnivora(String id, String nama, String spesies, String eraHidup, String makananCampuran) {
        // Memanggil constructor Superclass Dinosaurus
        super(id, nama, spesies, eraHidup);
        this.makananCampuran = makananCampuran;
    }
    
    //GETTER
    public String getMakananCampuran() {
        return makananCampuran;
    }
    
    //OVERRIDING (Mengubah method superclass)
    @Override
    public void makan() {
        System.out.println("Robot Dinosaurus" + getNama() + " si Omnivora memakan makanan campuran " + makananCampuran + " (simulasi).");
    }

    @Override
    public void bersuara() {
        System.out.println("Robot Dinosaurus" + getNama() + " BERSUARA: SKREEECH-CACKLE! (Suara bersahut-sahutan)");
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Kategori         : Dinosaurus Omnivora");
        System.out.println("Menu Campuran    : " + makananCampuran);
    }
    
    // Method Khusus Omnivora
    public void berkamuflase() {
        System.out.println("Robot Dinosaurus" + getNama() + "  merespons bahaya dan mulai bersembunyi/berkamuflase.");
    }
}
