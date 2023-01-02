package Actividades;

import java.awt.Font;
import java.awt.Color;


import java.time.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;


//import javafx.*; Ver despues
//https://docs.oracle.com/javase/8/javafx/layout-tutorial/builtin_layouts.htm
import java.awt.event.ActionListener;//para los eventos
import java.awt.event.ActionEvent;//para los eventos



public class Manager extends SuperActividades{

    JPanel jp = new JPanel();
    JPanel colIzq = new JPanel();

    Actividad_1 act = new Actividad_1();

    public Manager() {
        /*BORDES */
        /*https://docs.oracle.com/javase/tutorial/uiswing/components/border.html */
/*         Border loweredetched;
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED); */
    
        act.setVisible(false);
        
        setVisible(true);
        setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jp.setBounds(0,0,200,200);
        jp.setBackground(Color.decode("#cecece"));

        gui();
        addActividad("Presupuesto 1", "Lorem ipsum sit amet...",0);
        addActividad("Presupuesto 2", "Lorem ipsum sit amet 2 ...",200);
        ponerPanel(jp);

        //jp.setBorder(loweredetched);
        //jp.setForeground(Color.green);

    }

    public void addActividad(String title, String txt, int y) {
        Border loweredetched;
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        JPanel actividad = new JPanel();
        JLabel lbTitle = new JLabel();
        JLabel lbText = new JLabel();
        JButton btnAct = new JButton();


        int padding = 30;
        actividad.setBounds(colIzq.getWidth(),y, this.getWidth(),200);
        actividad.setBorder(loweredetched);
        //Titulo
        lbTitle.setText(title);
        lbTitle.setBounds(padding, padding, 200, 20);
        lbTitle.setFont(new Font("LINUX", Font.BOLD, 20));

        //Texto
        lbText.setBounds(lbTitle.getX(), lbTitle.getY() + padding + padding/3 , actividad.getWidth(),20);
        lbText.setText(txt);
        lbText.setFont(new Font("LINUX", Font.PLAIN, 16));
        lbText.setForeground(Color.decode("#7e7e7e"));
        

        btnAct.setText("Ir");
        btnAct.setBounds(actividad.getHeight(),actividad.getHeight()-padding-padding/2,100,30);


        //Agregar al panel
        actividad.add(btnAct);
        actividad.add(lbTitle);
        actividad.add(lbText);
        actividad.add(btnAct);
        ponerPanel(actividad);
        btnAct.addActionListener(click);

        
    }
    public void changeStatus(boolean b, SuperActividades sa){
        sa.setVisible(b);//Admite como parametro a SuperActividades y por lo tanto a sus hijos, por lo que me permite hacer que cada boton llame a un hijo distinto

    }

    ActionListener click = new ActionListener(){
        @Override
          public void actionPerformed(ActionEvent ae){
          System.out.println("Click");
          changeStatus(true, act);
        }
        
    };

    public void gui(){
        LocalTime myClock = LocalTime.now();
        System.out.println(myClock);
        JLabel hora = new JLabel();

        colIzq.setVisible(true);
        colIzq.setBounds(0,0,this.getWidth()/10, this.getHeight());
        colIzq.setBackground(Color.decode("#d89e9e"));

        hora.setBounds(colIzq.getX(), colIzq.getY(),colIzq.getWidth(),40);
        hora.setHorizontalAlignment(SwingConstants.CENTER);
        hora.setVerticalAlignment(SwingConstants.BOTTOM);
        hora.setFont(new Font("LINUX", Font.PLAIN, 20));
        hora.setText("00:00");

        colIzq.add(hora);
        ponerPanel(colIzq);
    }

}
