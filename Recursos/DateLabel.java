package Recursos;

import javax.swing.JLabel;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.Timer;

public class DateLabel extends JLabel implements ActionListener{

    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    
    public DateLabel(){
        LocalTime myClock = LocalTime.now();
        String date;


        date = String.valueOf(myClock);

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
