package Recursos;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;//para los eventos
import java.awt.event.ActionEvent;//para los eventos

public class Radio extends JRadioButton {
    public Radio(String text, int posX, int posY, int width, int height,JPanel jp){
        setBounds(posX,posY,width,height);
        setVisible(true);
        setText(text);

        jp.add(this);

        ActionListener click = new ActionListener(){
            @Override
              public void actionPerformed(ActionEvent ae){
              System.out.println("Click");
              }
            };
            this.addActionListener(click);
    }
}
