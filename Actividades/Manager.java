package Actividades;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;


//import javafx.*; Ver despues
//https://docs.oracle.com/javase/8/javafx/layout-tutorial/builtin_layouts.htm
import java.awt.event.ActionListener;//para los eventos
import java.awt.event.ActionEvent;//para los eventos

import Recursos.Button;

public class Manager extends SuperActividades{

    JPanel jp = new JPanel();
    JLabel Lbtitle = new JLabel();
    JButton btnAct = new JButton();

    Actividad_1 act = new Actividad_1();

    public Manager() {
        /*BORDES */
        /*https://docs.oracle.com/javase/tutorial/uiswing/components/border.html */
        Border loweredetched;
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    
        act.setVisible(false);
        
        setVisible(true);
        setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jp.setBounds(0,0,200,200);
        ponerPanel(jp);
        jp.setBorder(loweredetched);
        //jp.setForeground(Color.green);

        addActividad("Presupuesto 1",100,50);
        //addActividad("Presupuesto 2",100,200);

    }

    public void addActividad(String title, int posX, int posY) {
        Lbtitle.setText(title);
        Lbtitle.setBounds(posX, posY, 200, 20);
        Lbtitle.setVisible(true);

        btnAct.setText("Ir");
        btnAct.setBounds(posX+100,posY+50,100,30);
        jp.add(btnAct);

        jp.add(Lbtitle);
        jp.add(btnAct);
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


}
