package Recursos;

import javax.swing.JPanel;
import javax.swing.JRadioButton;


import java.awt.event.ActionListener;//para los eventos
import java.awt.event.ActionEvent;//para los eventos

public class Radio extends JRadioButton {

  public float multModelo;

  public Radio(String text, int posX, int posY, int width, int height, JPanel jp, float pMultModelo) {
    setBounds(posX, posY, width, height);
    setVisible(true);
    setText(text);
    setActionCommand(text);
    setMultModelo(pMultModelo);

    jp.add(this);

  }

  public void setMultModelo(float n){
    multModelo = n;
    
  }
  public float getMultModelo(){
    return multModelo;
  }
}