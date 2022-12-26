package Recursos;
import Recursos.Window;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.time.LocalDate;  // import the LocalDate class


public class Area extends JTextArea{

    Window imprimirArea = new Window();
    JPanel panel = new JPanel();
    LocalDate date = LocalDate.now();  // Create a date object


    public Area(){
        imprimirArea.setVisible(true);
        imprimirArea.setAlwaysOnTop (true);
        imprimirArea.ponerPanel(panel);

        this.setEditable(false);
        this.setBounds(0,0,500,500);
        this.setVisible(true);
        
        panel.add(this);
    }

    public void fill(JComponent c){
        this.add(c);

    }
}
