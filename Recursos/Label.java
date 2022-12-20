package Recursos;

import javax.swing.JLabel;
import java.awt.Font;

public class Label extends JLabel{
    JLabel etiqueta = new JLabel();
    
    public Label(String Texto, String ToolTip, int posX, int posY, int widht, int height){
        //etiqueta.setOpaque(true);//Vuelve transparente a la etiqueta (Sirve para pintar el Background)
        setText(Texto);
        setToolTipText(ToolTip);
        setFont(new Font("LINUX", Font.PLAIN, 20));
        setBounds(posX,posY,widht,height);
        setVisible(true);
        //etiqueta.setLabelFor(c);

        //this.add(etiqueta);
      }


}
