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
    

    //private static final String IMG_PATH = "../images/image01.png";


    public Area(){
        
        imprimirArea.setVisible(true);
        imprimirArea.setAlwaysOnTop (true);
        imprimirArea.ponerPanel(panel);
        
        
        this.setEditable(false);
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
        final int padding = 20;


        //cabezal
        header.setBounds(0,0,this.getWidth(),this.getHeight()/4);
        header.setBackground(Color.decode("#c66d6d"));
        //texto dentro del cabezal
        centerText.setText("Lorem Ipsum dolor");
        centerText.setBounds(0, header.getHeight()-40, header.getWidth(), 30);
        centerText.setHorizontalAlignment(SwingConstants.CENTER);
        centerText.setVerticalAlignment(SwingConstants.BOTTOM);
        centerText.setFont(new Font("LINUX", Font.PLAIN, 20));
        centerText.setForeground(Color.decode("#e3e3e3"));

        //Cuerpo
        body.setBounds(panel.getX(),panel.getY()+header.getHeight(),this.getWidth(),this.getHeight()/2);
        body.setBackground(Color.decode("#cecece"));

        out1.setText("Out1 = n");
        out1.setBounds(0,20,20,20);
        out1.setFont(new Font("LINUX", Font.PLAIN, 16));

        out2.setText("Out2 = n");
        out2.setBounds(padding,40,this.getWidth(),padding);
        out2.setFont(new Font("LINUX", Font.PLAIN, 16));

        out3.setText("Out3 = n");
        out3.setBounds(0,60,this.getWidth(),padding);
        out3.setFont(new Font("LINUX", Font.PLAIN, 16));

        out4.setText("Out4 = n");
        out4.setBounds(0,padding*7,this.getWidth(),padding);
        out4.setFont(new Font("LINUX", Font.PLAIN, 16));

        out5.setText("Out5 = n");
        out5.setBounds(0,padding*9,this.getWidth(),padding);
        out5.setFont(new Font("LINUX", Font.PLAIN, 16));

        
        panel.add(body);
        panel.add(header);
        header.add(centerText);
        body.add(out1);
        body.add(out2);
        body.add(out3);
        body.add(out4);
        body.add(out5);

        
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
