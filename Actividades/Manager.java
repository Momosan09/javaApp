package Actividades;

import java.awt.Font;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import Recursos.DateLabel;

import Database.*;

//import javafx.*; Ver despues
//https://docs.oracle.com/javase/8/javafx/layout-tutorial/builtin_layouts.htm
import java.awt.event.ActionListener;//para los eventos
import java.sql.Connection;
import java.awt.event.ActionEvent;//para los eventos



public class Manager extends SuperActividades{

    Connect cc = new Connect();
    Connection cn = cc.conectar();

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
        setResizable(true);

        //setBounds(0,0,1000,700);
        

        jp.setBounds(0,0,200,200);
        jp.setBackground(Color.decode("#cecece"));

        gui();
        addActividad("Cortinados", "Para calcular cortinados",0);
        addActividad("Roller", "Para calcular roller",200);

        //addActividad("Presupuesto 3", "Lorem ipsum sit amet 3 ...",400);
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
        JLabel lbPresupuestosTotales = new JLabel();
        JButton btnAct = new JButton();
        JButton btnDB = new JButton();


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

        btnDB.setText("Data Base");
        btnDB.setBounds(320,btnAct.getY(),100,30);

        
        lbPresupuestosTotales.setBounds(500, btnAct.getY(), actividad.getWidth(), 20);
        lbPresupuestosTotales.setText("Presupuestos Totales = " + cc.getIndex());
        lbPresupuestosTotales.setHorizontalAlignment(SwingConstants.CENTER);
        lbPresupuestosTotales.setVerticalAlignment(SwingConstants.CENTER);

        //Agregar al panel
        actividad.add(btnAct);
        actividad.add(lbTitle);
        actividad.add(lbText);
        actividad.add(lbPresupuestosTotales);
        actividad.add(btnAct);
        actividad.add(btnDB);
        ponerPanel(actividad);
        btnAct.addActionListener(click);
        btnDB.addActionListener(clickDB);

        
    }
    public void changeStatus(boolean b, SuperActividades sa){
        sa.setVisible(b);//Admite como parametro a SuperActividades y por lo tanto a sus hijos, por lo que me permite hacer que cada boton llame a un hijo distinto

    }

    ActionListener click = new ActionListener(){
        @Override
          public void actionPerformed(ActionEvent ae){
          //System.out.println("Click");
          changeStatus(true, act1);

        }
        
    };
    ActionListener clickDB = new ActionListener(){
        @Override
          public void actionPerformed(ActionEvent ae){
          //System.out.println("Click");
          

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
        colIzq.setBounds(0,0,this.getWidth()/8, this.getHeight());
        colIzq.setBackground(Color.decode("#ef233e"));
        
        JLabel precioDelDIa = new JLabel();
        precioDelDIa.setVisible(true);
        precioDelDIa.setText("Precio del dia");
        precioDelDIa.setBounds(0,100,this.getWidth(),20);
        precioDelDIa.setFont(new Font("LINUX", Font.BOLD, 20));
/*         precioDelDIa.setHorizontalAlignment(SwingConstants.CENTER);
        precioDelDIa.setVerticalAlignment(SwingConstants.CENTER); */
        colIzq.add(precioDelDIa);

        JTextField precioDelDiaTxf = new JTextField();
        precioDelDiaTxf.setBounds(10,120,150,20);
        colIzq.add(precioDelDiaTxf);
        

        JPanel tasks = new JPanel();

        tasks.setVisible(true);
        tasks.setBounds(0,colIzq.getHeight()/3,colIzq.getWidth(),colIzq.getHeight()/2);
        tasks.setBackground(Color.decode("#d89e9e"));
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

    public void dataBaseGui(){

    }

}
