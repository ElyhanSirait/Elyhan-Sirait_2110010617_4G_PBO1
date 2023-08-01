package uaspbo1;

import java.util.Scanner;

// Kelas dasar untuk akun bank
class Akun {
    private String nm; //nama
    private int nmrAkun; //nomor akun
    protected double saldo;

    // Constructor untuk inisialisasi atribut
    public Akun(String nm, int nmrAkun, double saldo) {
        this.nm = nm;
        this.nmrAkun = nmrAkun;
        this.saldo = saldo;
    }

    // Mutator untuk mendapatkan nama
    public String getnm() {
        return nm;
    }

    // Accessor untuk mengubah nama
    public void setnm(String newName) {
        nm = newName; //nama baru
    }

    // Mutator untuk mendapatkan nomor akun
    public int getnmrAkun() {
        return nmrAkun;
    }

    // Mutator untuk mendapatkan saldo
    public double getsaldo() {
        return saldo;
    }

    // Method untuk menyetor uang
    public void deposit(double jml) {
        saldo += jml; // jumlah 
    }

    // Method untuk menarik uang
    public void wd(double jml) throws kurang {
        if (jml <= saldo) {
            saldo -= jml; //withdraw
        } else {
            throw new kurang("Saldo tidak mencukupi!");
        }
    }
}

