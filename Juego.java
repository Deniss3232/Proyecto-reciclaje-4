class Juego {
    private int puntos = 0;

    public void completarTarea(int puntosGanados) {
        this.puntos += puntosGanados;
        System.out.println("Has ganado " + puntosGanados + " puntos.");
    }

    public void mostrarPuntos() {
        System.out.println("Puntos totales: " + puntos);
    }
}