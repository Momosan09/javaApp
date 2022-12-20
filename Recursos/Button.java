package Recursos;
import javax.swing.JButton;
import java.awt.event.ActionListener;//para los eventos
import java.awt.event.ActionEvent;//para los eventos

public class Button extends JButton{

  public Button(String text, int posX, int posY, int width, int height){
    this.setText(text);
    this.setBounds(posX,posY,width,height);

    /*ver como hacer para que los eventos se puedan diferenciar, tipo que pueda hacer distintos metodos*/

    ActionListener click = new ActionListener(){
    @Override
      public void actionPerformed(ActionEvent ae){
      System.out.println("Click");
      }
    };
    this.addActionListener(click);
  }
}
