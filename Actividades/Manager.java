package Actividades;

import java.awt.Font;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import Recursos.DateLabel;

//import javafx.*; Ver despues
//https://docs.oracle.com/javase/8/javafx/layout-tutorial/builtin_layouts.htm
import java.awt.event.ActionListener;//para los eventos
import java.awt.event.ActionEvent;//para los eventos



public class Manager extends SuperActividades{

    JPanel jp = new JPanel();
    JPanel colIzq = new JPanel();

    Actividad_1 act1 = new Actividad_1();

    public Manager() {
        /*BORDES */
        /*https://docs.oracle.com/javase/tutorial/uiswing/components/border.html */
/*         Border loweredetched;
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED); */
    
        act1.setVisible(false);
        
        setVisible(true);
        setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jp.setBounds(0,0,200,200);
        jp.setBackground(Color.decode("#cecece"));

        gui();
        addActividad("Presupuesto 1", "Lorem ipsum sit amet 1 ...",0);
        addActividad("Presupuesto 2", "Lorem ipsum sit amet 2 ...",200);
        addActividad("Presupuesto 3", "Lorem ipsum sit amet 3 ...",400);
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
          changeStatus(true, act1);
        }
        
    };

    public void gui(){
        Border loweredetched, loweredbevel;
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        loweredbevel = BorderFactory.createLoweredBevelBorder();
/*         LocalTime myClock = LocalTime.now();
        System.out.println(myClock);
        JLabel hora = new JLabel();
        String date;

        date = String.valueOf(myClock); */

        colIzq.setVisible(true);
        colIzq.setBounds(0,0,this.getWidth()/10, this.getHeight());
        colIzq.setBackground(Color.decode("#d89e9e"));

        JPanel tasks = new JPanel();

        tasks.setVisible(true);
        tasks.setBounds(0,colIzq.getHeight()/3,colIzq.getWidth(),colIzq.getHeight()/2);
        tasks.setBackground(Color.decode("#2da3c6"));
        colIzq.add(tasks);

        JPanel nombreAbajo = new JPanel();
        nombreAbajo.setVisible(true);
        nombreAbajo.setBounds(0,this.getHeight()-(this.getHeight()/10),colIzq.getWidth(),100);
        nombreAbajo.setBackground(Color.decode("#bc5454"));
        nombreAbajo.setBorder(loweredbevel);
        colIzq.add(nombreAbajo);

        JLabel nombreAbajoLabel = new JLabel();
        nombreAbajoLabel.setText("R O T A P O L");
        nombreAbajoLabel.setForeground(Color.decode("#e3e3e3"));
        nombreAbajoLabel.setFont(new Font("LINUX", Font.BOLD, 20));
        nombreAbajoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nombreAbajoLabel.setVerticalAlignment(SwingConstants.CENTER);
        nombreAbajoLabel.setBounds(0,0,nombreAbajo.getWidth(),0);
        nombreAbajo.add(nombreAbajoLabel);


/* 
        hora.setBounds(colIzq.getX(), colIzq.getY(),colIzq.getWidth(),40);
        hora.setHorizontalAlignment(SwingConstants.CENTER);
        hora.setVerticalAlignment(SwingConstants.BOTTOM);
        hora.setFont(new Font("LINUX", Font.PLAIN, 20));
        hora.setText(date);


        colIzq.add(hora); */
        DateLabel dtlb = new DateLabel("hMS");
        dtlb.setBounds(colIzq.getX(), colIzq.getY(),colIzq.getWidth(),40);
        dtlb.setHorizontalAlignment(SwingConstants.CENTER);
        dtlb.setVerticalAlignment(SwingConstants.BOTTOM);
        dtlb.setFont(new Font("LINUX", Font.PLAIN, 26));
        dtlb.setForeground(Color.decode("#000"));
        
        ponerPanel(colIzq);
        colIzq.add(dtlb);
    }

}
