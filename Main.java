/*
 * Creado por: Denis Roberto Rodríguez Jiménez y Holly del Carmen Coti Santos
 * Fecha de creación: 03/10/2024
 * Última modificación: 18/10/2024
 * Descripción:
 * Este programa ha sido desarrollado con el fin de ayudar a las personas a que reciclen de una mejor manera.
 * El programa permite llevar un conteo de puntos,
 * en base a los residuos que hayan reciclado
 * El programa permite realizar recordatorios 
 * el programa da consejos
 * Créditos:
 * Este programa ha sido inspirado y desarrollado a partir de conocimientos
obtenidos en diversas fuentes
 * de programación en Java, incluyendo documentación oficial de Java.
 * Se han consultado las siguientes fuentes:
 * - Documentación oficial de Oracle sobre Java:
https://docs.oracle.com/javase/tutorial/
 * - Ejemplos y guías de: https://www.udb.edu.sv/udb_files/recursos_guias/informatica-ingenieria/java-avanzado/2019/i/guia-5.pdf
 * https://www.peixe.org.mx/sos/tutVent/
 * 
 */

// todos funcionan para interfaz gráfica
import javax.swing.*; //  este te da botones cuadros etiquetas etc.
import java.awt.*; //Contiene clases para manejar ventanas, gráficos, eventos, fuentes y colores
import java.awt.event.ActionEvent; //se utiliza para representar eventos de acción, como hacer clic en un botón o seleccionar un elemento de un menú. 
import java.awt.event.ActionListener;// se utiliza para impor una interfaz que se utiliza para manejar eventos de acción.

// Class main para la interfaz gráfica.
// JFrame Permite crear ventanas con botones, menús, barras de herramientas y otros componentes interactivos.
public class Main extends JFrame {
    private Estadisticas estadisticas = new Estadisticas();
    private Recordatorios recordatorios = new Recordatorios();
    private Juego juego = new Juego();
    private Instrucciones instrucciones = new Instrucciones();
    private Consejos consejos = new Consejos();

    public Main() {
        setTitle("Recicla más");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear los botones
        JButton btnInstrucciones = new JButton("Instrucciones del juego ");
        JButton btnConsejo = new JButton("Consejos");
        JButton btnRecordatorio = new JButton("Recordatorio");
        JButton btnJuego = new JButton("Juego");
        JButton btnResiduos = new JButton("Conteo de tú reciclaje");

        // Panel principal para agrupar los botones
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1)); 
        panel.add(btnInstrucciones);
        panel.add(btnConsejo);
        panel.add(btnResiduos);
        panel.add(btnJuego);
        panel.add(btnRecordatorio);

        // Agregar el panel al JFrame
        add(panel);

        //  botón Consejo el actionlistener funciona para la ejecución de acciones especificas.
        // mientras que actionperformed permite la ejecución de las acciones.
        btnConsejo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarConsejos();
            }
        });

        // botón Recordatorio
        btnRecordatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestionarRecordatorios();
            }
        });

        // botón Juego
        btnJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJuego();
            }
        });

        //  botón Instrucciones
        btnInstrucciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInstrucciones();
            }
        });

        //  botón Residuos
        btnResiduos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestionarResiduos();
            }
        });
    }

    // Métodos para manejar las acciones
    private void mostrarConsejos() {
        consejos.mostrarConsejos();
    }
    // JOptionPane muestra la variedad de cuadros de dialogo
    //isEmpty sirve para ver si hay textos vacios
    private void gestionarRecordatorios() {
        String nuevoRecordatorio = JOptionPane.showInputDialog(this, "Ingrese un nuevo recordatorio:");
        if (nuevoRecordatorio != null && !nuevoRecordatorio.isEmpty()) {
            recordatorios.crearRecordatorio(nuevoRecordatorio);
        }
        recordatorios.mostrarRecordatorios();
    }

    private void iniciarJuego() {
        String puntos = JOptionPane.showInputDialog(this, "Ingrese los puntos ganados:");
        if (puntos != null) {
            int puntosGanados = Integer.parseInt(puntos);
            juego.completarTarea(puntosGanados);
        }
        juego.mostrarPuntos();
    }

    private void mostrarInstrucciones() {
        instrucciones.mostrarInstrucciones();
    }

    private void gestionarResiduos() {
        String tipo = JOptionPane.showInputDialog(this, "Ingrese el tipo de residuo:");
        String cantidadd = JOptionPane.showInputDialog(this, "Ingrese la cantidad de residuos:");
        if (tipo != null && cantidadd != null) {
            int cantidad = Integer.parseInt(cantidadd);
            Residuos residuos = new Residuos(tipo, cantidad);
            residuos.mostrarDetalles();
            estadisticas.agregarEstadistica(tipo, cantidad);
        }
        estadisticas.mostrarEstadisticas();
    }

    // Método principal para ejecutar la interfaz 
    //  SwingUtilities.invokeLater sirve para ejecutar tareas de manera asíncronica
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main frame = new Main();
                frame.setVisible(true);
            }
        });
    }
}