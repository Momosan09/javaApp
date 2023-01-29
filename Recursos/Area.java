package Recursos;

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

import java.time.LocalDate; // import the LocalDate class

public class Area extends JTextArea {

    Window imprimirArea = new Window();
    JPanel panel = new JPanel();
    LocalDate date = LocalDate.now(); // Create a date object

    // labels
    public JLabel centerText = new JLabel();
    public JLabel reciclame = new JLabel();
    public JLabel out1 = new JLabel();
    public JLabel out2 = new JLabel();
    public JLabel out3 = new JLabel();
    public JLabel out4 = new JLabel();
    public JLabel out5 = new JLabel();
    public JTextArea anotaciones = new JTextArea();
    public JLabel nameInFooter = new JLabel();
    public JLabel direccion = new JLabel();
    // private static final String IMG_PATH = "../images/image01.png";

    public Area() {

        imprimirArea.setVisible(true);
        imprimirArea.setAlwaysOnTop(false);
        imprimirArea.ponerPanel(panel);

        // this.setEditable(false);
        this.setBounds(0, 0, 500, 500);
        this.setVisible(true);
        gui();
        // panel.add(this);
    }

    public void fill(JComponent c) {
        this.add(c);
    }

    public void gui() {
        JPanel header = new JPanel();
        JPanel body = new JPanel();
        JPanel footer = new JPanel();
        DateLabel day = new DateLabel("date");
        DateLabel hour = new DateLabel("hMS");
        int padding = 25;

        header.setBounds(0, 0, this.getWidth(), this.getHeight() / 4);
        header.setBackground(Color.decode("#c66d6d"));
        header.setLayout(null);
        panel.add(header);

        body.setBounds(panel.getX(), 125, this.getWidth(), this.getHeight() / 2);
        body.setBackground(Color.decode("#cecece"));
        body.setLayout(null);
        panel.add(body);

        footer.setBounds(panel.getX(), 375, this.getWidth(), 125);
        footer.setBackground(Color.decode("#2f3030"));
        footer.setLayout(null);
        panel.add(footer);

        // HEADER
        centerText.setText("Presupuesto Calculado");
        centerText.setBounds(0, header.getHeight() - 40, header.getWidth(), 30);
        centerText.setFont(new Font("LINUX", Font.PLAIN, 20));
        centerText.setHorizontalAlignment(SwingConstants.CENTER);
        centerText.setForeground(Color.decode("#e3e3e3"));
        header.add(centerText);

        // RECICLAME
        reciclame.setText("No me tires en cualquier lado, ¡reciclame!");
        reciclame.setBounds(-20, 0, this.getWidth(), 20);
        reciclame.setHorizontalAlignment(SwingConstants.RIGHT);
        header.add(reciclame);

        // BODY
        out1.setText("Out1 = n");
        out1.setBounds(5, padding, this.getWidth(), padding);
        out1.setFont(new Font("LINUX", Font.PLAIN, 16));
        body.add(out1);

        out2.setText("Out2 = n");
        out2.setBounds(5, padding * 2, this.getWidth(), padding);
        out2.setFont(new Font("LINUX", Font.PLAIN, 16));
        body.add(out2);

        out3.setText("Out3 = n");
        out3.setBounds(5, padding * 3, this.getWidth(), padding);
        out3.setFont(new Font("LINUX", Font.PLAIN, 16));
        body.add(out3);

        out4.setText("Out4 = n");
        out4.setBounds(5, padding * 4, this.getWidth(), padding);
        out4.setFont(new Font("LINUX", Font.PLAIN, 16));
        body.add(out4);

        out5.setText("Out5 = n");
        out5.setBounds(5, padding * 5, this.getWidth(), padding);
        out5.setFont(new Font("LINUX", Font.PLAIN, 16));
        body.add(out5);

        anotaciones.setBounds(5, padding * 7, this.getWidth() - 25, 70);
        anotaciones.setLineWrap(true);
        anotaciones.setWrapStyleWord(true);
        anotaciones.setFont(new Font("LINUX", Font.PLAIN, 16));
        anotaciones.setEditable(false);
        anotaciones.setBackground(Color.decode("#cecece"));
        body.add(anotaciones);

        // FOOTER
        // Fecha
        day.setBounds(5, padding * 2, 100, 20);
        day.setForeground(Color.decode("#e3e3e3"));
        footer.add(day);
        // Nombre
        nameInFooter.setText("Rotapol decoraciones");
        nameInFooter.setBounds(0, footer.getHeight() / 2, this.getWidth(), 20);
        nameInFooter.setHorizontalAlignment(SwingConstants.CENTER);
        nameInFooter.setVerticalAlignment(SwingConstants.CENTER);
        nameInFooter.setForeground(Color.decode("#e3e3e3"));
        footer.add(nameInFooter);
        //Hora
        hour.setBounds(this.getWidth() - (padding * 3), padding * 2, 100, 20);
        hour.setForeground(Color.decode("#e3e3e3"));
        footer.add(hour);
        //Direccion
        direccion.setText("Av.Alvarez Jonte 4837");
        direccion.setBounds(0, footer.getHeight() / 4, this.getWidth(), 20);
        direccion.setHorizontalAlignment(SwingConstants.CENTER);
        direccion.setVerticalAlignment(SwingConstants.CENTER);
        direccion.setForeground(Color.decode("#e3e3e3"));
        footer.add(direccion);


    }

    /*
     * public void images(){
     * try {
     * BufferedImage img = ImageIO.read(new File(IMG_PATH));
     * ImageIcon icon = new ImageIcon(img);
     * JLabel label = new JLabel(icon);
     * JOptionPane.showMessageDialog(null, label);
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * }
     */

}
