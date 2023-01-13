package Recursos;

import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Timer;

public class DateLabel extends JLabel implements ActionListener{

    SimpleDateFormat sdf;
    
    public DateLabel(String format){

        switch(format){
            case "hM" : sdf =  new SimpleDateFormat("HH:MM");break; //Escrito en mayusculas formato de 24hs, esctrio en minusculas formato de 12hs
            case "hMS" : sdf =  new SimpleDateFormat("HH:MM:ss");break;
            case "date" : sdf =  new SimpleDateFormat("DD/MM/YYYY");break;
            default : this.setText("hM - hMS - date");break;
        }
        Timer timer = new Timer(1000, this);
        timer.start();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Date d = new Date();
        this.setText(sdf.format(d));
        
    }
}
