# Sistem Manajemen Robot Taman Dinosaurus

Aplikasi Java berbasis console yang mensimulasikan sistem manajemen robot dinosaurus di sebuah taman hiburan, dibuat sebagai tugas individu mata kuliah **Pemrograman Berorientasi Objek (PBO)**.

## Identitas Mahasiswa
**Nama**       : Brendhen Canafaro Lie

**NIM**        : 2509116033

**Mata Kuliah** : Pemrograman Berorientasi Objek (PBO)


## Studi Kasus

Studi kasus yang dipilih adalah **sistem manajemen robot dinosaurus di sebuah taman hiburan**. Setiap robot dinosaurus disimulasikan memiliki perilaku makan dan bersuara yang berbeda-beda tergantung jenis pakannya. Program ini memungkinkan pengelola taman untuk melakukan berbagai hal, yaitu sebagai berikut ini:

- Mendaftarkan robot dinosaurus baru ke sistem, dikategorikan sebagai **Karnivora**, **Herbivora**, atau **Omnivora** (Create/Membuat)
- Melihat seluruh daftar robot dinosaurus beserta detail informasinya (Read/Melihat)
- Mensimulasikan pemberian makan dan uji suara pada tiap robot
- Menjalankan aksi khusus yang hanya dimiliki jenis dinosaurus tertentu (berburu, menggembala, berkamuflase)
- Menghapus robot dinosaurus dari sistem (Delete/Menghapus)

Studi kasus ini dipilih karena secara natural memetakan konsep **inheritance**, seluruh jenis dinosaurus berbagi atribut dan perilaku dasar yang sama (id, nama, era hidup, makan, bersuara), namun setiap jenis punya cara makan, suara, dan aksi khusus yang berbeda, sehingga cocok diimplementasikan lewat class induk dan subclass yang saling meng-override (mengubah) method.

## Hierarki Class / Diagram Kelas Sederhana

```
                 ┌─────────────────────┐
                 │     Dinosaurus       │   (superclass)
                 ├─────────────────────┤
                 │ - id                │
                 │ - nama              │
                 │ - spesies           │
                 │ - eraHidup          │
                 ├─────────────────────┤
                 │ + makan()           │
                 │ + bersuara()        │
                 │ + tampilkanInfo()   │
                 └──────────┬──────────┘
                            │ extends
         ┌──────────────────┼──────────────────┐
         │                  │                  │
┌────────▼────────┐ ┌───────▼────────┐ ┌───────▼────────┐
│    Karnivora     │ │   Herbivora    │ │    Omnivora     │
├──────────────────┤ ├────────────────┤ ├─────────────────┤
│ - jenisDaging     │ │ - jenisTanaman │ │ - makananCampuran│
│   Favorit         │ │   Favorit      │ │                 │
├──────────────────┤ ├────────────────┤ ├─────────────────┤
│ + makan()  (ovr)   │ │ + makan() (ovr)│ │ + makan() (ovr) │
│ + bersuara() (ovr)  │ │ + bersuara()(ovr)│ │ + bersuara()(ovr)│
│ + tampilkanInfo()(ovr)│ │+ tampilkanInfo()(ovr)│ │+ tampilkanInfo()(ovr)│
│ + berburu()        │ │ + menggembala() │ │ + berkamuflase()│
└──────────────────┘ └────────────────┘ └─────────────────┘
```

`Karnivora`, `Herbivora`, dan `Omnivora` merupakan subclass dari `Dinosaurus`. Ketiganya mewarisi atribut `id`, `nama`, `spesies`, dan `eraHidup`, lalu menambahkan atribut khusus masing-masing serta meng-override method `makan()`, `bersuara()`, dan `tampilkanInfo()`.

## Penerapan Inheritance dalam Kode

### 1. Pewarisan class (`extends`)

Ketiga subclass mewarisi `Dinosaurus` menggunakan keyword `extends`:

```java
public class Karnivora extends Dinosaurus { ... }
public class Herbivora extends Dinosaurus { ... }
public class Omnivora  extends Dinosaurus { ... }
```

### 2. Pemanggilan constructor superclass (`super`)

Setiap subclass memanggil constructor `Dinosaurus` lewat `super(...)` untuk menginisialisasi atribut yang diwarisi, sebelum menambahkan atribut khususnya sendiri:

