/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import IO.Read;
import control.Control;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

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
        txtFile = new JTextField(10);
        txtHilera = new JTextField(10);
        txtaEstados = new JTextArea(1, 20);
        txtaEstados.setEditable(false);
        txtaTransiciones = new JTextArea(20, 20);
        txtaTransiciones.setEditable(false);

        //inicializamos Labels
        lbFile = new JLabel("Nombre de archivo: ");
        lbHilera = new JLabel("Hilera: ");
        lbEstados = new JLabel("Estados: ");
        lbTransiciones = new JLabel("Transiciones: ");
        lbEstadoFinal = new JLabel("Estado: ");
        lbResultado = new JLabel("Esperando...");

        //incializamos botones
        btnVerificar = new JButton("Verificar");

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
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelPrincipal.add(lbHilera, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelPrincipal.add(txtHilera, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        panelPrincipal.add(btnVerificar, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelPrincipal.add(lbEstados, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelPrincipal.add(txtaEstados, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelPrincipal.add(lbTransiciones, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panelPrincipal.add(txtaTransiciones, gbc);
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
        btnVerificar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

    }

    public void init() {
        gestorPrincipal.registrar(this);
        setVisible(true);
        pack();
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Atributos
    private Control gestorPrincipal;
    GridBagConstraints gbc = new GridBagConstraints();
    //JPanels
    private JPanel panelPrincipal;
    //Labels
    private JLabel lbHilera;
    private JLabel lbFile;
    private JLabel lbEstados;
    private JLabel lbTransiciones;
    private JLabel lbEstadoFinal;
    private JLabel lbResultado;
    //Txt Fields
    private JTextField txtHilera;
    private JTextField txtFile;
    private JTextArea txtaEstados;
    private JTextArea txtaTransiciones;
    //Buttons
    private JButton btnVerificar;

}
