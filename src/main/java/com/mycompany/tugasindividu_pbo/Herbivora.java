package com.mycompany.tugasindividu_pbo;

// ============================================================================
// SUB CLASS 2: Herbivora
// ============================================================================

public class Herbivora extends Dinosaurus{
    //ATRIBUT KHUSUS
    private String jenisTanamanFavorit; // Simulasi pakan rumput
    
    public Herbivora(String id, String nama, String spesies, String eraHidup, String jenisTanamanFavorit) {
        // Memanggil constructor Superclass Dinosaurus
        super(id, nama, spesies, eraHidup);
        this.jenisTanamanFavorit = jenisTanamanFavorit;
    }
    
    //GETTER
    public String getJenisTanamanFavorit() {
        return jenisTanamanFavorit;
    }
    
    //OVERRIDING (Mengubah method superclass)
    @Override
    public void makan() {
        System.out.println("Robot Dinosaurus" + getNama() + " si Herbivora mengunyah " + jenisTanamanFavorit + " (simulasi flora " + getEraHidup() + ").");
    }

    @Override
    public void bersuara() {
        System.out.println("Robot Dinosaurus" + getNama() + " BERSUARA: HUMMM-GROOAN~ (Suara lembut khas " + getEraHidup() + ")");
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Kategori         : Dinosaurus Herbivora");
        System.out.println("Tanaman Simulasi : " + jenisTanamanFavorit);
    }
    
    // Method Khusus Herbivora
    public void menggembala() {
        System.out.println("Robot Dinosaurus" + getNama() + " melakukan patroli otomatis di area kandang selama 2 menit");
    }
    
    
}
