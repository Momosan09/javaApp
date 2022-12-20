import javax.swing.JPanel;

import Actividades.*;

public class Main{
  
  public static void main(String [] args){
    JPanel jp = new JPanel();
    //Window window = new Window();

    SuperActividades sup = new SuperActividades() {
      Actividad_1 act = new Actividad_1();
    };

    //Button btn1 = new Button("Hola Lemon", 20, 10, 150, 30);

    //window.setVisible(true);
   


    //window.panel.add(btn1);
/*     jp.add(act1);
    jp.add(window); */

  }
}
