package uaspbo1;

import java.util.Scanner;

// Class utama ATM
class ATM {
    private String bankName;
    private String nama ;
    private int saldo;

    // Constructor
    public ATM(String bankName, String nama, int saldo) {
        this.bankName = bankName;
        this.nama = nama;
        this.saldo = saldo;
        
    }

    // Accessor untuk mendapatkan nama bank
    public String getBankName() {
        return bankName;
    }

    // Mutator untuk mengubah nama bank
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    
    // Accessor untuk mendapatkan nama pemilik
    public String getNama() {
        return nama;
    }
    
    // Mutator untuk mengubah nama pemilik
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    

    // Method untuk menampilkan menu ATM
    public void showMenu() {
        System.out.println("=== " + bankName + " ATM ===");
        System.out.println("1. Cek Saldo");
        System.out.println("2. Tarik Tunai");
        System.out.println("3. Setor Tunai");
        System.out.println("0. Keluar");
        System.out.println("===================");
    }

    // Method untuk mengambil saldo
    public int getsaldo() {
        return saldo;
    }

    // Method untuk melakukan penarikan tunai
    public void tarik(int jumlah) throws kurang {
        if (jumlah > saldo) {
            throw new kurang("Saldo tidak mencukupi!");
        }
        saldo -= jumlah;
        System.out.println("Penarikan tunai berhasil. Sisa saldo: " + saldo);
    }

    // Method untuk melakukan penyetoran tunai
    public void deposit(int jumlah) {
        saldo += jumlah;
        System.out.println("Setoran tunai berhasil. Saldo sekarang: " + saldo);
    }
}

