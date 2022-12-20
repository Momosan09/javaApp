package Recursos;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.KeyEvent;//eventos de teclado
import java.awt.event.KeyListener;//eventos de teclado


public class TextField extends JTextField implements KeyListener{
  
  public TextField(int posX, int posY, int width, int height, JPanel jp){
    setBounds(posX,posY,width,height);
    jp.add(this);//se auto agrega al panel pasado como parametro

    eventosTeclado();
  }
  
  private void eventosTeclado(){
    

    
    this.addKeyListener(this);
    
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub
    System.out.println("Helo");
    
  }

  @Override
  public void keyPressed(KeyEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub
    
  }
}
