import javax.swing.JPanel;

import Recursos.Button;
import Actividad1.*;

public class Main{
  
  public static void main(String [] args){
    JPanel jp = new JPanel();
    Window window = new Window();
    Actividad_1 act1 = new Actividad_1();
    //Button btn1 = new Button("Hola Lemon", 20, 10, 150, 30);

    window.setVisible(true);
    act1.setVisible(true);
    //window.panel.add(btn1);
    jp.add(act1);
    jp.add(window);

  }
}
