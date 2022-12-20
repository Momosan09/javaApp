package Actividades;
import javax.swing.JComponent;

import Recursos.*;

//import javax.swing.JPanel;
//import Recursos.Button;


public abstract class SuperActividades extends Window{
    //Window superWindow = new Window();
    //JPanel superPanel = new JPanel();

    public SuperActividades(){
        this.setTitle("Super");
        //superWindow.ponerPanel(panel);
        //superWindow.setVisible(true);

    }

    public void iniciar(){

    }
    public void ponerComponente(JComponent component){
        this.add(component);
    }

}
