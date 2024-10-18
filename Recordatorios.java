class Recordatorios {
    private java.util.List<String> recordatorios = new java.util.ArrayList<>();

    public void crearRecordatorio(String nuevoRecordatorio) {
        recordatorios.add(nuevoRecordatorio);
        System.out.println("Recordatorio creado: " + nuevoRecordatorio);
    }

    public void mostrarRecordatorios() {
        System.out.println("Lista de Recordatorios:");
        for (String recordatorio : recordatorios) {
            System.out.println("- " + recordatorio);
        }
    }
}
