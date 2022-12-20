package Recursos;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

public class Label extends JLabel{
    
    public Label(String Texto, String ToolTip, int posX, int posY, int widht, int height, JPanel jp){
        //etiqueta.setOpaque(true);//Vuelve transparente a la etiqueta (Sirve para pintar el Background)
        setText(Texto);
        setToolTipText(ToolTip);
        setFont(new Font("LINUX", Font.PLAIN, 20));
        setBounds(posX,posY,widht,height);
        setVisible(true);
        //etiqueta.setLabelFor(c);

        jp.add(this);//se auto agrega al panel pasado como parametro

      }


}
