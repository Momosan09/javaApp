package Recursos;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;//para los eventos
import java.awt.event.ActionListener;//para los eventos
import java.awt.event.KeyListener;

public class TextField{

  public TextField(int posX, int posY, int width, int height){
    JTextField cajaTexto = new JTextField();
    cajaTexto.setBounds(posX,posY,width,height);

    eventosTeclado();
  }
  public void eventosTeclado(){/* 
    KeyListener ae = new KeyListener();

    @Override
    public void keyTyped(KeyEvent ke){

    }
    @Override
    public void keyPressed(KeyEvent ke){

    }
    public void keyReleased(KeyEvent ke){
      
    }
    cajaTexto.addKeyListener(ae);
    */
  }
}
