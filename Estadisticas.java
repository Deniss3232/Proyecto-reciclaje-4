class Estadisticas {
    // HashMap funciona para almacenar y manejar datos
    // Map es una interfaz que define un tipo de colección que asocia claves a valores
    private java.util.Map<String, Integer> estadisticas = new java.util.HashMap<>();

    public void agregarEstadistica(String tipoResiduos, int cantidad) {
        estadisticas.put(tipoResiduos, estadisticas.getOrDefault(tipoResiduos, 0) + cantidad);
        System.out.println("Estadística agregada: " + tipoResiduos + " - " + cantidad);
    }

    public void mostrarEstadisticas() {
        System.out.println("Estadísticas de reciclaje:");
        for (java.util.Map.Entry<String, Integer> estadistica : estadisticas.entrySet()) {
            System.out.println("- " + estadistica.getKey() + ": " + estadistica.getValue());
        }
    }
}