/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectTesting;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.swing.*;
/**
 *
 * @author user
 */
public class App {
    private static final Logger logger = LogManager.getLogger(ScrapingClass.class.getName());
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatCarbonIJTheme.registerCustomDefaultsSource("style");
        try {
            UIManager.setLookAndFeel( new FlatCarbonIJTheme() );
        } catch( Exception ex ) {
            logger.fatal("Nie udało sie załadować wyglądu FlatCarbonIJTheme");
        }
        new MainUI().setVisible(true);
    }
    
}
