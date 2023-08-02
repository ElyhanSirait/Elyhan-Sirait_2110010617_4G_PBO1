# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh sederhana aplikasi pengolahan data ATM menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini menerima input berupa nama Akun, dan memberikan output berupa informasi detail dari akun tersebut seperti jumlah saldo

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance,Overriding, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `Akun`, `AkunPengguna`, dan `AkunBeraksi` adalah contoh dari class.

```bash
public class Akun{
    ...
}

public class AkunPengguna extends Akun{
    ...
}

public class AkunBeraksi {
    ...
}
```

2. **Object** adalah instance dari class. Pada kode ini, Akun[i] = new Akun(nama, nmrAkun, saldo,pin,batas penarikan);` adalah contoh pembuatan object.

```bash
Akun[i] = new AkunPengguna(nama, nmrAkun, saldo);
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `nama` dan `nmrAkun` adalah contoh atribut.

```bash
String nm;
String nmrAkun;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `Akun` dan `AkunDetail`.

```bash
public Akun(String nm, int nmrAkun, double saldo){
    this.nm = nm;
    this.nmrAkun = nmrAkun;
    this.saldo = saldo;
}

public AkunDetail(String nm, int nmrAkun, double saldo, double bunga){
    super(nm, nmrAkun, saldo);
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setNama` dan `setNpm` adalah contoh method mutator.

```bash
public void setNm(String newName{
    this.nm = newName
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getNama`, `getNpm`, `getTahunMasuk`, `getFakultas`, `getProdi`, dan `getNoRegistrasi` adalah contoh method accessor.

```bash
public String getnm() {
    return nama;
}

public String getsaldo() {
    return saldo;
}
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, atribut `nm` dan `saldo` dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```bash
private String nm;
protected double saldo;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `AkunPengguna` mewarisi `Akun` dengan sintaks `extends`.

```bash
public class AkunPengguna extends Akun  {
    ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Ini memungkinkan metode-metode dengan nama yang sama untuk berperilaku berbeda tergantung pada tipe objek yang mereka manipulasi, polymorphism bisa berbentuk Overloading ataupun Overriding. Pada kode ini, `wd` di `AkunPengguna` merupakan override dari method `wd` di `Akun`.

```bash
    public void wd(double jml) throws kurang {
        if (jml <= saldo) {
            saldo -= jml;
        } else {
            throw new kurang("Saldo tidak mencukupi!");
        }
    }

@Override
    public void wd(double jml) throws kurang {
        if (jml <= saldo && jml <= btswd) {
            saldo -= jml;
            btswd -= jml;
        } else if (jml > btswd) {
            throw new kurang("Batas penarikan harian telah tercapai!");
        } else {
            throw new kurang("Saldo tidak mencukupi!");
        }
    }

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `switch ` dalam method `cekPin` dan seleksi `if else` dalam method `cekPin`.

```bash
    public boolean cekPin(int inputPin) {
        return pin == inputPin;
    }
        // Jika akun ditemukan, tampilkan menu ATM
        if (userAccount != null) {
            while (true) {

                System.out.println("========== Menu ATM ==========");
                System.out.println("1. Cek Saldo");
                System.out.println("2. Setor Uang");
                System.out.println("3. Tarik Uang");
                System.out.println("4. Ganti Nama");
                System.out.println("5. Keluar");
                System.out.print("Pilih menu (1-5): ");
                int pilih = scanner.nextInt();

                switch (pilih) {
                    case 1:
                        System.out.println("Nama Pengguna : " + userAccount.getnm());
                        System.out.println("Saldo Anda: Rp. " + userAccount.getsaldo());
                        break;
                    case 2:
                        System.out.print("Masukkan jumlah yang akan disetor: ");
                        double depositAmount = scanner.nextDouble();
                        userAccount.deposit(depositAmount);
                        System.out.println("Setoran berhasil!");
                        System.out.println("Saldo Anda: Rp. " + userAccount.getsaldo());
                        
                        break;
                    case 3:
                        System.out.print("Masukkan jumlah yang akan ditarik: ");
                        double jmlwd = scanner.nextDouble();
                        try {
                            userAccount.wd(jmlwd);
                            System.out.println("Penarikan berhasil!");
                            System.out.println("Saldo Anda: Rp. " + userAccount.getsaldo());                            
                        } catch (kurang e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 4:
                        scanner.nextLine(); // Membersihkan \n setelah nextInt
                        System.out.print("Masukkan nama baru: ");
                        String newName = scanner.nextLine();
                        userAccount.setnm(newName);
                       System.out.println("Nama berhasil diubah!");
                        break;
                    case 5:
                        System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih menu (1-5).");
                        break;
                }
            }
        } else {
            System.out.println("Akun tidak ditemukan atau PIN salah!");
        }
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop `for` untuk meminta input dan menampilkan data.

```bash
        AkunPengguna userAccount = null;
        for (AkunPengguna account : users) {
            if (account.getnm().equalsIgnoreCase(username) && account.cekPin(pin)) {
                userAccount = account;
                break;
            }
        }
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` untuk menampilkan output.

```bash
        Scanner scanner = new Scanner(System.in);


        System.out.print("Masukkan nama Anda: ");
        String username = scanner.nextLine();


        System.out.print("Masukkan PIN Anda: ");
        int pin = scanner.nextInt();
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, `AkunPengguna[] users = {user1, user2};` adalah contoh penggunaan array.

```bash
        AkunPengguna user1 = new AkunPengguna("Elyhan", 987654, 1000000.0, 1234, 500000.0);
        AkunPengguna user2 = new AkunPengguna("Sirait", 654321, 2000000.0, 4321, 1000000.0);
        AkunPengguna[] users = {user1, user2};
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try catch` untuk menangani error.

```bash
                        try {
                            userAccount.wd(jmlwd);
                            System.out.println("Penarikan berhasil!");
                            System.out.println("Saldo Anda: Rp. " + userAccount.getsaldo());                            
                        } catch (kurang e) {
                            System.out.println("Error: " + e.getMessage());
                        }
```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Elyhan Sirait
NPM: 2110010617
