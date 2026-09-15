package com.mycompany.tugasindividu_pbo;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {

    private static ArrayList<Dinosaurus> daftarDino = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Data Awal 
        daftarDino.add(new Karnivora("R-001", "Rexy-Bot", "Tyrannosaurus Rex", "Kapur Akhir (68-66 JTL)", "Daging Sapi (Simulasi)"));
        daftarDino.add(new Herbivora("R-002", "Stego-Bot", "Stegosaurus", "Jura Akhir (155-150 JTL)", "Daun Pakis (Simulasi)"));
        daftarDino.add(new Omnivora("R-003", "Ovi-Bot", "Oviraptor", "Kapur Akhir (75 JTL)", "Biji & Telur (Simulasi)"));

        int pilihan = -1;
        while (pilihan != 0) {
            System.out.println("\n=========================================");
            System.out.println(" SISTEM MANAJEMEN ROBOT TAMAN DINOSAURUS ");
            System.out.println("=========================================");
            System.out.println("1. Tambah Robot Dinosaurus Baru");
            System.out.println("2. Tampilkan Semua Robot Dinosaurus");
            System.out.println("3. Simulasi Beri Makan Dinosaurus");
            System.out.println("4. Uji Suara Robot Dinosaurus");
            System.out.println("5. Jalankan Aksi Khusus Jenis Dinosaurus");
            System.out.println("6. Hapus Robot Dinosaurus dari Taman");
            System.out.println("0. Keluar Program");
            System.out.println("=========================================");
            System.out.print("Pilih menu (0-6): ");

            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    tambahDinosaurus();
                    break;
                case 2:
                    tampilkanSemuaDino();
                    break;
                case 3:
                    beriMakanDino();
                    break;
                case 4:
                    dengarkanSuaraDino();
                    break;
                case 5:
                    aksiKhusus();
                    break;
                case 6:
                    hapusDino();
                    break;
                case 0:
                    System.out.println("\nTerima kasih telah menggunakan Sistem Manajemen Robot Dinosaurus!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak tersedia.");
            }
            
            
        }
        
    }
        // 1. Tambah Dinosaurus Baru
    private static void tambahDinosaurus() {
        System.out.println("\n--- TAMBAH ROBOT DINOSAURUS BARU ---");
        System.out.println("Pilih Kategori:");
        System.out.println("1. Karnivora");
        System.out.println("2. Herbivora");
        System.out.println("3. Omnivora");
        System.out.print("Pilihan (1-3): ");
        int kat = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan ID Robot (misal: R-004): ");
        String id = scanner.nextLine();
        System.out.print("Masukkan Nama Robot: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Spesies/Model: ");
        String spesies = scanner.nextLine();
        System.out.print("Masukkan Era Prasejarah (misal: Kapur Akhir / Jura): ");
        String eraHidup = scanner.nextLine();

        if (kat == 1) {
            System.out.print("Jenis Daging Simulasi: ");
            String daging = scanner.nextLine();
            daftarDino.add(new Karnivora(id, nama, spesies, eraHidup, daging));
        } else if (kat == 2) {
            System.out.print("Jenis Tanaman Simulasi: ");
            String tanaman = scanner.nextLine();
            daftarDino.add(new Herbivora(id, nama, spesies, eraHidup, tanaman));
        } else if (kat == 3) {
            System.out.print("Menu Pakan Campuran Simulasi: ");
            String menu = scanner.nextLine();
            daftarDino.add(new Omnivora(id, nama, spesies, eraHidup, menu));
        } else {
            System.out.println("Kategori tidak valid. Pendaftaran dibatalkan.");
            return;
        }

        System.out.println("Robot Dinosaururs " + nama + " berhasil didaftarkan ke sistem!");
    }

    // 2. Tampilkan Semua Dinosaurus
    private static void tampilkanSemuaDino() {
        System.out.println("\n--- DAFTAR ROBOT DINOSAURUS DI TAMAN ---");
        if (daftarDino.isEmpty()) {
            System.out.println("Belum ada robot dinosaurus di taman.");
            return;
        }

        for (int i = 0; i < daftarDino.size(); i++) {
            System.out.println("-----------------------------------------");
            System.out.println("Robot #" + (i + 1));
            daftarDino.get(i).tampilkanInfo();
        }
        System.out.println("-----------------------------------------");
    }

    // Helper Cari Dino berdasarkan Index
    private static Dinosaurus pilihDino() {
        tampilkanSemuaDino();
        if (daftarDino.isEmpty()) return null;

        System.out.print("Pilih nomor robot (1-" + daftarDino.size() + "): ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < daftarDino.size()) {
            return daftarDino.get(index);
        } else {
            System.out.println("Nomor robot tidak ditemukan.");
            return null;
        }
    }

    // 3. Simulasi Beri Makan (Polymorphism Override)
    private static void beriMakanDino() {
        System.out.println("\n--- SIMULASI BERI MAKAN ---");
        Dinosaurus d = pilihDino();
        if (d != null) {
            d.makan();
        }
    }

    // 4. Uji Suara (Polymorphism Override)
    private static void dengarkanSuaraDino() {
        System.out.println("\n--- UJI SUARA ROBOT ---");
        Dinosaurus d = pilihDino();
        if (d != null) {
            d.bersuara();
        }
    }

    // 5. Aksi Khusus Subclass
    private static void aksiKhusus() {
        System.out.println("\n--- AKSI KHUSUS ROBOT DINOSAURUS ---");
        Dinosaurus d = pilihDino();
        if (d != null) {
            if (d instanceof Karnivora) {
                ((Karnivora) d).berburu();
            } else if (d instanceof Herbivora) {
                ((Herbivora) d).menggembala();
            } else if (d instanceof Omnivora) {
                ((Omnivora) d).berkamuflase();
            }
        }
    }

    // 6. Hapus Dinosaurus
    private static void hapusDino() {
        System.out.println("\n--- HAPUS ROBOT DINOSAURUS ---");
        Dinosaurus d = pilihDino();
        if (d != null) {
            daftarDino.remove(d);
            System.out.println("Robot Dinosaururs" + d.getNama() + " berhasil dihapus dari sistem.");
        }
    }
        
}
