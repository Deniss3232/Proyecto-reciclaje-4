class Residuos {
    private String tipo;
    private int cantidad;

    public Residuos(String tipo, int cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public void mostrarDetalles() {
        System.out.println("Tipo de residuo: " + tipo + ", Cantidad: " + cantidad);
    }
}