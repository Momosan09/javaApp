package Actividades;

import Recursos.*;

//import javax.swing.JPanel;
//import Recursos.Button;


public abstract class SuperActividades extends Window{
    Window superWindow = new Window();
    //JPanel superPanel = new JPanel();

    public int posX, posY, width, height;

    public SuperActividades(){
        this.setTitle("Super");

        //superWindow.ponerPanel(panel);
        //superWindow.setVisible(true);
    }

    public void iniciar(){
    }


}
