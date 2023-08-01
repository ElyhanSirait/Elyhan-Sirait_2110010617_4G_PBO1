package uaspbo1;

// Exception untuk menangani saldo tidak mencukupi
class kurang extends Exception {
    public kurang (String message) {
        super(message);
    }
}
