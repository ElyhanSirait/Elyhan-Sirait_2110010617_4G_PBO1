package uaspbo1;

import java.util.Scanner;


 // Kelas utama ATM
public class AkunBeraksi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi akun-akun
        AkunPengguna user1 = new AkunPengguna("Elyhan", 987654, 1000000.0, 1234, 500000.0);
        AkunPengguna user2 = new AkunPengguna("Sirait", 654321, 2000000.0, 4321, 1000000.0);

        // Array untuk menyimpan daftar akun
        AkunPengguna[] users = {user1, user2};

        // Meminta input nama pengguna
        System.out.print("Masukkan nama Anda: ");
        String username = scanner.nextLine();

        // Meminta input PIN
        System.out.print("Masukkan PIN Anda: ");
        int pin = scanner.nextInt();

        // Mencari akun berdasarkan nama dan PIN
        AkunPengguna userAccount = null;
        for (AkunPengguna account : users) {
            if (account.getnm().equalsIgnoreCase(username) && account.cekPin(pin)) {
                userAccount = account;
                break;
            }
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
    }
}