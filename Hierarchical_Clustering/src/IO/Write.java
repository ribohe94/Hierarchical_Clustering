/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Riccardo
 */
public class Write {
    public static void write(String texto, String file) {
        
        try {
            PrintWriter out = new PrintWriter(file);
            out.append(texto);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Write.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
