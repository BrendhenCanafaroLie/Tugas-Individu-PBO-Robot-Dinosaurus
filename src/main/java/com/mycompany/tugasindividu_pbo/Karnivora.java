package com.mycompany.tugasindividu_pbo;

// ============================================================================
// SUB CLASS 1: Karnivora 
// ============================================================================

public class Karnivora extends Dinosaurus{
    //ATRIBUT KHUSUS
    private String jenisDagingFavorit; // Simulasi pakan daging
    
    public Karnivora(String id, String nama, String spesies, String eraHidup, String jenisDagingFavorit) {
        // Memanggil constructor Superclass Dinosaurus
        super(id, nama, spesies, eraHidup);
        this.jenisDagingFavorit = jenisDagingFavorit;
    }

    //GETTER
    public String getJenisDagingFavorit() {
        return jenisDagingFavorit;
    }

    
    //OVERRIDING (Mengubah method superclass)
    @Override
    public void makan() {
        System.out.println("Robot Dinosaurus" + getNama() + " si Karnivora memakan " + jenisDagingFavorit + " secara lahap!");
    }
    
    @Override
    public void bersuara() {
        System.out.println("Robot Dinosaurus " + getNama() + " MERAUNG: ROAAARRR! (Suara memburu era " + getEraHidup() + ")");
    }
    
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Kategori         : Dinosaurus Karnivora");
        System.out.println("Daging Simulasi  : " + jenisDagingFavorit);
    }
    
    // Method Khusus Karnivora
    public void berburu() {
        System.out.println("Robot Dinosaurus " + getNama() + " menjalankan program simulasi berburu khas era " + getEraHidup() + "...");
    }
}
