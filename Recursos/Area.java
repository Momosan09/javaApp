package Recursos;
import Recursos.Window;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/* import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.File; */

import java.time.LocalDate;  // import the LocalDate class

public class Area extends JTextArea{

    Window imprimirArea = new Window();
    JPanel panel = new JPanel();
    LocalDate date = LocalDate.now();  // Create a date object

    //labels 
    public JLabel centerText = new JLabel();
    public JLabel out1 = new JLabel();
    public JLabel out2 = new JLabel();
    public JLabel out3 = new JLabel();
    public JLabel out4 = new JLabel();
    public JLabel out5 = new JLabel();

    /*Escribo lo que poso:
     * Justo aca abajo del comentario que dice "labels" estaban las JLabels out1, out2, ..., etc (que ahora estan abajo dentro del metodo "gui").
     * La unica diferencia es que ahora las labels no tienen el atributo "public", a diferencia de como estaban declaradas fuera de cualquier metodo y ahora anda.
     * el problema que tenia o lo que no andaba era que no se ponian en la posicion que le seteaba con el metodo "gui" y al declararlas dentro de este metodo y no publicas ahora funciona como esperaba
     * no entiendo porque anda y espero mas adelante entederlo
     * ¿Por que razon si las declare en la clase pero no dentro de un metodo no me hacia caso y si las declaro dentro del metodo si?
     */
    

    //private static final String IMG_PATH = "../images/image01.png";


    public Area(){
        
        imprimirArea.setVisible(true);
        imprimirArea.setAlwaysOnTop(false);
        imprimirArea.ponerPanel(panel);
        
        
        //this.setEditable(false);
        this.setBounds(0,0,500,500);
        this.setVisible(true);
        gui();
        //panel.add(this);
    }

    public void fill(JComponent c){
        this.add(c);
    }

    public void gui(){
        JPanel header = new JPanel();
        JPanel body = new JPanel();
        int padding = 25;

        header.setBounds(0,0,this.getWidth(),this.getHeight()/4);
        header.setBackground(Color.decode("#c66d6d"));
        header.setLayout(null);
        panel.add(header);

        centerText.setText("Helo");
        centerText.setBounds(0, header.getHeight()-40, header.getWidth(), 30);
        centerText.setFont(new Font("LINUX", Font.PLAIN, 20));
        centerText.setHorizontalAlignment(SwingConstants.CENTER);
        centerText.setForeground(Color.decode("#e3e3e3"));
        header.add(centerText);

        body.setBounds(panel.getX(),125,this.getWidth(),this.getHeight()/2);
        body.setBackground(Color.decode("#cecece"));
        body.setLayout(null);
        panel.add(body);

        out1.setText("Out1 = n");
        out1.setBounds(5,padding,this.getWidth(),padding);
        out1.setFont(new Font("LINUX", Font.PLAIN, 16));
        body.add(out1);

        out2.setText("Out2 = n");
        out2.setBounds(5,padding*2,this.getWidth(),padding);
        out2.setFont(new Font("LINUX", Font.PLAIN, 16));
        body.add(out2);
        
        out3.setText("Out3 = n");
        out3.setBounds(5,padding*3,this.getWidth(),padding);
        out3.setFont(new Font("LINUX", Font.PLAIN, 16));
        body.add(out3);

        out4.setText("Out4 = n");
        out4.setBounds(5,padding*4,this.getWidth(),padding);
        out4.setFont(new Font("LINUX", Font.PLAIN, 16));
        body.add(out4);

        out5.setText("Out5 = n");
        out5.setBounds(5,padding*5,this.getWidth(),padding);
        out5.setFont(new Font("LINUX", Font.PLAIN, 16));
        body.add(out5);


        //cabezal
/*         panel.add(header);
        header.setBounds(0,0,this.getWidth(),this.getHeight()/4);
        header.setBackground(Color.decode("#c66d6d"));

        //texto dentro del cabezal
        centerText.setText("Lorem Ipsum dolor");
        centerText.setBounds(0, header.getHeight()-40, header.getWidth(), 30);
        centerText.setHorizontalAlignment(SwingConstants.CENTER);
        centerText.setVerticalAlignment(SwingConstants.BOTTOM);
        centerText.setFont(new Font("LINUX", Font.PLAIN, 20));
        centerText.setForeground(Color.decode("#e3e3e3"));
        header.add(centerText);


        //Cuerpo
        panel.add(body);
        body.setBounds(panel.getX(),125,this.getWidth(),this.getHeight()/2);
        body.setBackground(Color.decode("#cecece"));


        out1.setText("Out1 = n");
        out1.setBounds(0,padding,100,padding);
        out1.setFont(new Font("LINUX", Font.PLAIN, 16));
        body.add(out1);


        out2.setText("Out2 = n");
        out2.setBounds(0,padding*2,100,padding);
        out2.setFont(new Font("LINUX", Font.PLAIN, 16));
        body.add(out2);

        out3.setText("Out3 = n");
        out3.setBounds(0,padding*3,100,20);
        out3.setFont(new Font("LINUX", Font.PLAIN, 16));
        body.add(out3);


        out4.setText("Out4 = n");
        out4.setBounds(0,padding*4,100,padding);
        out4.setFont(new Font("LINUX", Font.PLAIN, 16));
        body.add(out4);


        out5.setText("Out5 = n");
        out5.setBounds(0,padding*5,100,padding);
        out5.setFont(new Font("LINUX", Font.PLAIN, 16));
        body.add(out5); */

        
        
    }

/*     public void images(){
        try {
            BufferedImage img = ImageIO.read(new File(IMG_PATH));
            ImageIcon icon = new ImageIcon(img);
            JLabel label = new JLabel(icon);
            JOptionPane.showMessageDialog(null, label);
         } catch (IOException e) {
            e.printStackTrace();
         }
    } */

}
