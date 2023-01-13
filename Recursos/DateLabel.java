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
            /*La hora escrita en mayuscula es el formato de 24 horas y en minuscula el de 12 horas, con los minutos y segundos funciona de manera extraña */
            case "hM" : sdf =  new SimpleDateFormat("HH:mm");break;
            case "hMS" : sdf =  new SimpleDateFormat("HH:mm:ss");break;
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
