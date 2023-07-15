package uaspbo1;

// Class turunan dari ATM

import java.util.Scanner;

class BankATM extends ATM {
    private String cabang;

    // Constructor
    public BankATM(String bankName, String nama, int saldo, String cabang) {
        super(bankName,nama,saldo);
        this.cabang = cabang;
    }

    // Override method showMenu untuk menambahkan info cabang
    @Override
    public void showMenu() {
        super.showMenu();
        System.out.println("Cabang: " + cabang);
    }

    String nama() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

// Class utama
public class ATMberaksi {
    public static void main(String[] args) {
        // Membuat objek ATM
        try (Scanner scanner = new Scanner(System.in)) {
            // Membuat objek ATM
            BankATM atm = new BankATM("Bank Pribadi","Elyhan Sirait", 5000000, "Kalimantan Selatan");
            
            boolean exit = false;
            
            while (!exit) {
                atm.showMenu();
                System.out.print("Pilihan: ");
                int pilih = scanner.nextInt();
                
                switch (pilih) {
                    case 0:
                        exit = true;
                        System.out.println("Terima kasih telah menggunakan ATM " + atm.getBankName());
                        break;
                    case 1:
                        System.out.println("Nama Akun  :" + atm.getNama());
                        System.out.println("Saldo Anda : " + atm.getsaldo());
                        break;
                    case 2:
                        System.out.print("Masukkan jumlah yang ingin ditarik: ");
                        int jmltarik = scanner.nextInt();
                        try {
                            atm.tarik(jmltarik);
                        } catch (kurang e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.print("Masukkan jumlah yang ingin disetor: ");
                        int jmldepo = scanner.nextInt();
                        atm.deposit(jmldepo);
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }
                
                System.out.println();
            }
        }
    }
}
