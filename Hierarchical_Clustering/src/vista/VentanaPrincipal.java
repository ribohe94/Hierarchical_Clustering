/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import IO.Read;
import control.Control;
import control.GestorAlgoritmo;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.Individuo;

/**
 *
 * @author Riccardo
 */
public class VentanaPrincipal extends JFrame implements Observer {

    public VentanaPrincipal(Control nuevoGestor) throws HeadlessException {
        gestorPrincipal = nuevoGestor;
        ajustarCongigInic();
        ajustarComponentes(getContentPane());
    }

    public void ajustarCongigInic() {
        setTitle("FSM");
        setSize(1000, 700);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void ajustarComponentes(Container c) {
        c.setLayout(new GridBagLayout());
        //Inicializamos panel
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());

        //inicializamos TxtFields/Area
        txtFile = new JTextField(40);
        txtFile.setEditable(false);

        //inicializamos Labels
        lbFile = new JLabel("Nombre de archivo: ");
        lbEstadoFinal = new JLabel("Estado: ");
        lbResultado = new JLabel("Esperando...");

        //incializamos botones
        btnBuscar = new JButton("Buscar");

        /**
         * ** Agregamos elementos al panel. ***
         */
        gbc.insets = new Insets(7, 7, 7, 7);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelPrincipal.add(lbFile, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelPrincipal.add(txtFile, gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        panelPrincipal.add(btnBuscar, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelPrincipal.add(lbEstadoFinal, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        panelPrincipal.add(lbResultado, gbc);

        c.add(panelPrincipal);

        /**
         * ** Action Listeners ***
         */
        btnBuscar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    JFileChooser chooser = new JFileChooser();
                    chooser.showOpenDialog(null);
                    File file = chooser.getSelectedFile();
                    String filename = file.getAbsolutePath();
                    gestorPrincipal.actualizar(filename);
                    txtFile.setText(filename);

                    Pattern p = Pattern.compile("\\d+\\.?\\d*|[a-zA-Z0-9]");
                    Matcher m = p.matcher(Read.readFile(filename, StandardCharsets.UTF_8));
                    int i = 0;
                    int count = 0;
                    LinkedList<Individuo> individuos = new LinkedList<>();
                    individuos.add(new Individuo());
                    while (m.find()) {
                        if (m.group().equals("P")) {
                            if (i > 0) {
                                individuos.add(new Individuo());
                                count++;
                            }
                        } else {
                            individuos.get(count).getListaValores().add(Double.valueOf(m.group()));
                        }

                        i++;

                    }
                    PrintWriter out = new PrintWriter("Output.txt");
                    out.print("");
                    GestorAlgoritmo ga = new GestorAlgoritmo();
                    double[][] matriz = ga.generarMatrizInicial(individuos);
                    ga.generarMatriz(matriz);
                    
                    
                    

                } catch (IOException ex) {
                    Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

    }

    public void init() {
        gestorPrincipal.registrar(this);
        setVisible(true);
        pack();
    }

    @Override
    public void update(Observable o, Object arg) {
        lbResultado.setText((String) arg);
    }

    //Atributos
    private Control gestorPrincipal;
    GridBagConstraints gbc = new GridBagConstraints();
    //JPanels
    private JPanel panelPrincipal;
    //Labels
    private JLabel lbFile;
    private JLabel lbEstadoFinal;
    private JLabel lbResultado;
    //Txt Fields
    private JTextField txtFile;
    //Buttons
    private JButton btnBuscar;

}