```java
public Karnivora(String id, String nama, String spesies, String eraHidup, String jenisDagingFavorit) {
    super(id, nama, spesies, eraHidup);      // panggil constructor superclass
    this.jenisDagingFavorit = jenisDagingFavorit;
}
```

### 3. Method overriding (`@Override`)

Method `makan()`, `bersuara()`, dan `tampilkanInfo()` dari `Dinosaurus` di-override pada tiap subclass agar perilakunya berbeda sesuai jenisnya. Contoh pada `Herbivora`:

```java
@Override
public void makan() {
    System.out.println("Robot Dinosaurus" + getNama() + " si Herbivora mengunyah "
        + jenisTanamanFavorit + " (simulasi flora " + getEraHidup() + ").");
}
```

### 4. Pemanggilan method superclass (`super.method()`)

Pada `tampilkanInfo()`, subclass tetap memanggil versi superclass-nya terlebih dahulu lewat `super.tampilkanInfo()`, baru menambahkan info tambahan khusus subclass tersebut:

```java
@Override
public void tampilkanInfo() {
    super.tampilkanInfo();
    System.out.println("Kategori         : Dinosaurus Herbivora");
    System.out.println("Tanaman Simulasi : " + jenisTanamanFavorit);
}
```

### 5. Polymorphism lewat referensi superclass

Di `Main.java`, seluruh objek disimpan dalam satu `ArrayList<Dinosaurus>`, walaupun objek aslinya adalah `Karnivora`, `Herbivora`, atau `Omnivora`. Saat method `makan()` atau `bersuara()` dipanggil, Java otomatis menjalankan versi override milik objek aslinya (dynamic method dispatch):

```java
private static ArrayList<Dinosaurus> daftarDino = new ArrayList<>();
...
Dinosaurus d = pilihDino();
d.makan();   // menjalankan makan() versi Karnivora/Herbivora/Omnivora, tergantung objeknya
```


## Struktur Project

<img width="378" height="282" alt="image" src="https://github.com/user-attachments/assets/d04162be-cbe4-416a-a52b-80cf16bc4066" />


## Cara Menjalankan

1. Clone repository ini
   ```bash
   git clone <url-repo-kamu>
   ```
2. Buka project menggunakan Apache NetBeans (atau IDE Java lain yang mendukung Maven)
3. Pastikan **Main Class** project mengarah ke `com.mycompany.tugasindividu_pbo.Main`
   (Project Properties → Run → Main Class)
4. Jalankan project (Run / F6)
5. Ikuti menu interaktif yang muncul di console

## Tangkapan Layar Program Berjalan

### Menu Utama

<img width="334" height="219" alt="image" src="https://github.com/user-attachments/assets/fce3f8cc-b2e4-47f9-9b43-a7f54c6e17ce" />


### Tambah Robot Dinosaurus

<img width="560" height="227" alt="image" src="https://github.com/user-attachments/assets/792aebeb-3883-473e-9f75-3010180c8b10" />


### Tampilkan Daftar Robot Dinosaurus

<img width="326" height="452" alt="image" src="https://github.com/user-attachments/assets/74ee4cc5-2566-4790-876e-309dee6f0aa0" />


### Simulasi Beri Makan & Uji Suara

<img width="816" height="78" alt="image" src="https://github.com/user-attachments/assets/9080293c-05a2-4697-b0ae-0fead325da30" />


<img width="668" height="70" alt="image" src="https://github.com/user-attachments/assets/ccbee7ee-78e9-4225-bfa7-e4918ebd4a70" />

### Menghapus Robot Dinosaurus Dari Daftar

<img width="485" height="80" alt="image" src="https://github.com/user-attachments/assets/92f587fe-93c5-47c0-bee4-69a761dc03e7" />


### Aksi Khusus per Jenis
## Karnivora

<img width="723" height="57" alt="image" src="https://github.com/user-attachments/assets/36c9c922-b09c-46d9-a4c2-0612269f4715" />


## Herbivora

<img width="615" height="52" alt="image" src="https://github.com/user-attachments/assets/b527e883-92fb-4997-83ab-333179fdd596" />


## Omnivora

<img width="575" height="55" alt="image" src="https://github.com/user-attachments/assets/93574365-c93d-48f3-8df9-7993d7aa89d2" />

