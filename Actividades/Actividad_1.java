package Actividades;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Recursos.Button;
import Recursos.Label;
import Recursos.TextField;


public class Actividad_1 extends SuperActividades{
    JPanel jp1 = new JPanel();
    Button btn1 = new Button("Boton 1", 200, 0, 100, 20);
    TextField txtField = new TextField(0, 0, 200, 20);

    JLabel lbl1 = new Label("hola", "a", 0,0,100,200);


    public Actividad_1(){
        this.setTitle("Presupuesto 1");
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        jp1.add(btn1);

        ponerPanel(jp1);

    }

    private void ui(){
    ponerEtiqueta();
    }
    private void ponerEtiqueta(){
        jp1.add(lbl1);

    }
    



}
