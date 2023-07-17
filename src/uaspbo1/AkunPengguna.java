package uaspbo1;

// Kelas turunan untuk akun pengguna
public class AkunPengguna extends Akun {
    private int pin;
    private double btswd;

    // Constructor untuk inisialisasi atribut
    public AkunPengguna(String nm, int nmrAkun, double saldo, int pin, double btswd) {
        super(nm, nmrAkun, saldo);
        this.pin = pin;
        this.btswd = btswd;
    }

    // Override method withdraw untuk membatasi penarikan harian
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

    // Method untuk memeriksa PIN
    public boolean cekPin(int inputPin) {
        return pin == inputPin;
    }
}

// Exception untuk menangani saldo tidak mencukupi
class kurang extends Exception {
    public kurang (String message) {
        super(message);
    }
}

