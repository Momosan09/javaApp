package Actividades;
import javax.swing.JPanel;

import Recursos.Button;


public class Actividad_1 extends SuperActividades{
    JPanel jp1 = new JPanel();
    Button btn1 = new Button("helosss", 0, 0, 100, 20);

    public Actividad_1(){
        this.setTitle("Presupuesto 1");
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ponerComponente(btn1);


        ponerPanel(jp1);

    }




}
