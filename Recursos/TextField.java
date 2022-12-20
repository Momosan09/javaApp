package Recursos;
import javax.swing.JTextField;
public class TextField{

  public TextField(int posX, int posY, int width, int height){
    JTextField cajaTexto = new JTextField();
    cajaTexto.setBounds(posX,posY,width,height);
  }
}
